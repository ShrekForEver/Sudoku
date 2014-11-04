package kod;

import java.awt.*;
import java.awt.event.*;
import java.awt.font.TextAttribute;
import java.util.Map;
import java.util.Random;
import javax.swing.*;

class MyJPanel extends JPanel {
    private WczytanieSudoku sudoku;
    public static int x = 99, y = 99, z;
    private static int[][] t;
    public static MyJLabel[][] pola = new MyJLabel[9][9];
    public MyJPanel () {
        setBounds(0, 120, 360, 360);
        setBackground(Color.black);
        setLayout(new GridLayout(9, 9, 3, 3));
        sudoku = new WczytanieSudoku();
        Random gen = new Random();
        int a = gen.nextInt(10);
        sudoku.wczytajPlansze(a);
        sudoku.losujPlansze();
        sudoku.mieszajT();
        t = sudoku.getT();
        for (int i = 0; i < 9; i ++) {
            for (int j = 0; j < 9; j ++) {
                pola[i][j] = new MyJLabel(t[i][j]);
                add(pola[i][j]);
                pola[i][j].addMouseListener(new Zaznaczone());
            }
        }
        //sudoku.wypiszT();
                
    }
    public static void koloruj () {
        for (int i = 0; i < 3; i ++) {
            for (int j = 0; j < 3; j ++) {
                pola[i][j].setBackground(Color.LIGHT_GRAY);
                pola[i][j+6].setBackground(Color.LIGHT_GRAY);
                pola[i+3][j+3].setBackground(Color.LIGHT_GRAY);
                pola[i+6][j].setBackground(Color.LIGHT_GRAY);
                pola[i+6][j+6].setBackground(Color.LIGHT_GRAY);
                pola[i][j+3].setBackground(Color.WHITE);
                pola[i+3][j].setBackground(Color.WHITE);
                pola[i+3][j+6].setBackground(Color.WHITE);
                pola[i+6][j+3].setBackground(Color.WHITE);
            }
        }
    }
    public static void setTexta () {
        Font font = pola[x][y].getFont();
        if ((x != 99) && ((font.isItalic()) || (t[x][y] == 0) )) {  
            final Map attributes = (new Font("Arial",Font.ITALIC,20)).getAttributes();
            attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
            pola[x][y].setFont(new Font(attributes));
            pola[x][y].setText(String.valueOf(z + 1));
            t[x][y] = z + 1;
        }
    }
    public static void gumka () {
        Font font = pola[x][y].getFont();
        if (font.isItalic()) {
            t[x][y] = 0;
            //pola[x][y].setForeground(Color.DARK_GRAY);
            //pola[x][y].setFont(new Font("Arial",Font.ITALIC,20));
            pola[x][y].setText("");
            //System.out.println(pola[x][y].getFont());
        }
        
    }
    public static int[][] getT() {
        return t;
    }
    public static void wypiszT () {
        for (int i = 0; i < 9; i ++ ) {
            for (int j = 0; j < 9; j ++ ) {
                System.out.print(t[i][j] + " ");
            }
        System.out.println();
        }
    }
    public static void setZ ( int a) {
         z = a;
    }
    public static boolean sprawdzT() {
        long suma,suma2;
        for (int i = 0; i < 9; i ++) {
            suma=1;
            suma2=1;
            for (int j = 0; j < 9; j ++) {
                suma *= t[i][j];
                suma2 *= t[j][i];
            }
            if ((suma != 362880) || (suma2 != 362880)) {
                return false;
            }
        }
        int[] pom = new int[9];
        for (int i = 0; i < 9; i ++) {
            pom[i] = 1;
        }
        for (int i = 0; i < 3; i ++) {
            for (int j = 0; j < 3; j ++) {
                pom[0] *= t[i][j];
                pom[1] *= t[i][j+3];
                pom[2] *= t[i][j+6];
                pom[3] *= t[i+3][j];
                pom[4] *= t[i+3][j+3];
                pom[5] *= t[i+3][j+6];
                pom[6] *= t[i+6][j];
                pom[7] *= t[i+6][j+3];
                pom[8] *= t[i+6][j+6];
            }
        }
        for (int i=0; i<9; i++) {
            if (pom[i]!=362880) {
                return false;
            }
        }
        return true;
    }
    class Zaznaczone implements MouseListener {
        Zaznaczone() {
    }
    
        @Override
        public void mouseClicked(MouseEvent me) {
        
    }

        @Override
        public void mousePressed(MouseEvent me) {
        Object a = me.getSource();
        for (int i = 0; i < 9; i ++) {
            for (int j = 0; j < 9; j ++) {
                if (a == pola[i][j]) {
                    koloruj();
                    pola[i][j].setBackground(Color.yellow);
                    for (int k = 0; k < 9; k ++ ) {
                       for (int l = 0; l < 9; l ++ ) {
                           if (pola[k][l].getText().equals(pola[i][j].getText())) {
                               pola[k][l].setForeground(Color.RED);
                           } else pola[k][l].setForeground(Color.BLACK);
                       }
                    }
                    x = i;
                    y = j;
                } 
            }
        }
    }

        @Override
        public void mouseReleased(MouseEvent me) {
    }

        @Override
        public void mouseEntered(MouseEvent me) {
    }

        @Override
        public void mouseExited(MouseEvent me) {
    }
    
    }
}

