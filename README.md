# Hostel Management System

A basic **Java-based Hostel Management System** designed to simplify and manage common hostel activities through a console-based application.

## 📌 Project Description

Hostel Management System is a Java-based console application that manages student records, rooms, room allotment and vacation, complaints, and payments. It also generates hostel reports and saves data using file handling. The project demonstrates OOP, collections, exception handling, streams, and file I/O.

## ✨ Features

* Add and manage student records
* Add hostel rooms with capacity
* Allot rooms to students
* Vacate rooms
* Display student records
* Display room details
* Register student complaints
* Resolve complaints
* Record student payments
* Generate hostel summary reports
* Save and load data using file handling
* Basic exception handling for invalid operations

## 🛠️ Technologies Used

* **Language:** Java
* **Interface:** Console / Command Line
* **Concepts:** OOP, Collections, Exception Handling, Streams
* **Data Storage:** Java File I/O / Serialization

## 📂 Main Modules

### 1. Student Management

Stores student information such as:

* Student ID
* Name
* Phone number
* Course
* Year

### 2. Room Management

Manages:

* Room number
* Room capacity
* Room occupancy
* Room allotment
* Room vacation

### 3. Complaint Management

Students can register complaints, and administrators can resolve them using the complaint ID.

### 4. Payment Management

Records payments made by students and maintains the total payment information.

### 5. Report Generation

The system generates a basic report containing:

* Total students
* Total rooms
* Occupied beds
* Total complaints
* Total payments

## 📋 Application Menu

```text
===== HOSTEL MANAGEMENT SYSTEM =====
1. Add student
2. Add room
3. Allot room
4. Vacate room
5. List students
6. List rooms
7. Add complaint
8. Resolve complaint
9. Record payment
10. Generate report
0. Save & exit
```

## 🚀 How to Run

### Prerequisites

Make sure **Java JDK** is installed on your system.

Check the installation using:

```bash
java -version
javac -version
```

### Running the Project

1. Clone or download the project.
2. Open the project in an IDE such as IntelliJ IDEA, Eclipse, or VS Code.
3. Make sure the package structure is preserved.
4. Run the `Main.java` file.
5. Select options from the console menu.

## 💾 Data Storage

The application stores hostel data in:

```text
data/hostel.dat
```

Data is loaded when the application starts and saved when the user selects **Save & Exit**.

## 📚 Java Concepts Demonstrated

* Classes and Objects
* Encapsulation
* Collections
* Exception Handling
* Java Streams
* File Handling
* Serialization
* Methods and Constructors
* Loops and Conditional Statements
* Console Input/Output

## 🔮 Future Improvements

The project can be extended with:

* Graphical User Interface (GUI)
* MySQL database integration
* Login and authentication
* Student search and filtering
* Admin dashboard
* Fee due tracking
* Attendance management
* Hostel visitor management
* Online payment support

## 🎯 Purpose

This project is intended as a **basic academic Java project** for understanding object-oriented programming, collections, file handling, and real-world management-system design.

## 👨‍💻 Author

**Mehul Vashisth**

---

⭐ If you find this project useful, consider giving it a star!
