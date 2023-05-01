import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class OpenListener implements ActionListener {
    MyFrameAWT myFrameAWT;
    public OpenListener(MyFrameAWT myFrameAWT) {
        this.myFrameAWT=myFrameAWT;
    }

    public void actionPerformed(ActionEvent e) {
        FileDialog fd = new FileDialog(new Frame(), "Open", FileDialog.LOAD);
        fd.setVisible(true);
        String filename = fd.getFile();
        if (filename != null) {
            System.out.println("You chose " + fd.getDirectory() + filename);
            File openedFile=new File(fd.getDirectory() + filename);
            System.out.println("File size: "+openedFile.length());
            try {
                FileInputStream fis=new FileInputStream(openedFile);
                byte[] buffer=new byte[(int)openedFile.length()];
                fis.read(buffer);
                String fileContent=new String(buffer);
                myFrameAWT.textArea.setText(fileContent);
                myFrameAWT.setCurrentFile(openedFile);
            } catch (IOException ex) {
                ex.printStackTrace();}

        }
    }
}
