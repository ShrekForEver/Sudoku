package kod;

import java.io.*;
import java.util.*;

public class WczytanieSudoku {
    private int t[][] = new int[9][9];
    public void wczytajPlansze(int idPlanszy) {
        try {
            InputStream is = getClass().getResourceAsStream("easy.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            int i = 0, k = 0, l = 0;
            String thisLine;
            while ((thisLine = br.readLine()) != null) {
                if (( i >= idPlanszy*9 ) && ( i < ( idPlanszy + 1 ) * 9 )) {
                    for (int j = 0; j < 9; j ++) {
                        t[k][j] = thisLine.charAt(l) - 48;
                        l+=2;
                    }
                    l = 0;
                    k ++;
                }
                i++;
            }
        } catch (IOException e) {
        }
        
        
    }
    public void wypiszT () {
        for (int i = 0; i < 9; i ++ ) {
            for (int j = 0; j < 9; j ++ ) {
                System.out.print(t[i][j] + " ");
            }
        System.out.println();
        }
    }
    public int[][] getT () {
        return t;
    }
    public void losujPlansze () {
        for (int i = 0; i < 9; i ++ ) {
            Random gen1 = new Random();
            int k = gen1.nextInt(2)+6;
            for ( int j = 0 ; j < k; j ++ ) {
                Random gen = new Random();
                t[i][gen.nextInt(9)] = 0;
            }
        }
    }
    public void mieszajT() {
        for (int i=0; i<100; i++) {
            Random gen = new Random();
            int a = gen.nextInt(3), b = gen.nextInt(3);
            int[] pom1,pom2 = new int[9];
            for (int j = 0; j <= 6; j += 3) {
                a = gen.nextInt(3)+j;
                b = gen.nextInt(3)+j;
                pom1 = getWiersz(t, a, true);
                pom2 = getWiersz(t, b, true);
                setWiersz(pom1, b, true);
                setWiersz(pom2, a, true);
                
                a = gen.nextInt(3)+j;
                b = gen.nextInt(3)+j;
                pom1 = getWiersz(t, a, false);
                pom2 = getWiersz(t, b, false);
                setWiersz(pom1, b, false);
                setWiersz(pom2, a, false);
            }
        }
        for (int i = 0; i < 100; i ++) {
            Random gen = new Random();
            int a = gen.nextInt(3), b = gen.nextInt(3);
            int [][] pom,pom1 = new int[3][9];
            
            pom = get3x9(t, a, true);                       //poziom
            pom1 = get3x9(t, b, true);
            set3x9(pom, b, true);
            set3x9(pom1, a, true);
            
            pom = get3x9(t, a, false);                       //pion
            pom1 = get3x9(t, b,false);
            set3x9(pom, b, false);
            set3x9(pom1, a, false);
        }
        
    }
    public int[] getWiersz ( int[][] tab, int a, boolean pom) {
        int[] t = new int[9];
        if (pom == true) {
            System.arraycopy(tab[a], 0, t, 0, 9);
            
        } else {
            for (int i=0; i < 9; i++) {
                t[i] = tab[i][a];
            }
        }
        return t;
    }
    public void setWiersz (int tab[], int a, boolean pom) {
        if (pom == true) {
            System.arraycopy(tab, 0, t[a], 0, 9);
        } else {
            for (int i=0; i<9; i++) {
                t[i][a] = tab[i];
            }
        }
    }
    public int[][] get3x9 (int[][] tab, int a, boolean pom) {
        int[][] t = new int[3][9];
        if (pom == true) {
            for (int i = 0; i < 3 ; i ++) {
                for (int j = 0; j < 9; j++) {
                    t[i][j] = tab[i + (a * 3) ][j];
                }
            } 
        } else {
            for (int i = 0; i < 3 ; i ++) {
                for (int j = 0; j < 9; j++) {
                    t[i][j] = tab[j][i + (a * 3) ];
                }
            } 
        }
        return t;
    }
    public void set3x9 (int tab[][], int a, boolean pom) {
        if (pom == true) {
            for (int i = 0; i < 3 ; i ++) {
                for (int j = 0; j < 9; j++) {
                    t[i+ (a * 3)][j] = tab[i][j];
                }
            } 
        } else {
            for (int i = 0; i < 3 ; i ++) {
                for (int j = 0; j < 9; j++) {
                    t[j][i+ (a * 3)] = tab[i][j];
                }
            } 
        }
    }
}
