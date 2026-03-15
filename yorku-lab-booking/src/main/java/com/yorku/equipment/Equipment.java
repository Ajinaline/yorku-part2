package com.yorku.equipment;

public class Equipment implements Cloneable {

    private String id;
    private String description;
    private String location;
    private boolean available = true;

    public Equipment(String id, String description, String location) {
        this.id = id;
        this.description = description;
        this.location = location;
    }

    // Prototype: clone
    @Override
    public Equipment clone() {
        try {
            return (Equipment) super.clone();
        } catch(CloneNotSupportedException e) {
            return null;
        }
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean status) {
        this.available = status;
    }

    public String getId() { return id; }
    public String getDescription() { return description; }
    public void setDescription(String desc) { this.description = desc; }

    public String getLocation() { return location; }
    public void setLocation(String loc) { this.location = loc; }
}