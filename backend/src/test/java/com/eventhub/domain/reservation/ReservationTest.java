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

    @Test
    void shouldNotConsumeCapacityWhilePending() {
        Event event = createValidEvent();

        Reservation reservation = new Reservation(event, 2);

        assertEquals(0, event.getOccupiedCapacity());
        assertEquals(100, event.getAvailableCapacity());
    }

    @Test
    void shouldConsumeCapacityWhenConfirmed() {
        Event event = createValidEvent();
        int initialCapacity = event.getCapacity();

        Reservation reservation = new Reservation(event, 2);
        reservation.confirm();

        assertEquals(initialCapacity - 2, event.getAvailableCapacity());
    }

    @Test
    void shouldReleaseCapacityWhenConfirmedReservationIsCancelled() {
        Event event = createValidEvent();

        Reservation reservation = new Reservation(event, 2);
        reservation.confirm();

        assertEquals(2, event.getOccupiedCapacity());
        assertEquals(98, event.getAvailableCapacity());

        reservation.cancel();

        assertEquals(0, event.getOccupiedCapacity());
        assertEquals(100, event.getAvailableCapacity());
    }

    @Test
    void shouldNotReleaseCapacityWhenPendingReservationIsCancelled() {
        Event event = createValidEvent();

        Reservation reservation = new Reservation(event, 2);
        reservation.cancel();

        assertEquals(0, event.getOccupiedCapacity());
        assertEquals(100, event.getAvailableCapacity());
    }

    @Test
    void shouldRejectConfirmationWhenEventHasInsufficientCapacity() {
        Event event = createValidEvent();
        event.reserveCapacity(99); // Reserve almost all capacity

        Reservation reservation = new Reservation(event, 2);

        assertThrows(
                IllegalStateException.class,
                () -> reservation.confirm());
    }

    @Test
    void shouldRemainPendingWhenConfirmationFails() {
        Event event = createValidEvent();
        event.reserveCapacity(99); // Reserve almost all capacity

        Reservation reservation = new Reservation(event, 2);

        assertThrows(
                IllegalStateException.class,
                () -> reservation.confirm());

        assertEquals(
                ReservationStatus.PENDING,
                reservation.getStatus());

    }

    @Test
    void shouldPreventMultipleReservationsFromExceedingEventCapacity() {
        Event event = createValidEvent();

        Reservation reservation1 = new Reservation(event, 60);
        reservation1.confirm();

        Reservation reservation2 = new Reservation(event, 50);

        assertThrows(
                IllegalStateException.class,
                () -> reservation2.confirm());

        assertEquals(
                ReservationStatus.CONFIRMED,
                reservation1.getStatus());

        assertEquals(
                ReservationStatus.PENDING,
                reservation2.getStatus());

        assertEquals(60, event.getOccupiedCapacity());
        assertEquals(40, event.getAvailableCapacity());
    }

}
