Student Registration System (GUI + MySQL)

📌 Overview

This project is developed as part of my Syntecxhub Java Internship (Week 4 Task).

It is a GUI-based Student Registration System built using Java Swing with MySQL database connectivity.
The system allows users to register students and save their information permanently into a database.
A simple, clean, and user-friendly registration form is provided for data entry.

This project is designed for new student registrations only — not for full CRUD operations.

✨ Features

✔ GUI-based Student Registration Form
✔ Student data stored in MySQL database
✔ Field validation (empty fields, age number check, gender selection, dropdown validation)
✔ Button operations: Submit, Clear Form, Exit
✔ Secure database insertion using PreparedStatement
✔ Ability to manually check saved data in database (View option is not built into GUI)
✔ Simple and professional interface

🛠 Technologies Used

Java (Swing GUI + AWT)
MySQL Database
JDBC (Java Database Connectivity)
Driver: com.mysql.cj.jdbc.Driver
IDE: VS Code / IntelliJ / Eclipse

Project Structure
src/
   ├── Student_Login_Form.java   // Main GUI Registration Form
   └── DBConnect.java            // Handles database insertion
   
▶ How the Application Works

User opens the GUI student registration form.
Fills in student information (Name, Father Name, Roll No, Age, etc.).
Selects Gender, Department, Course.
Clicks Submit → Data is saved in MySQL.
Clear button resets the form.
Exit button closes the system.
Admin can view saved data directly from phpMyAdmin / MySQL Workbench / MySQL CLI.
   
👨‍💻 Author
Pirbhu Ji
Java Intern @Syntecxhub   
GitHub: https://github.com/Pirbhu-Ji
 
📌 Project Status

This project has been successfully completed as part of
Syntecxhub Internship – Week 4 Task.
It includes basic student registration functionality with database storage, built using Java Swing and MySQL. 
 