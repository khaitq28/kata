# Kata Practice — Clean Code & Design Patterns in Java

> Kata is the best way to sharpen your coding, refactoring, and design skills through deliberate practice.

A curated collection of kata solutions demonstrating **clean code**, **OOP principles**, and **design patterns** in Java 17.
Solutions come from [codingdojo.org](https://codingdojo.org), [kata-log.rocks](https://kata-log.rocks/), and custom exercises.

---

## Table of Contents

- [Project Structure](#project-structure)
- [Tech Stack](#tech-stack)
- [How to Build & Run](#how-to-build--run)
- [Kata Exercises](#kata-exercises)
  - [Refactoring Katas](#refactoring-katas)
  - [OOP / Design Katas](#oop--design-katas)
  - [Algorithm Katas](#algorithm-katas)
- [Design Patterns Index](#design-patterns-index)
- [Testing Approaches](#testing-approaches)

---

## Project Structure

```
kata/
├── src/
│   ├── main/java/
│   │   ├── movierental/           # Movie Rental refactoring kata
│   │   ├── employee/              # Employee Report kata
│   │   ├── tennis/                # Tennis Game kata (6 implementations)
│   │   ├── social_network/        # Social Network kata
│   │   ├── tasklist/              # Task List kata
│   │   ├── leapyear/              # Leap Year kata
│   │   ├── manhattanDistance/     # Manhattan Distance kata
│   │   ├── tripservicekata/       # Trip Service kata
│   │   ├── ScoreKeeper/           # Score Keeper kata
│   │   ├── telldontaskkata/       # Tell Don't Ask kata
│   │   ├── gildedrose/            # Gilded Rose refactoring kata
│   │   ├── packing_lot/           # Parking Lot kata
│   │   ├── PrimeFactors/          # Prime Factors kata
│   │   ├── refactoring_a/         # Shopping Cart refactoring kata
│   │   ├── product_export_refactoring/ # Product Export refactoring kata
│   │   ├── Store/                 # Store kata
│   │   ├── oop/                   # OOP exercises (Unix file search, rm -rf)
│   │   └── org/codingdojo/        # Yatzy kata (3 implementations)
│   └── test/java/                 # Mirror of main, one test class per kata
└── pom.xml
```

---

## Tech Stack

| Tool | Purpose |
|------|---------|
| Java 17 | Language (sealed classes, switch expressions, records) |
| Maven | Build & dependency management |
| JUnit 5 | Unit testing |
| JQwik | Property-based testing |
| ApprovalTests | Approval / snapshot testing |
| Lombok | Boilerplate reduction |
| Apache Commons | Lang & Collections utilities |
| Easy Random | Random test data generation |

---

## How to Build & Run

```bash
# Compile
mvn compile

# Run all tests
mvn test

# Run tests for a specific kata
mvn test -Dtest="TennisGame1Test"
```

---

## Kata Exercises

### Refactoring Katas

These start from unclean/legacy code and the goal is to refactor toward clean, readable, well-structured code.

---

#### 1. Movie Rental
**Source:** https://codingdojo.org/kata/movie-rental/
**Package:** `movierental/`

Classic Martin Fowler refactoring example. Starts with a `Customer.statement()` god-method and refactors it into a clean, extensible design.

**Key concepts:** Extract Method, Move Method, Replace Conditional with Polymorphism
**Patterns:** Strategy (pricing), Enum (`PriceCode`)

```
movierental/
├── Customer.java         # Customer with rental list
├── Rental.java           # Rental record
├── Movie.java            # Movie with price code
├── PriceCode.java        # Enum: REGULAR, NEW_RELEASE, CHILDREN
└── price/
    ├── Price.java        # Abstract pricing strategy
    ├── RegularPrice.java
    ├── NewReleasePrice.java
    └── ChildrenPrice.java
```

---

#### 2. Employee Report
**Source:** https://codingdojo.org/kata/Employee-Report/
**Package:** `employee/`

Filter and report on a list of employees. Practice applying the Filter/Predicate pattern with sorting.

**Key concepts:** Filtering, Sorting, Separation of concerns
**Patterns:** Strategy (`EmployeeFilter`), Predicate, Template Method

```
employee/
├── Employee.java
├── Shop.java              # Employee container with filter/sort logic
├── EmployeeFilter.java    # Filter interface
├── AdultFilter.java
├── SeniorFilter.java
├── Reporter.java          # Report interface
└── EmployeeReporter.java
```

---

#### 3. Gilded Rose
**Source:** https://kata-log.rocks/gilded-rose-kata
**Package:** `gildedrose/`

Famous refactoring kata. The goal: refactor a god-object `Item` that mixes data and update logic for all item types into a clean, extensible design where adding a new item type requires zero changes to existing classes.

**Key concepts:** Replace Conditional with Polymorphism, Open/Closed Principle, Single Responsibility
**Patterns:** Strategy (`ItemUpdater`), Factory (`ItemUpdaterFactory`)

```
gildedrose/
├── Item.java                 # Pure data class with package-private mutation helpers
├── ItemUpdater.java          # Strategy interface
├── NormalItemUpdater.java
├── AgedBrieUpdater.java
├── BackstagePassUpdater.java
├── SulfurasUpdater.java      # No-op: legendary item never changes
├── ConjuredItemUpdater.java  # Degrades 2x as fast as normal
├── ItemUpdaterFactory.java   # Picks the right strategy by item name
└── GildedRose.java           # Iterates items, delegates to factory
```

**Item types handled:** Normal, Aged Brie, Backstage Passes, Sulfuras, Conjured Mana Cake

**Before → After:**
- Before: `Item` contained nested conditionals for every item type — adding "Conjured" meant modifying `Item`
- After: each item type is an isolated class; adding a new type = one new class + one line in the factory

---

#### 4. Tell Don't Ask
**Source:** https://kata-log.rocks/tell-dont-ask-kata
**Package:** `telldontaskkata/`

Full order management system. Demonstrates the "Tell Don't Ask" principle — objects should tell other objects what to do rather than ask for data and decide externally.

**Key concepts:** Tell Don't Ask, Domain-Driven Design, Use Case pattern, rich domain models
**Patterns:** Repository, Use Case, State (order lifecycle), custom exceptions

```
telldontaskkata/
├── domain/
│   ├── Order.java            # Rich domain object with state validation
│   ├── OrderItem.java
│   ├── Product.java
│   ├── Category.java
│   └── OrderStatus.java      # Enum: CREATED, APPROVED, REJECTED, SHIPPED
├── repository/
│   ├── OrderRepository.java  # Interface
│   └── ProductCatalog.java   # Interface
├── service/
│   └── ShipmentService.java
└── useCase/
    ├── OrderCreationUseCase.java
    ├── OrderApprovalUseCase.java
    ├── OrderRejectionUseCase.java
    └── OrderShipmentUseCase.java
```

**Order state machine:**
```
CREATED → APPROVED → SHIPPED
        ↘ REJECTED
```

---

#### 5. Trip Service
**Source:** https://kata-log.rocks/trip-service-kata
**Package:** `tripservicekata/`

Refactoring kata focused on breaking dependencies on singletons and static calls to make code testable.

**Key concepts:** Dependency breaking, Seam pattern, protected method override for testing
**Patterns:** Builder (`UserBuilder`), DAO, custom exceptions

---

#### 6. Refactoring A — Shopping Cart
**Package:** `refactoring_a/`

Refactor a monolithic discount/tax calculation into a clean, extensible design.

**Key concepts:** Extract strategy, Separate policy from context
**Patterns:** Strategy (discount policies, tax policies), Context, Enum (`Category`, `CustomerType`)

```
refactoring_a/
├── Product.java
├── ShoppingCart.java
├── DiscountPolicy.java        # Interface
├── TaxPolicy.java             # Interface
├── DiscountContext.java
├── BulkDiscountPolicy.java
├── LoyaltyDiscountPolicy.java
├── ClothingDiscountPolicy.java
└── FoodDiscountPolicy.java
```

---

#### 7. Product Export Refactoring
**Package:** `product_export_refactoring/`

Refactor static utility-heavy export logic into clean, testable domain objects.

**Key concepts:** Remove static dependencies, encapsulate export logic
**Patterns:** Rich domain objects, Exporter pattern

---

### OOP / Design Katas

These start from scratch, focusing on clean design and applying patterns correctly.

---

#### 8. Tennis Game
**Source:** https://codingdojo.org/kata/Tennis/
**Package:** `tennis/`

Six different implementations of the same Tennis scoring problem, each demonstrating a different design approach. Great for comparing tradeoffs.

| Implementation | Approach |
|---|---|
| `game1/` | State Pattern with polymorphic score types |
| `game2/` | Statement Pattern |
| `game3/` | Functional / lambda approach |
| `game4/` | Minimal procedural |
| `game5/` | Data-driven |
| `game6/` | Table-based scoring |

**Patterns (game1):** State, Template Method, Predicate
```
tennis/game1/
├── TennisGame1.java       # Orchestrator
├── Player.java
├── Score.java             # Abstract base
├── NormalScore.java
├── DeuceScore.java
├── AdvantageScore.java
└── WinScore.java
```

---

#### 9. Social Network
**Package:** `social_network/`

Full layered architecture for a simplified Twitter-like social network.

**Key concepts:** Layered architecture, Dependency Inversion, Repository pattern
**Patterns:** Repository, Service Layer, DTO, Dependency Injection

```
social_network/
├── domain/          # User, Post, Follow, TimeUtils
├── repository/      # Interfaces: UserRepository, PostRepository, FollowRepository
├── service/         # Interfaces + Impls: UserService, PostService, WallService
├── controller/      # UserController, PostController, WallController
├── dto/             # PostRequestDto, WallResponseDto, ...
└── infra/database/  # In-memory repository implementations
```

**Features:** Post to timeline, follow users, view wall (aggregated feed from followed users)

---

#### 10. Task List
**Source:** https://codingdojo.org/kata/task-list/
**Package:** `tasklist/refact/`

CLI task manager. Refactored from a monolithic switch statement to the Command pattern.

**Key concepts:** Command pattern, Factory with switch expressions, Clean CLI parsing
**Patterns:** Command, Factory, Enum (`CommandType`)

**Supported commands:** `show`, `add project`, `add task`, `check`, `uncheck`, `help`, `quit`

```
tasklist/refact/
├── Command.java          # Interface
├── CommandFactory.java   # Factory with switch expression
├── CommandType.java      # Enum
├── AddProjectCommand.java
├── AddTaskCommand.java
├── CheckCommand.java
├── ShowCommand.java
└── ...
```

---

#### 11. Parking Lot
**Package:** `packing_lot/`

Design a parking lot system from scratch supporting multiple vehicle types with dynamic slot allocation and pricing.

**Key concepts:** Sealed classes (Java 17), Enum with data, rich domain model
**Patterns:** Sealed hierarchy, Enum (`VehicleType` with slot count and price per hour)

```
packing_lot/
├── Vehicle.java       # Sealed abstract class
├── Car.java           # permits Vehicle
├── Truck.java
├── Bike.java
├── VehicleType.java   # Enum: CAR, TRUCK, BIKE
├── ParkingLot.java    # Lot management + slot allocation
└── Ticket.java        # Issued on entry, used for checkout
```

---

#### 12. Yatzy
**Source:** https://kata-log.rocks/yatzy-refactoring-kata
**Package:** `org/codingdojo/`

Three progressively refined implementations of the Yatzy dice game scorer.

| Version | Approach |
|---|---|
| `yatzy1/` | Procedural baseline |
| `yatzy2/` | Intermediate, some extraction |
| `yatzy3/` | Full Strategy + Factory pattern |

**Yatzy3 patterns:** Strategy (`YatzyPointsScorer`), Factory (`CategoryScorer`), Enum (`YatzyCategory`)

```
yatzy3/
├── YatzyPointsScorer.java      # Scorer interface
├── CategoryScorer.java         # Factory
├── NumberScorer.java
├── RepeatedCountScorer.java
├── FullHouseScorer.java
├── StraightScorer.java
├── TwoPairsScorer.java
└── ChanceScorer.java
```

---

#### 13. Unix File Search (OOP)
**Package:** `oop/unixFileSearch/`

OOP design for a `find`-like file search API supporting composable filters.

**Key concepts:** Composite pattern, recursive tree traversal, filter composition
**Patterns:** Template Method (`AbstractFile`), Composite (`GroupFilter`), Strategy (individual filters)

```
oop/unixFileSearch/
├── AbstractFile.java        # Template method base
├── File.java
├── Directory.java           # Recursive search
├── SearchFileApi.java
└── filter/
    ├── FileFilter.java      # Interface
    ├── GroupFilter.java     # Composite: AND / OR grouping
    ├── ExtensionFilter.java
    ├── FileNameFilter.java
    ├── FileSizeFilter.java
    └── FilterOperator.java  # Enum: EQUAL, GREATER_THAN, LESS_THAN, ...
```

---

#### 14. Store
**Package:** `Store/`

Inventory management kata with shelf categorization and a fluent builder.

**Key concepts:** Builder pattern, Template Method, Enum-based categorization
**Patterns:** Builder, Template Method, Enum (`ShelveType`)

---

### Algorithm Katas

Simple, focused algorithmic exercises — great warm-ups.

| Kata | Package | Description |
|------|---------|-------------|
| Leap Year | `leapyear/` | Determine if a year is a leap year using divisibility rules |
| Prime Factors | `PrimeFactors/` | Return the prime factorization of an integer |
| Manhattan Distance | `manhattanDistance/` | Calculate Manhattan distance between two points |
| Score Keeper | `ScoreKeeper/` | Track and query scores |
| Sum of Squares | `algo/` | Sum of squares calculation |

---

## Design Patterns Index

| Pattern | Where Used |
|---------|-----------|
| **Strategy** | Movie Rental (pricing), Gilded Rose (`ItemUpdater` per item type), Refactoring A (discounts/tax), Yatzy3 (scorers), Employee (filters) |
| **State** | Tennis game1 (score states), Tell Don't Ask (order lifecycle) |
| **Command** | Task List |
| **Factory** | Task List (`CommandFactory`), Yatzy3 (`CategoryScorer`) |
| **Template Method** | Tennis (score base), Unix File Search (`AbstractFile`), Store (`Food`) |
| **Composite** | Unix File Search (`GroupFilter`) |
| **Builder** | Trip Service (`UserBuilder`), Store (`Builder`) |
| **Repository** | Tell Don't Ask, Social Network |
| **Service Layer** | Social Network |
| **DAO** | Trip Service |
| **Use Case** | Tell Don't Ask |
| **DTO** | Social Network |
| **Sealed Classes** | Parking Lot (`Vehicle` hierarchy) — Java 17 |
| **Enum with behavior** | Movie Rental (`PriceCode`), Parking Lot (`VehicleType`), Task List (`CommandType`) |
| **Predicate** | Employee Report |

---

## Testing Approaches

| Approach | Library | Used In |
|----------|---------|---------|
| Unit tests | JUnit 5 | All katas |
| Property-based tests | JQwik | Yatzy, Tennis |
| Approval tests | ApprovalTests | Gilded Rose |
| Test doubles (manual mocks/stubs) | Plain Java | Tell Don't Ask (`doubles/`) |
| Random test data | Easy Random | Various |

---

## Two Kinds of Exercises

| Type | Goal |
|------|------|
| **OOP / Kata from scratch** | Design clean solutions applying patterns and principles from the start |
| **Refactoring from unclean code** | Start with working but messy code and iteratively improve structure, readability, and testability |

---

## Resources

- [codingdojo.org](https://codingdojo.org) — Kata descriptions and community solutions
- [kata-log.rocks](https://kata-log.rocks/) — Curated kata catalog with difficulty ratings
- *Refactoring* — Martin Fowler
- *Clean Code* — Robert C. Martin
- *Head First Design Patterns* — Freeman & Freeman
