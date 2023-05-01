import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AddActionListener implements ActionListener {

    MyJFrame frame;
    public AddActionListener(MyJFrame frame)
    {
        this.frame = frame;
    }


    public void actionPerformed(ActionEvent e)
    {
        List<Employee> employees=frame.readEmployees();
        Employee employee = new Employee(frame.nameTxt.getText(), frame.addressTxt.getText(), Integer.parseInt(frame.idTxt.getText()));
        employees.add(employee);
        try {
            frame.writeEmployees(employees);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        frame.nameTxt.setText("");
        frame.addressTxt.setText("");
        frame.idTxt.setText("");
        frame.table.refreshTable(employees);
        System.out.println("Employee added");
    }

}
