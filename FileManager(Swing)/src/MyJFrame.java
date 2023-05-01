import javax.swing.*;
import java.awt.*;
import java.io.File;

public class MyJFrame extends JFrame {

    File openedFile;
    JLabel label = new JLabel("Select a File");
    JPanel openPanel = new JPanel();
    JPanel contentPanel = new JPanel();
    JButton showContentButton = new JButton("Show Content");
    JPanel menu = new JPanel();
    JButton openButton = new JButton("Open");


    public MyJFrame(){
        //Frame setup
        super("MyJFrame");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(new BorderLayout());
        //Content setup
        JPanel northPanel = new JPanel();
        northPanel.setLayout(new BorderLayout());
        northPanel.setPreferredSize(new Dimension(600, 100));
        openPanel.setBackground(Color.CYAN);
        openPanel.setPreferredSize( new Dimension(600, 50));
        openPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        northPanel.add(openPanel, BorderLayout.NORTH);
        menu.setBackground(Color.GREEN);
        menu.setPreferredSize(new Dimension(600, 50));
        menu.setLayout(new FlowLayout(FlowLayout.CENTER));
        northPanel.add(menu, BorderLayout.CENTER);
        add(northPanel, BorderLayout.NORTH);
        contentPanel.setBackground(Color.YELLOW);
        contentPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        add(contentPanel, BorderLayout.CENTER);


        // Buttons setup
        openPanel.add(openButton);
        openButton.addActionListener(new OpenActionListener(this));
        menu.add(showContentButton);
        showContentButton.addActionListener(new ShowContentsActionListener(this));

        //label setup
        openPanel.add(label);


    }

    public void setLabelText(String text) {
        label.setText(text);
    }

    public void setOpenedFile(File file){
        openedFile = file;
    }
}
