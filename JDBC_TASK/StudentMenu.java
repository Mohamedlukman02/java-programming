import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class StudentMenu {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        String url = "jdbc:mysql://localhost:3306/college_db";
        String user = "root";
        String password = "admin123";

        Connection con = DriverManager.getConnection(url, user, password);

        while (true) {

            System.out.println("\n--- Student Menu ---");
            System.out.println("1. Insert Student");
            System.out.println("2. Update Student Marks");
            System.out.println("3. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            if (choice == 1) {

                System.out.print("Enter Student ID: ");
                int id = sc.nextInt();

                sc.nextLine();

                System.out.print("Enter Student Name: ");
                String name = sc.nextLine();

                System.out.print("Enter Course: ");
                String course = sc.nextLine();

                System.out.print("Enter Marks: ");
                int marks = sc.nextInt();

                sc.nextLine();

                System.out.print("Enter City: ");
                String city = sc.nextLine();

                String sql = "INSERT INTO student VALUES (?, ?, ?, ?, ?)";

                PreparedStatement ps = con.prepareStatement(sql);

                ps.setInt(1, id);
                ps.setString(2, name);
                ps.setString(3, course);
                ps.setInt(4, marks);
                ps.setString(5, city);

                int result = ps.executeUpdate();

                if (result > 0) {
                    System.out.println("Student inserted successfully.");
                }

                ps.close();

            } else if (choice == 2) {

                System.out.print("Enter Student ID: ");
                int id = sc.nextInt();

                System.out.print("Enter New Marks: ");
                int marks = sc.nextInt();

                String sql = "UPDATE student SET marks = ? WHERE student_id = ?";

                PreparedStatement ps = con.prepareStatement(sql);

                ps.setInt(1, marks);
                ps.setInt(2, id);

                int result = ps.executeUpdate();

                System.out.println("Number of records updated: " + result);

                ps.close();

            } else if (choice == 3) {

                System.out.println("Program exited.");
                break;

            } else {

                System.out.println("Invalid choice.");
            }
        }

        con.close();
        sc.close();
    }
}