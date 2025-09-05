#Student Database Application 
A console based Java application for managing student information using JDBC and MySQL.

##Prerequisites
-Java 8 or later '
-MySQL server 
-MySQL connector/J

##Setup instructions 

###1.Database setup
-Start MySQL server
-Run the following SQL commands to create the database and table:
```sql
CREATE DATABASE student_db;
USE student_db;
CREATE TABLE students (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    age INT,
    subject VARCHAR(100),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    );
    ```
    
###2.Configuration
-Update the database connection details in 'DatabaseConnection.java':

-URL:'jdbc:mysql://localhost:3306/student_db'

-USER: root

-Password:IT3003@java

###3.Running the application
 -Compile and run the java application using your preffered method:
 -Command line: Use the provided compilation and execution commands 
 - IDE: Import the project, add the MySQL connector to classpath, and run Main.java
 
##Usage 
The application provides a menu driven interface with the following options:
1.Add students
2.View all students 
3.Update students
4.Delete students 
5.View student by ID
6.Exit 

##Assumptions

  -MySQL server is running on localhost with default port 3306
  -Database name is 'student_db' with table 'students'
  -User has appropriate privileges to perform CRUD operations 
  
##Notes 
  -Email address must be unique in the databse
  -Age validity is basic(only checks for integer inputs)
  -The application doesn't handle all possible edge cases for production use
 
  

 
 

