import java.io.FileInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Employee {
    private String name;
    private String address;
    private int id;

    public Employee(String name, String address, int id) {
        this.name = name;
        this.address = address;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String toString() {
        return  id + ":" + name + ":" + address + "\n";
    }


    public static Employee parseEmployee(String line) {
        String[] parts = line.split(":");
        return new Employee(parts[1], parts[2], Integer.parseInt(parts[0]));
    }

    public static List<Employee> readEmployees(File file) throws FileNotFoundException {
        List<Employee> employees = new ArrayList<Employee>();
        FileInputStream inputStream = new FileInputStream(file);
        Scanner scanner = new Scanner(inputStream);
        while (scanner.hasNextLine()) {
            Employee employee = parseEmployee(scanner.nextLine());
            employees.add(employee);
        }
        return employees;
    }
}
