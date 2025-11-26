📘 Student Registration System (Java Swing + MySQL) — FULL CRUD VERSION
📌 Overview

This project is developed as part of my Syntecxhub Java Internship (Week 4 Task).

The Student Registration System is a desktop application built using Java Swing for the GUI and MySQL for database storage.
Originally, the system supported only Create (Submit) operations, but it has now been fully upgraded to support:

✅ Create
✅ Read
✅ Update
✅ Delete

This makes it a complete CRUD-based management application.

The system allows easy registration, viewing, editing, and deletion of student records through a clean and user-friendly interface.

✨ Features (Updated – Full CRUD)
✔ Create Student

GUI form to register a new student

Validations (empty fields, age numeric check, gender selection)

✔ Read Students

Button to display all saved students

Data shown in a scrollable text area

Future support for JTable (optional)

✔ Update Student

Update any student’s record using Roll No

All fields can be edited and resaved

✔ Delete Student

Remove student using Roll No

Delete confirmation dialog

✔ Other Features

Clear form button

Exit application button

Secure prepared statements (SQL injection safe)

MySQL integration (JDBC)

🛠 Technologies Used

Java (Swing + AWT)

MySQL Database

JDBC Driver: com.mysql.cj.jdbc.Driver

IDE: VS Code / IntelliJ IDEA / Eclipse

OOP + Database + GUI Programming

📂 Project Structure
src/
│
├── Student_Login_Form.java   // Main GUI window (Create, Read, Update, Delete)
└── DBConnect.java            // All database operations (CRUD using MySQL)

▶ How the Application Works
1️⃣ User opens the Student Registration System window
2️⃣ They can perform any of the following actions:
Create (Submit Form)

Enter student details

Click Create

Data is inserted into MySQL

Read

Click Read

Shows all student records from database

Update

Enter an existing Roll Number

Modify fields

Click Update

The record is modified in MySQL

Delete

Enter Roll Number

Click Delete

Record is removed after confirmation

Clear

Clears all fields

Exit

Closes the program

📌 Database Table (students)
id (PK)
name
father_name
age
roll_no (Unique)
department
course
gender
address
phone

👨‍💻 Author

Pirbhu Ji
Java Intern @Syntecxhub

GitHub:
🔗 https://github.com/Pirbhu-Ji

📌 Project Status — Completed (Full CRUD)

The project has now been fully upgraded to complete CRUD operations, making it a professional student management desktop application.
