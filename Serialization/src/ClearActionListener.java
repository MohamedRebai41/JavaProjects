import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class ClearActionListener implements ActionListener {
    MyJFrame frame;
    public ClearActionListener(MyJFrame frame)
    {
        this.frame = frame;
    }
    public void actionPerformed(ActionEvent e)
    {
        try {
            frame.writeEmployees(new ArrayList<Employee>());
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        frame.table.refreshTable(new ArrayList<Employee>());
    }
}
