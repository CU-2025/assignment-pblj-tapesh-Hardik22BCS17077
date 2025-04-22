import java.util.ArrayList;
import java.util.Scanner;

class Employee {
    int id;
    String name;
    double salary;

    Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Salary: " + salary;
    }
}

class EmployeeManagementSystem {
    private ArrayList<Employee> employees = new ArrayList<>();

    public void addEmployee(int id, String name, double salary) {
        for (Employee e : employees) {
            if (e.id == id) {
                System.out.println("Error: Employee with ID " + id + " already exists.");
                return;
            }
        }
        Employee newEmployee = new Employee(id, name, salary);
        employees.add(newEmployee);
        System.out.println("Employee Added: " + newEmployee);
    }

    public void updateEmployee(int id, double newSalary) {
        for (Employee e : employees) {
            if (e.id == id) {
                e.salary = newSalary;
                System.out.println("Employee ID " + id + " updated successfully.");
                return;
            }
        }
        System.out.println("Error: Employee with ID " + id + " not found.");
    }

    public void removeEmployee(int id) {
        for (Employee e : employees) {
            if (e.id == id) {
                employees.remove(e);
                System.out.println("Employee ID " + id + " removed successfully.");
                return;
            }
        }
        System.out.println("Error: Employee with ID " + id + " not found.");
    }

    public void searchEmployeeById(int id) {
        for (Employee e : employees) {
            if (e.id == id) {
                System.out.println("Employee Found: " + e);
                return;
            }
        }
        System.out.println("Error: Employee with ID " + id + " not found.");
    }

    public void displayEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
        } else {
            for (Employee e : employees) {
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {
        EmployeeManagementSystem ems = new EmployeeManagementSystem();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\n1. Add Employee\n2. Update Employee\n3. Remove Employee\n4. Search Employee\n5. Display All Employees\n6. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter ID, Name, Salary: ");
                    int id = scanner.nextInt();
                    String name = scanner.next();
                    double salary = scanner.nextDouble();
                    ems.addEmployee(id, name, salary);
                    break;
                case 2:
                    System.out.print("Enter ID, New Salary: ");
                    id = scanner.nextInt();
                    double newSalary = scanner.nextDouble();
                    ems.updateEmployee(id, newSalary);
                    break;
                case 3:
                    System.out.print("Enter ID to Remove: ");
                    id = scanner.nextInt();
                    ems.removeEmployee(id);
                    break;
                case 4:
                    System.out.print("Enter ID to Search: ");
                    id = scanner.nextInt();
                    ems.searchEmployeeById(id);
                    break;
                case 5:
                    ems.displayEmployees();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
