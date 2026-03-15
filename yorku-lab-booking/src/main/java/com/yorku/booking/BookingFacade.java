package com.yorku.booking;

import java.util.HashMap;
import java.util.Map;

import com.yorku.equipment.Equipment;
import com.yorku.users.User;

public class BookingFacade {

    private BookingService bookingService = new BookingService();

    // Track reservations: user -> (equipment -> hours)
    private Map<User, Map<Equipment, Integer>> reservations = new HashMap<>();

    // Reserve equipment
    public void reserveEquipment(User user, Equipment equipment, int hours) {

        if (!equipment.isAvailable()) {
            System.out.println("Equipment not available.");
            return;
        }

        double deposit = user.getHourlyRate();
        System.out.println("Deposit paid: $" + deposit);

        bookingService.reserve();

        double totalCost = user.getHourlyRate() * hours;
        System.out.println("Total cost: $" + totalCost);

        equipment.setAvailable(false);

        // Record the reservation
        reservations.putIfAbsent(user, new HashMap<>());
        reservations.get(user).put(equipment, hours);
    }

    // Cancel reservation
    public void cancelReservation(User user, Equipment equipment) {

        if (!reservations.containsKey(user) || !reservations.get(user).containsKey(equipment)) {
            System.out.println("No existing reservation to cancel for " + equipment.getDescription());
            return;
        }

        System.out.println("Reservation canceled for " + user.getEmail() +
                " on " + equipment.getDescription());

        equipment.setAvailable(true);

        bookingService.cancel();

        // Remove reservation record
        reservations.get(user).remove(equipment);
        if (reservations.get(user).isEmpty()) {
            reservations.remove(user);
        }
    }

    // Extend reservation
    public void extendReservation(User user, Equipment equipment, int additionalHours) {

        if (!reservations.containsKey(user) || !reservations.get(user).containsKey(equipment)) {
            System.out.println("Cannot extend: no existing reservation for " + equipment.getDescription());
            return;
        }

        int currentHours = reservations.get(user).get(equipment);
        int newHours = currentHours + additionalHours;
        reservations.get(user).put(equipment, newHours);

        double additionalCost = user.getHourlyRate() * additionalHours;
        System.out.println("Reservation extended by " + additionalHours +
                " hour(s). Additional cost: $" + additionalCost);

        bookingService.reserve();
    }
}