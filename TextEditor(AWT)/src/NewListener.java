import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class NewListener implements ActionListener {
    MyFrameAWT myFrameAWT;
    public NewListener(MyFrameAWT myFrameAWT)
    {
        this.myFrameAWT = myFrameAWT;
    }
    public void actionPerformed(ActionEvent e) {
        myFrameAWT.textArea.setText("");
    }
}
