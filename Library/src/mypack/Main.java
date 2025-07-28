package mypack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/librarymanagement_db", "root", "12345");
            System.out.println("Connected to Database");

            int choice;
            do {
                System.out.println("\n===== Library Management Menu =====");
                System.out.println("1. Insert Book");
                System.out.println("2. Insert Member");
                System.out.println("3. View All Books");
                System.out.println("4. View All Members");
                System.out.println("5. Update Book");
                System.out.println("6. Update Member");
                System.out.println("7. Delete Member");
                System.out.println("8. Delete Book");
                System.out.println("9. Exit");
                System.out.print("Enter your choice: ");
                choice = sc.nextInt();

                switch (choice) {
                    case 1: BookService.insertBook(con, sc); break;
                    case 2: MemberService.insertMember(con, sc); break;
                    case 3: BookService.viewBooks(con); break; // ✅ Added this line
                    case 4: MemberService.viewMembers(con); break;
                    case 5: BookService.updateBook(con, sc); break;
                    case 6: MemberService.updateMember(con, sc); break;
                    case 7: MemberService.deleteMember(con, sc); break;
                    case 8: BookService.deleteBook(con, sc); break;
                    case 9: System.out.println("Exiting system..."); break;
                    default: System.out.println("Invalid choice. Please try again."); break;
                }

            } while (choice != 9);

            con.close();
            sc.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
