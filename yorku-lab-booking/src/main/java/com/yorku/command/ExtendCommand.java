package com.yorku.command;

import com.yorku.booking.BookingFacade;
import com.yorku.equipment.Equipment;
import com.yorku.users.User;

public class ExtendCommand implements Command {

    private BookingFacade booking;
    private User user;
    private Equipment equipment;
    private int additionalHours;

    // Constructor matching GUI usage
    public ExtendCommand(BookingFacade booking, User user, Equipment equipment, int additionalHours) {
        this.booking = booking;
        this.user = user;
        this.equipment = equipment;
        this.additionalHours = additionalHours;
    }

    @Override
    public void execute() {
        // Call the BookingFacade to extend the reservation
        booking.extendReservation(user, equipment, additionalHours);
    }
}