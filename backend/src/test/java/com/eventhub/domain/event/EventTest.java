package com.eventhub.domain.event;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class EventTest {

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
        void shouldCreateEventAsDraft() {
                Event event = createValidEvent();

                assertEquals(EventStatus.DRAFT, event.getStatus());
        }

        @Test
        void shouldRejectZeroCapacity() {

                assertThrows(
                                IllegalArgumentException.class,
                                () -> new Event(
                                                "Event Test 2",
                                                "This is a test event",
                                                "Test Location",
                                                LocalDateTime.of(2024, 6, 1, 10, 0),
                                                LocalDateTime.of(2024, 6, 1, 12, 0),
                                                0,
                                                new BigDecimal("10.00")));
        }

        @Test
        void shouldRejectNegativePrice() {

                assertThrows(
                                IllegalArgumentException.class,
                                () -> new Event(
                                                "Event Test 3",
                                                "This is a test event",
                                                "Test Location",
                                                LocalDateTime.of(2024, 6, 1, 10, 0),
                                                LocalDateTime.of(2024, 6, 1, 12, 0),
                                                100,
                                                new BigDecimal("-10.00")));

        }

        @Test
        void shouldRejectEndDateBeforeStartDate() {

                assertThrows(
                                IllegalArgumentException.class,
                                () -> new Event(
                                                "Event Test 4",
                                                "This is a test event",
                                                "Test Location",
                                                LocalDateTime.of(2024, 6, 1, 10, 0),
                                                LocalDateTime.of(2024, 6, 1, 8, 0),
                                                100,
                                                new BigDecimal("10.00")));
        }

        @Test
        void shouldRejectEqualStartAndEndDate() {
                LocalDateTime dateTime = LocalDateTime.of(2026, 10, 10, 9, 0);

                assertThrows(
                                IllegalArgumentException.class,
                                () -> new Event(
                                                "Java Conference",
                                                "Java event",
                                                "Medellin",
                                                dateTime,
                                                dateTime,
                                                100,
                                                new BigDecimal("50.00")));
        }

        @Test
        void shouldStartWithFullAvailableCapacity() {
                Event event = createValidEvent();

                assertEquals(100, event.getCapacity());
                assertEquals(0, event.getOccupiedCapacity());
                assertEquals(100, event.getAvailableCapacity());
        }

        @Test
        void shouldReserveCapacity() {
                Event event = createValidEvent();

                event.reserveCapacity(30);

                assertEquals(30, event.getOccupiedCapacity());
                assertEquals(70, event.getAvailableCapacity());
        }

        @Test
        void shouldRejectReservationExceedingAvailableCapacity() {
                Event event = createValidEvent();

                assertThrows(
                                IllegalStateException.class,
                                () -> event.reserveCapacity(150));
        }

        @Test
        void shouldReleaseCapacity() {
                Event event = createValidEvent();

                event.reserveCapacity(30);
                event.releaseCapacity(20);

                assertEquals(10, event.getOccupiedCapacity());
                assertEquals(90, event.getAvailableCapacity());
        }

        @Test
        void shouldRejectReleasingMoreThanOccupiedCapacity() {
                Event event = createValidEvent();

                event.reserveCapacity(30);

                assertThrows(
                                IllegalStateException.class,
                                () -> event.releaseCapacity(40));
        }

        @Test
        void shouldRejectZeroReserveQuantity() {
                Event event = createValidEvent();

                assertThrows(
                                IllegalArgumentException.class,
                                () -> event.reserveCapacity(0));
        }

        @Test
        void shouldRejectNegativeReserveQuantity() {
                Event event = createValidEvent();

                assertThrows(
                                IllegalArgumentException.class,
                                () -> event.reserveCapacity(-5));
        }

        @Test
        void shouldRejectZeroReleaseQuantity() {
                Event event = createValidEvent();

                assertThrows(
                                IllegalArgumentException.class,
                                () -> event.releaseCapacity(0));
        }

        @Test
        void shouldRejectNegativeReleaseQuantity() {
                Event event = createValidEvent();

                assertThrows(
                                IllegalArgumentException.class,
                                () -> event.releaseCapacity(-5));
        }
}
