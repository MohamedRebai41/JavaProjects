
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {



    private static Employee getNewEmployee() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter employee name: ");
        String name = scanner.nextLine();
        System.out.print("Enter employee address: ");
        String address = scanner.nextLine();
        System.out.print("Enter employee id: ");
        int id = scanner.nextInt();
        return new Employee(name, address, id);
    }

    private static void printEmployees(List<Employee> employees) {
        System.out.println("Employees:");
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public static void main(String[] args) {
        MyJFrame frame = new MyJFrame();

    }
}