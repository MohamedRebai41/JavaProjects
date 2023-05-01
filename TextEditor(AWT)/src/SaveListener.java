import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SaveListener implements ActionListener{
    MyFrameAWT myFrameAWT;
    public SaveListener(MyFrameAWT myFrameAWT) {
        this.myFrameAWT=myFrameAWT;
    }
    public void actionPerformed(ActionEvent e) {
        FileDialog fd = new FileDialog(new Frame(), "Save", FileDialog.SAVE);
        fd.setVisible(true);
        String filename = fd.getFile();
        File newFile=new File(fd.getDirectory() + filename);

        try {
            FileWriter fw = new FileWriter(newFile);
            fw.write(myFrameAWT.textArea.getText());
            fw.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try {
            newFile.createNewFile();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        myFrameAWT.setCurrentFile(newFile);
    }
}
