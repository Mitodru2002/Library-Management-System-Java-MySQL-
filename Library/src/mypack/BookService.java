package mypack;
import java.sql.*;
import java.util.Scanner;

public class BookService {
    public static void insertBook(Connection con, Scanner sc) throws SQLException {
        System.out.print("Enter Book ID: ");
        int bookId = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Title: ");
        String title = sc.nextLine();
        System.out.print("Enter Author: ");
        String author = sc.nextLine();
        System.out.print("Enter Price: ");
        double price = sc.nextDouble();

        PreparedStatement pstBook = con.prepareStatement("INSERT INTO books VALUES (?, ?, ?, ?)");
        pstBook.setInt(1, bookId);
        pstBook.setString(2, title);
        pstBook.setString(3, author);
        pstBook.setDouble(4, price);
        pstBook.executeUpdate();
        System.out.println("Book inserted successfully!");
    }

    public static void viewBooks(Connection con) throws SQLException {
        Statement stBooks = con.createStatement();
        ResultSet rsBooks = stBooks.executeQuery("SELECT * FROM books");
        System.out.println("\n--- Books ---");
        while (rsBooks.next()) {
            System.out.println(rsBooks.getInt("book_id") + " | " +
                               rsBooks.getString("title") + " | " +
                               rsBooks.getString("author") + " | ₹" +
                               rsBooks.getDouble("price"));
        }
    }

    public static void updateBook(Connection con, Scanner sc) throws SQLException {
        System.out.print("Enter Book ID to update: ");
        int updateBookId = sc.nextInt();
        sc.nextLine();
        System.out.print("Which field do you want to update? (title/author/price): ");
        String bookField = sc.nextLine().toLowerCase();

        String bookSql = "UPDATE books SET " + bookField + " = ? WHERE book_id = ?";
        PreparedStatement updateBook = con.prepareStatement(bookSql);

        if (bookField.equals("price")) {
            System.out.print("Enter new price: ");
            double newPrice = sc.nextDouble();
            updateBook.setDouble(1, newPrice);
        } else {
            System.out.print("Enter new " + bookField + ": ");
            String newValue = sc.nextLine();
            updateBook.setString(1, newValue);
        }
        updateBook.setInt(2, updateBookId);
        int bookUpdated = updateBook.executeUpdate();
        System.out.println(bookUpdated > 0 ? "Book updated." : "Book not found.");
    }

    public static void deleteBook(Connection con, Scanner sc) throws SQLException {
        System.out.print("Enter Book ID to delete: ");
        int deleteBookId = sc.nextInt();

        PreparedStatement deleteBook = con.prepareStatement("DELETE FROM books WHERE book_id = ?");
        deleteBook.setInt(1, deleteBookId);
        int bookDeleted = deleteBook.executeUpdate();
        System.out.println(bookDeleted > 0 ? "Book deleted." : "Book not found.");
    }
}