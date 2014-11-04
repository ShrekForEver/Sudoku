package kod;

import java.awt.Insets;
import javax.swing.JButton;

public class MyJButton extends JButton {
    public MyJButton (String s) {
        setText(s);setMargin(new Insets(0, 0, 0, 0));
    }
}
