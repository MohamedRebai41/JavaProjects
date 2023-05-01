import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class JTableEx extends JFrame {

    DefaultTableModel dataModel=new DefaultTableModel();


    ArrayList<MyThread> threads = new ArrayList<MyThread>();


    public JTableEx(int c1, int c2, int c3)
    {
        MyThread t=new MyThread(0,c1, this);
        MyThread t2=new MyThread(1,c2,this);
        MyThread t3=new MyThread(2,c3,this);

        threads.add(t);
        threads.add(t2);
        threads.add(t3);

        dataModel.addColumn("ThreadID");
        dataModel.addColumn("Counter");
        dataModel.addColumn("Pause");
        dataModel.addColumn("Resume");
        dataModel.addColumn("Reset");

        dataModel.addRow(new Object[]{ 0, c1, "Pause", "Resume", "Reset"});
        dataModel.addRow(new Object[]{ 1, c2, "Pause", "Resume", "Reset"});
        dataModel.addRow(new Object[]{ 2, c3, "Pause", "Resume", "Reset"});
        JTable table = new JTable(dataModel);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(500, 300));
        this.getContentPane().add(scrollPane);

        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int row = table.rowAtPoint(e.getPoint());
                int col = table.columnAtPoint(e.getPoint());
                if (col >= 2) {
                    if (col == 2) {
                        threads.get(row).pauseThread();
                    } else if (col == 3) {
                        threads.get(row).resumeThread();
                    } else if (col == 4) {
                        threads.get(row).resetThread();
                    }
                }
            }
        });



        this.pack();
        this.setVisible(true);

        t.start();
        t2.start();
        t3.start();
    }
    // Method to update the table with new counter values
    public void updateTable(int id, int n) {
        dataModel.setValueAt(n, id, 1);
    }
}

