package kod;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import static kod.MyJPanel.pola;
public class ButtonPanel extends JPanel {
    private JButton[] przyciski = new JButton[9];
    private JButton gumka;
    public ButtonPanel () {
        setLayout(new GridLayout(1,10,4,0));
        setBounds(0,485,360,35);
        gumka = new JButton("G");
        gumka.setFont(new Font("Arial", Font.BOLD, 15));
        gumka.setMargin(new Insets(0, 0, 0, 0));
        add(gumka);
        gumka.addActionListener(new Liczby());
        for (int i = 0; i<9; i ++) {
            przyciski[i] = new JButton(String.valueOf(i + 1));
            przyciski[i].setFont(new Font("Arial", Font.BOLD, 15));
            przyciski[i].setMargin(new Insets(0, 0, 0, 0));
            add(przyciski[i]);
            przyciski[i].addActionListener(new Liczby());
        }
    }
    class Liczby implements ActionListener {

        public Liczby() {
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            Object a = ae.getSource();
            for (int i = 0; i < 9; i++ ) {
                if (a == przyciski[i]) {
                    MyJPanel.setZ(i);
                    MyJPanel.setTexta();
                    for (int k = 0; k < 9; k ++ ) {
                       for (int l = 0; l < 9; l ++ ) {
                           if (pola[k][l].getText().equals(pola[MyJPanel.x][MyJPanel.y].getText())) {
                               pola[k][l].setForeground(Color.RED);
                           } else pola[k][l].setForeground(Color.BLACK);
                       }
                    }
                }
            }
            if (a == gumka) {
                    MyJPanel.gumka();
            }
        }
    }
}
