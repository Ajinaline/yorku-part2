package com.yorku.gui;

import com.yorku.coordinator.LabManager;
import com.yorku.equipment.Equipment;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LabManagerScreen {

    private Stage stage;
    private LabManager manager;

    public LabManagerScreen(Stage stage, LabManager manager) {
        this.stage = stage;
        this.manager = manager;
    }

    public void show() {

        Label title = new Label("Lab Manager Dashboard: " + manager.getName());

        // Input fields for adding new equipment
        TextField idField = new TextField();
        idField.setPromptText("Equipment ID");

        TextField descField = new TextField();
        descField.setPromptText("Description");

        TextField locField = new TextField();
        locField.setPromptText("Lab Location");

        Button addBtn = new Button("Add Equipment");

        // Dropdown to select equipment for actions
        ComboBox<String> equipmentList = new ComboBox<>();
        Button enableBtn = new Button("Enable");
        Button disableBtn = new Button("Disable");
        Button maintenanceBtn = new Button("Mark for Maintenance");

        addBtn.setOnAction(e -> {
            String id = idField.getText();
            String desc = descField.getText();
            String loc = locField.getText();

            if (id.isEmpty() || desc.isEmpty() || loc.isEmpty()) {
                new Alert(Alert.AlertType.ERROR, "Please fill in all fields").show();
                return;
            }

            Equipment eq = new Equipment(id, desc, loc);
            manager.addEquipment(eq);
            new Alert(Alert.AlertType.INFORMATION, "Equipment added: " + desc).show();

            // Update ComboBox
            equipmentList.getItems().add(id);
        });

        enableBtn.setOnAction(e -> {
            String id = equipmentList.getValue();
            if (id == null) {
                new Alert(Alert.AlertType.ERROR, "Select equipment to enable").show();
                return;
            }
            manager.enableEquipment(id);
            new Alert(Alert.AlertType.INFORMATION, "Equipment enabled: " + id).show();
        });

        disableBtn.setOnAction(e -> {
            String id = equipmentList.getValue();
            if (id == null) {
                new Alert(Alert.AlertType.ERROR, "Select equipment to disable").show();
                return;
            }
            manager.disableEquipment(id);
            new Alert(Alert.AlertType.INFORMATION, "Equipment disabled: " + id).show();
        });

        maintenanceBtn.setOnAction(e -> {
            String id = equipmentList.getValue();
            if (id == null) {
                new Alert(Alert.AlertType.ERROR, "Select equipment to mark for maintenance").show();
                return;
            }
            manager.markForMaintenance(id);
            new Alert(Alert.AlertType.INFORMATION, "Equipment marked for maintenance: " + id).show();
        });

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(15));
        layout.getChildren().addAll(
                title,
                new Label("Add New Equipment:"),
                idField, descField, locField, addBtn,
                new Label("Manage Existing Equipment:"),
                equipmentList,
                enableBtn, disableBtn, maintenanceBtn
        );

        stage.setScene(new Scene(layout, 400, 500));
        stage.show();
    }
}