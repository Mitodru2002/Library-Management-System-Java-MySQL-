# Library-Management-System-Java-MySQL-
This is a simple Library Management System built using Java (JDBC) and MySQL. It allows users to manage library books and members through a menu-driven console interface.



---

````markdown
# 📚 Library Management System (Java + MySQL)

This is a simple **Library Management System** developed using **Java (JDBC)** and **MySQL**. It allows users to perform all core operations such as adding, viewing, updating, and deleting books and members. It also tracks which book is borrowed by which member using a foreign key relationship.

---

## 🔧 Features

- ✅ Add new books and members  
- ✅ View all books and members  
- ✅ Update any field of books or members  
- ✅ Delete books and members  
- ✅ Track borrowed books (foreign key reference)
- ✅ Menu-driven interface for easy navigation

---

## 🗃️ Database Structure

### 📘 `books` Table:
| Column   | Type     | Description   |
|----------|----------|---------------|
| book_id  | INT      | Primary Key   |
| title    | VARCHAR  | Book title    |
| author   | VARCHAR  | Book author   |
| price    | DOUBLE   | Book price    |

### 👤 `members` Table:
| Column          | Type     | Description                       |
|-----------------|----------|-----------------------------------|
| member_id       | INT      | Primary Key                       |
| name            | VARCHAR  | Member's name                     |
| email           | VARCHAR  | Member's email address            |
| books_borrowed  | INT      | Foreign key referencing `book_id` |

---

## 💻 Technologies Used

- Java (JDK 8+)
- JDBC (Java Database Connectivity)
- MySQL 8.0+
- MySQL Workbench or phpMyAdmin (for DB setup)

---

## 🚀 Getting Started

### 1. Clone this repository

```bash
git clone https://github.com/your-username/library-management-system.git
cd library-management-system
````

### 2. Set up the MySQL Database

Create a database and run the following SQL:

```sql
CREATE DATABASE librarymanagement_db;

USE librarymanagement_db;

CREATE TABLE books (
    book_id INT PRIMARY KEY,
    title VARCHAR(100),
    author VARCHAR(100),
    price DOUBLE
);

CREATE TABLE members (
    member_id INT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100),
    books_borrowed INT,
    FOREIGN KEY (books_borrowed) REFERENCES books(book_id)
);
```

Optionally, insert sample data from `data.sql` (if provided).

### 3. Update DB Credentials in Code

In `Main.java`:

```java
Connection con = DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/librarymanagement_db", "root", "your-password");
```

### 4. Compile & Run the Program

```bash
javac -d . *.java
java mypack.Main
```

---



## 🤝 Contributing

Pull requests are welcome. For major changes, please open an issue first to discuss what you'd like to change.

---



---

Let me know if you’d like a downloadable version or if you want to include data insert SQL too.
```

