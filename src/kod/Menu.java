package kod;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

public class Menu extends JPanel implements ActionListener {
    private MyJButton spr,zapis,wczytaj;
    public Menu (int x, int y, int a, int b) {
        setBounds(0,525,360,40);
        setLayout(new GridLayout(1,3,0,0));
        spr = new MyJButton("Sprawdź");
        zapis = new MyJButton("Zapisz sudoku");
        wczytaj = new MyJButton("Wczytaj sudoku");
        add(zapis);
        add(spr);
        add(wczytaj);
        spr.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object a = ae.getSource();
        if (a == spr) {
            if (MyJPanel.sprawdzT() == true) {
                System.out.println("Tak");
                MyJFrame.text.setText("Sudoku poprawnie rozwiazane");
                MyJPanel.wypiszT();
            } else {
                System.out.println("Nie");
                MyJPanel.wypiszT();
                MyJFrame.text.setText("Sudoku niepoprawnie rozwiazane");
            }
        }
    }
    
}
