import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UpdateEmployeeSalary {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();

        System.out.print("Enter New Salary: ");
        double salary = sc.nextDouble();

        String url = "jdbc:mysql://localhost:3306/company_db";
        String user = "root";
        String password = "admin123";

        Connection con = DriverManager.getConnection(url, user, password);

        String sql = "UPDATE employee SET salary = ? WHERE emp_id = ?";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setDouble(1, salary);
        ps.setInt(2, id);

        int result = ps.executeUpdate();

        System.out.println("Number of records updated: " + result);

        ps.close();
        con.close();
        sc.close();
    }
}