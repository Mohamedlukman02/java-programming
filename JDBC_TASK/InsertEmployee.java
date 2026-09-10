import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertEmployee {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();

        sc.nextLine();

        System.out.print("Enter Employee Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Department: ");
        String department = sc.nextLine();

        System.out.print("Enter Salary: ");
        double salary = sc.nextDouble();

        String url = "jdbc:mysql://localhost:3306/company_db";
        String user = "root";
        String password = "admin123";

        Connection con = DriverManager.getConnection(url, user, password);

        String sql = "INSERT INTO employee VALUES (?, ?, ?, ?)";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, id);
        ps.setString(2, name);
        ps.setString(3, department);
        ps.setDouble(4, salary);

        int result = ps.executeUpdate();

        if (result > 0) {
            System.out.println("Employee inserted successfully.");
        }

        ps.close();
        con.close();
        sc.close();
    }
}