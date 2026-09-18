package com.eventhub.domain.reservation;

import com.eventhub.domain.event.Event;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ReservationTest {

    private Event createValidEvent() {
        return new Event(
                "Java Conference",
                "Java event",
                "Medellin",
                LocalDateTime.of(2026, 10, 10, 9, 0),
                LocalDateTime.of(2026, 10, 10, 17, 0),
                100,
                new BigDecimal("50.00"));
    }

    @Test
    void shouldCreateReservationAsPending() {
        Event event = createValidEvent();

        Reservation reservation = new Reservation(event, 2);

        assertEquals(ReservationStatus.PENDING, reservation.getStatus());
    }

    @Test
    void shouldRejectZeroAttendeeQuantity() {
        Event event = createValidEvent();

        assertThrows(
                IllegalArgumentException.class,
                () -> new Reservation(event, 0));
    }

    @Test
    void shouldRejectNegativeAttendeeQuantity() {
        Event event = createValidEvent();

        assertThrows(
                IllegalArgumentException.class,
                () -> new Reservation(event, -1));
    }

    @Test
    void shouldRejectNullEvent() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Reservation(null, 1));
    }

    @Test
    void shouldConfirmPendingReservation() {
        Event event = createValidEvent();

        Reservation reservation = new Reservation(event, 2);
        reservation.confirm();

        assertEquals(ReservationStatus.CONFIRMED, reservation.getStatus());
    }

    @Test
    void shouldCancelReservation() {
        Event event = createValidEvent();

        Reservation reservation = new Reservation(event, 2);
        reservation.cancel();

        assertEquals(ReservationStatus.CANCELLED, reservation.getStatus());
    }

    @Test
    void shouldRejectConfirmingCancelledReservation() {
        Event event = createValidEvent();

        Reservation reservation = new Reservation(event, 2);
        reservation.cancel();

        assertThrows(
                IllegalStateException.class,
                () -> reservation.confirm());
    }

    @Test 
    void shouldRejectConfirmingConfirmedReservation() {
        Event event = createValidEvent();

        Reservation reservation = new Reservation(event, 2);
        reservation.confirm();

        assertThrows(
                IllegalStateException.class,
                () -> reservation.confirm());
    }

    @Test 
    void shouldRejectCancellingAlreadyCancelledReservation() {
        Event event = createValidEvent();

        Reservation reservation = new Reservation(event, 2);
        reservation.cancel();

        assertThrows(
                IllegalStateException.class,
                () -> reservation.cancel());
    }

}
