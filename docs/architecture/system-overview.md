# System Overview

## Purpose

## Architectural Style

EventHub will start out as a modular monolith with a layered architecture. It won’t jump straight into Hexagonal or full Clean Architecture, instend, it will start with a focus in:
    * responsibilities;
    * dependencies;
    * domain;
    * services;
    * persistence;
    * REST API.
Later on, it’ll be refactored  toward Clean Architecture and Hexagonal.

## Main Components

## Request Flow

Client
    → REST Controller
        → Service
            → Repository
                → PostgreSQL

## Persistence

## Security

## Future Evolution
