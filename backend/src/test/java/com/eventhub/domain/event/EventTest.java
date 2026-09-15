package com.eventhub.domain.event;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class EventTest {

    @Test
    void shouldCreateEventAsDraft() {
        Event event = new Event(
                "Java Conference",
                "Java event",
                "Medellin",
                LocalDateTime.of(2026, 10, 10, 9, 0),
                LocalDateTime.of(2026, 10, 10, 17, 0),
                100,
                new BigDecimal("50.00"));

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

}
