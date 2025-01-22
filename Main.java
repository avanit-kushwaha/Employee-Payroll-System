import java.util.ArrayList;
import java.util.List;

abstract class Employee {
    private String name;
    private int id;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    // Abstract method to be implemented by subclasses
    public abstract double calculateSalary();

    @Override
    public String toString() {
        return "Employee [name=" + name + ", id=" + id + ", salary=" + calculateSalary() + "]";
    }
}

class FullTimeEmployee extends Employee {
    private double monthlySalary;

    public FullTimeEmployee(String name, int id, double monthlySalary) {
        super(name, id);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalary() {
        return monthlySalary;
    }
}

class PartTimeEmployee extends Employee {
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(String name, int id, int hoursWorked, double hourlyRate) {
        super(name, id);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return hoursWorked * hourlyRate;
    }
}

class PayrollSystem {
    private List<Employee> employeeList;

    public PayrollSystem() {
        employeeList = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    public void removeEmployee(int id) {
        Employee employeeToRemove = null;
        for (Employee employee : employeeList) {
            if (employee.getId() == id) {
                employeeToRemove = employee;
                break;
            }
        }
        if (employeeToRemove != null) {
            employeeList.remove(employeeToRemove);
        }
    }

    public void displayEmployees() {
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        PayrollSystem payrollSystem = new PayrollSystem();

        // Creating 10 Full-Time Employees
        FullTimeEmployee emp1 = new FullTimeEmployee("John Doe", 101, 5000.0);
        FullTimeEmployee emp2 = new FullTimeEmployee("Alice Johnson", 102, 5500.0);
        FullTimeEmployee emp3 = new FullTimeEmployee("Robert Brown", 103, 5200.0);
        FullTimeEmployee emp4 = new FullTimeEmployee("Emily Davis", 104, 5100.0);
        FullTimeEmployee emp5 = new FullTimeEmployee("Michael Wilson", 105, 5400.0);
        FullTimeEmployee emp6 = new FullTimeEmployee("Sophia Garcia", 106, 5300.0);
        FullTimeEmployee emp7 = new FullTimeEmployee("James Martinez", 107, 5600.0);
        FullTimeEmployee emp8 = new FullTimeEmployee("Olivia Hernandez", 108, 5700.0);
        FullTimeEmployee emp9 = new FullTimeEmployee("William Lopez", 109, 5800.0);
        FullTimeEmployee emp10 = new FullTimeEmployee("Isabella Moore", 110, 5900.0);

// Creating 10 Part-Time Employees
        PartTimeEmployee emp11 = new PartTimeEmployee("Jane Smith", 201, 30, 15.0);
        PartTimeEmployee emp12 = new PartTimeEmployee("Daniel Taylor", 202, 25, 18.0);
        PartTimeEmployee emp13 = new PartTimeEmployee("Lucas Anderson", 203, 20, 20.0);
        PartTimeEmployee emp14 = new PartTimeEmployee("Emma Thomas", 204, 28, 16.0);
        PartTimeEmployee emp15 = new PartTimeEmployee("Charlotte Jackson", 205, 22, 17.5);
        PartTimeEmployee emp16 = new PartTimeEmployee("Benjamin White", 206, 26, 18.5);
        PartTimeEmployee emp17 = new PartTimeEmployee("Ava Harris", 207, 24, 19.0);
        PartTimeEmployee emp18 = new PartTimeEmployee("Noah Martin", 208, 30, 14.5);
        PartTimeEmployee emp19 = new PartTimeEmployee("Liam Clark", 209, 32, 13.0);
        PartTimeEmployee emp20 = new PartTimeEmployee("Amelia Lewis", 210, 27, 18.0);


        // Adding all Full-Time Employees to the Payroll System
        payrollSystem.addEmployee(emp1);
        payrollSystem.addEmployee(emp2);
        payrollSystem.addEmployee(emp3);
        payrollSystem.addEmployee(emp4);
        payrollSystem.addEmployee(emp5);
        payrollSystem.addEmployee(emp6);
        payrollSystem.addEmployee(emp7);
        payrollSystem.addEmployee(emp8);
        payrollSystem.addEmployee(emp9);
        payrollSystem.addEmployee(emp10);

// Adding all Part-Time Employees to the Payroll System
        payrollSystem.addEmployee(emp11);
        payrollSystem.addEmployee(emp12);
        payrollSystem.addEmployee(emp13);
        payrollSystem.addEmployee(emp14);
        payrollSystem.addEmployee(emp15);
        payrollSystem.addEmployee(emp16);
        payrollSystem.addEmployee(emp17);
        payrollSystem.addEmployee(emp18);
        payrollSystem.addEmployee(emp19);
        payrollSystem.addEmployee(emp20);


        System.out.println("Initial Employee Details:");
        payrollSystem.displayEmployees();

        System.out.println("\nRemoving Employee...");
        payrollSystem.removeEmployee(101);

        System.out.println("\nRemaining Employee Details:");
        payrollSystem.displayEmployees();
    }
}
