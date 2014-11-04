package kod;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JPanel;

public class Przypisy extends JPanel {
    private Przypis[][] przypis = new Przypis[3][3];
    public Przypisy () {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                przypis[i][j] = new Przypis();
                add(przypis[i][j]);
                if ((i==1) && (j==1)) {
                    przypis[i][j].setVisible(false);
                }
            }
        }
        
        setLayout(new GridLayout(3, 3, 10, 10));
        setBounds(0, 120, 360, 360);
        setBackground(Color.black);
        setOpaque(false);
    }
}
