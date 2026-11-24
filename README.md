# Pixel Palace – Shop Management System

A desktop shop management system for an electronics store that sells laptops and smartphones, built with **Java Swing**. Customers can browse products and buy them. Owners can manage customers, owners and employees.

I built this as my 2nd-semester Object-Oriented Programming (OOP) course project at AIUB.

![Home screen](screenshots/home.png)

## Features

**Customer**
- Sign up, log in and reset a forgotten password with a security question
- Browse laptops (Asus, Apple, MSI, Dell, HP, Acer) and phones (iPhone, Samsung, Asus ROG, Google Pixel)
- Buy a product: the quantity is checked against the stock, and the stock is reduced after payment
- See past orders on the **My Orders** screen
- Delete their own account after confirming the password

**Owner**
- Add, remove, search and update customers, owners and employees
- View the customer list, owner list and product list with stock levels

**Employee**
- Log in and use the shop screens to sell products

## Tech and concepts

- Java, Swing (GUI)
- OOP: classes, inheritance (`User` → `Customer`, `Owner`, `Employer`) and interfaces
- Repository pattern: each entity has an interface (`interfaces/`) and a repository class (`repositories/`) that handles saving and loading
- File storage: data is saved as comma-separated text files in `repositories/data/`

## Screenshots

| Login | Product |
|---|---|
| ![Login](screenshots/login.png) | ![Product](screenshots/product.png) |

| Payment | Order history |
|---|---|
| ![Payment](screenshots/payment.png) | ![Order history](screenshots/history.png) |

| Owner dashboard |
|---|
| ![Owner](screenshots/owner.png) |

## How to run

You need the JDK 8 or newer (`javac` and `java` on your PATH).

**Windows:** double-click `run.bat`, or run it from a terminal in the project folder.

**macOS / Linux:**
```sh
sh run.sh
```

**Manually:**
```sh
javac -d out Start.java Frames/*.java entities/*.java interfaces/*.java repositories/*.java
java -cp out Start
```

Run it from the project folder, because the app loads `images/` and `repositories/data/` from there.

## Demo accounts

| Role | User ID | Password |
|---|---|---|
| Customer | `cust1` | `cust123` |
| Customer | `cust2` | `cust456` |
| Owner | `owner` | `owner123` |
| Employee | `emp1` | `emp123` |

## Project structure

```
Start.java              entry point (opens the login screen)
Frames/                 Swing screens (login, home, product pages, payment, owner dashboard)
entities/               data classes (User, Customer, Owner, Employer, Product, Order, OrderLine, Payment)
interfaces/             repository interfaces
repositories/           file-based repositories and FileIO
repositories/data/      the stored records (.txt)
images/                 product and UI images
```

## Author

**Durjoy Saha** – [GitHub](https://github.com/DURJOYSAHA21) · [Portfolio](https://durjoysaha21.github.io/portfolio/)
