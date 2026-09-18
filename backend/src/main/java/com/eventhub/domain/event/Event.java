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
    private int occupiedCapacity;
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
        this.occupiedCapacity = 0;
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

    public int getOccupiedCapacity() {
        return occupiedCapacity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public EventStatus getStatus() {
        return status;
    }

    public int getAvailableCapacity() {
        return capacity - occupiedCapacity;
    }

    public void reserveCapacity(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }

        if (quantity > getAvailableCapacity()) {
            throw new IllegalStateException("Not enough available capacity for the requested quantity");
        }

        this.occupiedCapacity += quantity;
    }

    public void releaseCapacity(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }

        if (quantity > occupiedCapacity) {
            throw new IllegalStateException("Cannot release more capacity than is currently occupied");
        }

        this.occupiedCapacity -= quantity;
    }

}
