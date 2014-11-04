package kod;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class MyJLabel extends JLabel {
    public MyJLabel (int a) {
        String b = String.valueOf(a);
        if (a != 0) {
            setText(b);
        }
        setFont(new Font("Arial",Font.BOLD,20));
        setForeground(Color.black);
        setVisible(true);
        setBackground(Color.white);
        setOpaque(true);
        setHorizontalAlignment(SwingConstants.CENTER);
    }
}
