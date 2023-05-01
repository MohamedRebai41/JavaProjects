import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import java.util.List;

public class EmployeeTable extends JTable{
    public EmployeeTable(List<Employee> employees) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Name");
        model.addColumn("Address");


        for (Employee employee : employees) {
            model.addRow(new Object[]{employee.getId(), employee.getName(), employee.getAddress()});
        }
        setModel(model);
        getColumnModel().getColumn(0).setPreferredWidth(50);
        getColumnModel().getColumn(1).setPreferredWidth(150);
        getColumnModel().getColumn(2).setPreferredWidth(250);


    }

    public void refreshTable(List<Employee> employees) {
        DefaultTableModel model = (DefaultTableModel) getModel();
        model.setRowCount(0);
        for (Employee employee : employees) {
            model.addRow(new Object[]{employee.getId(), employee.getName(), employee.getAddress()});
        }
    }
}
