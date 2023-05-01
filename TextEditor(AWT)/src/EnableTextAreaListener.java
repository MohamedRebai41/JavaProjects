import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EnableTextAreaListener implements ActionListener {
    MyFrameAWT myFrameAWT;
    public EnableTextAreaListener(MyFrameAWT myFrameAWT) {
        this.myFrameAWT=myFrameAWT;
    }
    public void actionPerformed(ActionEvent e) {
        myFrameAWT.textArea.setEnabled(true);
    }
}
