# System Overview

## Purpose

EventHub is a backend platform designed to manage companies, contacts, events, reservations, payments, and audit records through a REST API.

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

User Management
Company and Contact Management
Event Management
Reservation Management
Payment Management
Audit
Dashboard

## Request Flow

Client
    → REST Controller
        → Service
            → Repository
                → PostgreSQL

## Persistence

Because PostgreSQL offers extensive data management capabilities, it will be the primary source of structured and transactional data

## Security

Initially, EventHub will be secured using JWT authentication and role-based authorization
