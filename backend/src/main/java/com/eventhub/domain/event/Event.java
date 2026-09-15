package com.eventhub.domain.event;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Event {
    private Long id;
    private String name;
    private String description;
    private String location;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private int capacity;
    private BigDecimal price;
    private EventStatus status;

    public Event(String name, String description, String location, LocalDateTime startDateTime,
            LocalDateTime endDateTime, int capacity, BigDecimal price) {

        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than zero");
        }

        if (price.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Price cannot be negative.");
        }

        if (!endDateTime.isAfter(startDateTime)) {
            throw new IllegalArgumentException("Start date and time must be before end date and time.");
        }

        this.name = name;
        this.description = description;
        this.location = location;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.capacity = capacity;
        this.price = price;
        this.status = EventStatus.DRAFT;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    public int getCapacity() {
        return capacity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public EventStatus getStatus() {
        return status;
    }

}
