import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class EmployeeDatabase {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/your_database"; // Replace 'your_database' with actual database name
        String user = "root"; // Replace with your MySQL username
        String password = "your_password"; // Replace with your MySQL password

        try {
            // Establish connection
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the database successfully!");

            // Create a statement
            Statement stmt = conn.createStatement();

            // Execute query
            String query = "SELECT EmpID, Name, Salary FROM Employee";
            ResultSet rs = stmt.executeQuery(query);

            // Display records
            System.out.println("\nEmployee Records:");
            while (rs.next()) {
                int empId = rs.getInt("EmpID");
                String name = rs.getString("Name");
                double salary = rs.getDouble("Salary");

                System.out.println("EmpID: " + empId + ", Name: " + name + ", Salary: " + salary);
            }

            // Close resources
            rs.close();
            stmt.close();
            conn.close();
            System.out.println("\nDisconnected from database.");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
