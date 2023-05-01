import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
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



    public static void main(String[] args) throws IOException {
        File file = new File("employees.txt");
        file.createNewFile();
        FileWriter writer = new FileWriter(file,true);
        Employee employee = getNewEmployee();
        writer.write(employee.toString());
        writer.close();
        List<Employee> employees = Employee.readEmployees(file);
        for (Employee employee1 : employees) {
            System.out.println(employee1);
        }
    }
}