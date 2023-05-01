import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class OpenActionListener implements ActionListener {
    MyJFrame myJFrame;
    public OpenActionListener(MyJFrame myJFrame){
        this.myJFrame=myJFrame;
    }
    public void actionPerformed(ActionEvent e) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            int result = fileChooser.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                myJFrame.setLabelText(file.getAbsolutePath());
                myJFrame.setOpenedFile(file);
            }

    }
}
