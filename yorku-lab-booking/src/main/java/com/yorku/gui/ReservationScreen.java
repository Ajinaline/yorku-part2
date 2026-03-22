package com.yorku.gui;

import com.yorku.booking.BookingFacade;
import com.yorku.coordinator.LabManager;
import com.yorku.equipment.Equipment;
import com.yorku.users.User;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ReservationScreen {

    private Stage stage;
    private User user;
    private LabManager labManager;
    private LoginScreen loginScreen;
    private BookingFacade bookingFacade;

    public ReservationScreen(Stage stage, User user, LabManager labManager, LoginScreen loginScreen) {
        this.stage = stage;
        this.user = user;
        this.labManager = labManager;
        this.loginScreen = loginScreen;
        this.bookingFacade = new BookingFacade(); // single instance
    }

    public void show() {

        Label title = new Label("Reserve Equipment");

        ComboBox<String> equipmentList = new ComboBox<>();
        refreshEquipmentList(equipmentList);

        TextField hoursField = new TextField();
        hoursField.setPromptText("Hours");

        Button reserveBtn = new Button("Reserve");
        Button cancelBtn = new Button("Cancel Booking");
        Button extendBtn = new Button("Extend Booking");
        Button backBtn = new Button("Back");

        // --- Reserve Equipment ---
        reserveBtn.setOnAction(e -> {
            Equipment eq = getSelectedEquipment(equipmentList);
            if (eq == null) return;

            try {
                int hours = Integer.parseInt(hoursField.getText());
                bookingFacade.reserveEquipment(user, eq, hours);
                new Alert(Alert.AlertType.INFORMATION, "Reservation successful!").show();
                refreshEquipmentList(equipmentList);
            } catch (NumberFormatException ex) {
                new Alert(Alert.AlertType.ERROR, "Enter a valid number of hours").show();
            } catch (Exception ex) {
                new Alert(Alert.AlertType.ERROR, "Reservation failed").show();
            }
        });

        // --- Cancel Booking ---
        cancelBtn.setOnAction(e -> {
            Equipment eq = getSelectedEquipment(equipmentList);
            if (eq == null) return;

            try {
                bookingFacade.cancelReservation(user, eq);
                new Alert(Alert.AlertType.INFORMATION, "Booking canceled!").show();
                refreshEquipmentList(equipmentList);
            } catch (Exception ex) {
                new Alert(Alert.AlertType.ERROR, "Cancellation failed").show();
            }
        });

        // --- Extend Booking ---
        extendBtn.setOnAction(e -> {
            Equipment eq = getSelectedEquipment(equipmentList);
            if (eq == null) return;

            try {
                int extraHours = Integer.parseInt(hoursField.getText());
                bookingFacade.extendReservation(user, eq, extraHours);
                new Alert(Alert.AlertType.INFORMATION, "Booking extended!").show();
                refreshEquipmentList(equipmentList);
            } catch (NumberFormatException ex) {
                new Alert(Alert.AlertType.ERROR, "Enter valid number of hours").show();
            } catch (Exception ex) {
                new Alert(Alert.AlertType.ERROR, "Extension failed").show();
            }
        });

        // --- Back Button ---
        backBtn.setOnAction(e -> loginScreen.show());

        VBox layout = new VBox(10, title, equipmentList, hoursField, reserveBtn, cancelBtn, extendBtn, backBtn);
        layout.setStyle("-fx-padding: 15;");

        stage.setScene(new Scene(layout, 400, 300));
        stage.show();
    }

    // --- Helper to refresh equipment list ---
    private void refreshEquipmentList(ComboBox<String> equipmentList) {
        equipmentList.getItems().clear();
        for (Equipment eq : labManager.getAvailableEquipment()) {
            String status = eq.isAvailable() ? "Available" : "Booked";
            equipmentList.getItems().add(eq.getId() + " - " + eq.getDescription() + " [" + status + "]");
        }
    }

    // --- Helper to get the selected Equipment object ---
    private Equipment getSelectedEquipment(ComboBox<String> equipmentList) {
        String selected = equipmentList.getValue();
        if (selected == null) {
            new Alert(Alert.AlertType.ERROR, "Select equipment").show();
            return null;
        }
        String eqId = selected.split(" - ")[0];
        return labManager.getEquipmentById(eqId);
    }
}