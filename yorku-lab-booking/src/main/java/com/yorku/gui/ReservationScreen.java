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

    public ReservationScreen(Stage stage, User user, LabManager labManager) {
        this.stage = stage;
        this.user = user;
        this.labManager = labManager;
    }

    public void show() {
        Label title = new Label("Reserve Equipment");

        ComboBox<String> equipmentList = new ComboBox<>();
        refreshEquipmentList(equipmentList);

        TextField hoursField = new TextField();
        hoursField.setPromptText("Hours");

        Button reserveBtn = new Button("Reserve");

        reserveBtn.setOnAction(e -> {
            String selected = equipmentList.getValue();
            if (selected == null) {
                new Alert(Alert.AlertType.ERROR, "Select equipment").show();
                return;
            }

            String id = selected.split(" - ")[0];
            Equipment equipment = labManager.getEquipment(id);

            int hours;
            try {
                hours = Integer.parseInt(hoursField.getText());
            } catch (NumberFormatException ex) {
                new Alert(Alert.AlertType.ERROR, "Invalid hours").show();
                return;
            }

            BookingFacade booking = new BookingFacade();
            booking.reserveEquipment(user, equipment, hours);

            new Alert(Alert.AlertType.INFORMATION, "Reservation successful!").show();

            // Refresh after reservation
            refreshEquipmentList(equipmentList);
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(title, equipmentList, hoursField, reserveBtn);
        layout.setStyle("-fx-padding: 15;");

        stage.setScene(new Scene(layout, 400, 250));
        stage.show();
    }

    private void refreshEquipmentList(ComboBox<String> comboBox) {
        comboBox.getItems().clear();
        for (Equipment eq : labManager.getAvailableEquipment()) {
            comboBox.getItems().add(eq.getId() + " - " + eq.getDescription());
        }
    }
}