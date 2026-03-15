package com.yorku.coordinator;

public class HeadLabCoordinator {

    private static HeadLabCoordinator instance;

    private HeadLabCoordinator() {}

    public static HeadLabCoordinator getInstance() {
        if (instance == null) {
            instance = new HeadLabCoordinator();
        }
        return instance;
    }

    // Generate a lab manager
    public LabManager generateLabManager(String name) {
        LabManager manager = new LabManager(name);
        System.out.println("Lab manager account created for: " + name);
        return manager;
    }
}