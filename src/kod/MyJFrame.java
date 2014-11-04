package kod;

import javax.swing.*;

class MyJFrame extends JFrame {
    private MyJPanel plansza;
    private ButtonPanel przyci;
    public static PanelPrzypisow przyp;
    private Menu men;
    public static JTextField text;
    public MyJFrame() {
        setVisible(true);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        plansza = new MyJPanel();
        przyci = new ButtonPanel();
        text = new JTextField();
        przyp = new PanelPrzypisow();
        text.setBounds(0, 0, 360, 100);
        men = new Menu(130,530,100,40);
        //add(przyp);
        add(plansza);
        add(przyci);
        add(men);
        add(text);
        MyJPanel.koloruj();
        
    }
    
}
