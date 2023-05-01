import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MyJFrame extends JFrame {

    JPanel nPanel= new JPanel();
    JPanel sPanel= new JPanel();
    JButton addBtn= new JButton("Add");
    JTextField nameTxt= new JTextField(10);
    JTextField addressTxt= new JTextField(20);
    JTextField idTxt= new JTextField(2);

    JButton clearBtn= new JButton("Clear");
    EmployeeTable table = new EmployeeTable(readEmployees());



 public MyJFrame() {
        super("Employees");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 800);
        setVisible(true);
        setLayout(new BorderLayout());




        add(nPanel, BorderLayout.NORTH);
        nPanel.add(new JLabel("ID: "));
        nPanel.add(idTxt);
        nPanel.add(new JLabel("Name: "));
        nPanel.add(nameTxt);
        nPanel.add(new JLabel("Address: "));
        nPanel.add(addressTxt);
        nPanel.add(addBtn);
        addBtn.addActionListener(new AddActionListener(this));
        nPanel.add(clearBtn);
        clearBtn.addActionListener(new ClearActionListener(this));



        add(sPanel, BorderLayout.CENTER);
        //table.setSize(800,400);
        //sPanel.add(table);


        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(700, 600));
        sPanel.add(scrollPane);
        sPanel.setBackground(Color.GRAY);

        JTableHeader header = table.getTableHeader();
        scrollPane.setColumnHeaderView(header);
        header.setBackground(Color.WHITE);

    }

    public static List<Employee> readEmployees() {
        List<Employee> employees = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("employee.ser"))) {
            while (true) {
                try {
                    Employee employee = (Employee) ois.readObject();
                    employees.add(employee);
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error reading employees from file: " + e.getMessage());
        }
        return employees;
    }


    public static void writeEmployees(List<Employee> employee) throws IOException {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("employee.ser"));
            for (Employee e : employee)
                oos.writeObject(e);
        } catch (IOException e) {
            System.err.println("Error writing employee to file: " + e.getMessage());
        } finally {
            oos.close();
        }
    }

}
