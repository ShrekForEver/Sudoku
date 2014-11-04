package kod;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JPanel;

public class PanelPrzypisow extends JPanel {
     private Przypisy[][] przypis = new Przypisy[9][9];
    public PanelPrzypisow () {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                przypis[i][j] = new Przypisy();
                add(przypis[i][j]);
            }
        }
        setLayout(new GridLayout(9, 9, 3, 3));
        setBounds(0, 120, 360, 360);
        setBackground(Color.black);
        setOpaque(false);
    }
}
