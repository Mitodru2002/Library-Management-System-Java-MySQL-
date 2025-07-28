package mypack;

import java.sql.*;
import java.util.Scanner;

public class MemberService {
    public static void insertMember(Connection con, Scanner sc) throws SQLException {
        System.out.print("Enter Member ID: ");
        int memberId = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Email: ");
        String email = sc.nextLine();
        System.out.print("Enter Book Title Borrowed: ");
        String borrowedTitle = sc.nextLine();

        PreparedStatement pstMember = con.prepareStatement("INSERT INTO members VALUES (?, ?, ?, ?)");
        pstMember.setInt(1, memberId);
        pstMember.setString(2, name);
        pstMember.setString(3, email);
        pstMember.setString(4, borrowedTitle);
        pstMember.executeUpdate();
        System.out.println("Member inserted successfully!");
    }

    public static void viewMembers(Connection con) throws SQLException {
        Statement stMembers = con.createStatement();
        ResultSet rsMembers = stMembers.executeQuery("SELECT * FROM members");
        System.out.println("\n--- Members ---");
        while (rsMembers.next()) {
            System.out.println(rsMembers.getInt("member_id") + " | " +
                               rsMembers.getString("name") + " | " +
                               rsMembers.getString("email") + " | " +
                               rsMembers.getString("books_borrowed"));
        }
    }

    public static void updateMember(Connection con, Scanner sc) throws SQLException {
        System.out.print("Enter Member ID to update: ");
        int updateMemberId = sc.nextInt();
        sc.nextLine();
        System.out.print("Which field do you want to update? (name/email/books_borrowed): ");
        String memField = sc.nextLine().toLowerCase();

        String memSql = "UPDATE members SET " + memField + " = ? WHERE member_id = ?";
        PreparedStatement updateMember = con.prepareStatement(memSql);

        System.out.print("Enter new " + memField + ": ");
        String newValue = sc.nextLine();
        updateMember.setString(1, newValue);
        updateMember.setInt(2, updateMemberId);

        int memberUpdated = updateMember.executeUpdate();
        System.out.println(memberUpdated > 0 ? "Member updated." : "Member not found.");
    }

    public static void deleteMember(Connection con, Scanner sc) throws SQLException {
        System.out.print("Enter Member ID to delete: ");
        int deleteMemberId = sc.nextInt();

        PreparedStatement deleteMember = con.prepareStatement("DELETE FROM members WHERE member_id = ?");
        deleteMember.setInt(1, deleteMemberId);
        int memberDeleted = deleteMember.executeUpdate();
        System.out.println(memberDeleted > 0 ? "Member deleted." : "Member not found.");
    }
}