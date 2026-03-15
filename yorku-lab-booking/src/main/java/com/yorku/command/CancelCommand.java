package com.yorku.command;

import com.yorku.booking.BookingFacade;
import com.yorku.equipment.Equipment;
import com.yorku.users.User;

public class CancelCommand implements Command {

    private BookingFacade booking;
    private User user;
    private Equipment equipment;

    // Constructor matches the GUI usage
    public CancelCommand(BookingFacade booking, User user, Equipment equipment) {
        this.booking = booking;
        this.user = user;
        this.equipment = equipment;
    }

    @Override
    public void execute() {
        // Call the booking facade to cancel this reservation
        booking.cancelReservation(user, equipment);
    }
}