# Rental Management System
# Java-and-JavaFX

This is a comprehensive solution for managing the rental units of a real estate company, addressing various aspects from property types and tenant management to accounting and lease contracts.

This is an overview of the design using appropriate design patterns, inheritance hierarchies, and polymorphism. 

### Design Patterns

#### 1. **Factory Pattern**:
Utilized the Factory Pattern to create instances of different property types (Apartment, Condo, House) based on user input or data.

#### 2. **Observer Pattern**: 
Implemented the Observer Pattern to notify potential tenants when a unit becomes available. Potential tenants can subscribe to updates on specific units, and the system notifies them when a unit matching their criteria becomes available.

#### 3. **Singleton Pattern**:
Implemented a Singleton Pattern for the accounting system to ensure there's a single point of access for recording and tracking rent payments.

### Command Line Output
Implement a command-line interface (CLI) as well as JavaFX interface to interact with the system. Apart from the JavaFX interface, users can input commands to view property details, register interest, view payment statuses, etc. The CLI should provide clear and user-friendly prompts and responses.
