package com.eventhub.domain.reservation;

import com.eventhub.domain.event.Event;

public class Reservation {
    private Long id;
    private Event event;
    private int attendeeQuantity;
    private ReservationStatus status;

    public Reservation(Event event, int attendeeQuantity) {

        if (attendeeQuantity <= 0) {
            throw new IllegalArgumentException("Attendee quantity must be greater than zero");
        }

        if (event == null) {
            throw new IllegalArgumentException("Event cannot be null");
        }

        this.event = event;
        this.attendeeQuantity = attendeeQuantity;
        this.status = ReservationStatus.PENDING;
    }

    public void confirm() {
        if (status != ReservationStatus.PENDING) {
            throw new IllegalStateException("Reservation can only be confirmed if it is in PENDING status.");
        }

        this.status = ReservationStatus.CONFIRMED;
    }

    public void cancel() {
        if (status == ReservationStatus.CANCELLED) {
            throw new IllegalStateException("Reservation is already cancelled.");
        }
        this.status = ReservationStatus.CANCELLED;
    }

    public Long getId() {
        return id;
    }

    public Event getEvent() {
        return event;
    }

    public int getAttendeeQuantity() {
        return attendeeQuantity;
    }

    public ReservationStatus getStatus() {
        return status;
    }
}
