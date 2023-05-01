import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ShowContentsActionListener implements ActionListener {
    MyJFrame myJFrame;
    public ShowContentsActionListener(MyJFrame myJFrame){
        this.myJFrame=myJFrame;
    }
    public void actionPerformed(ActionEvent e) {
        if(myJFrame.openedFile!=null){
            myJFrame.contentPanel.removeAll();
            if(myJFrame.openedFile.isDirectory()){
                File[] files = myJFrame.openedFile.listFiles();
                for (File file : files) {
                    myJFrame.contentPanel.add(new JLabel(file.getName()));
                }
            }
            else{
                try {
                    FileInputStream fis = new FileInputStream(myJFrame.openedFile);
                    byte[] data = new byte[(int) myJFrame.openedFile.length()];
                    fis.read(data);
                    String text = new String(data);
                    myJFrame.contentPanel.add(new JLabel(text));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
            myJFrame.contentPanel.revalidate();
            myJFrame.contentPanel.repaint();
        }
    }

}
