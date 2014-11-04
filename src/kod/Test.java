package kod;

import java.awt.*;

public class Test {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable () { 

            @Override
            public void run() {
                MyJFrame frame = new MyJFrame();
                Insets a = frame.getInsets();
                frame.setBounds(500,200,360 + a.left + a.right,580 + a.top + a.bottom );
            }
            int a;
            
        });
    }
    
}
