import java.awt.*;
import java.io.File;

public class MyFrameAWT extends Frame
{
    File CurrentFile = null;
    TextArea textArea = new TextArea();
    Button newButton = new Button("New");
    Button openButton = new Button("Open");
    Button saveButton = new Button("Save");
    Button exitButton = new Button("Exit");
    Panel pNorth = new Panel();
    Panel pSouth = new Panel();
    public MyFrameAWT()
    {
        addWindowListener(new MyWindowListener());
        setTitle("MyFrameAWT");
        setSize(600, 500);
        setVisible(true);
        setLayout(new GridLayout(2,1));
        // north Panel
        pNorth.setBackground(Color.GREEN);
        add(pNorth);
        pNorth.setLayout(new FlowLayout(FlowLayout.CENTER));
        pNorth.add(newButton);
        pNorth.add(openButton);
        pNorth.add(saveButton);
        pNorth.add(exitButton);
        // south Panel
        add(pSouth);
        pSouth.setBackground(Color.YELLOW);
        pSouth.setLayout(new FlowLayout(FlowLayout.CENTER));
        textArea.setSize(300, 300);
        textArea.setEnabled(false);
        pSouth.add(textArea);

        // Button actions
        openButton.addActionListener(new OpenListener(this));
        openButton.addActionListener(new EnableTextAreaListener(this));
        exitButton.addActionListener(new ExitListener());
        newButton.addActionListener(new NewListener(this));
        newButton.addActionListener(new EnableTextAreaListener(this));
        saveButton.addActionListener(new SaveListener(this));
        saveButton.addActionListener(new EnableTextAreaListener(this));




    }

    public void setCurrentFile(File CurrentFile)
    {
        this.CurrentFile = CurrentFile;
    }
}
