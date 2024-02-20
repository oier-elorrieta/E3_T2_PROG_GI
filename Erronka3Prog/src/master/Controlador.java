package master;
import java.sql.Connection;

import vista.vEtorria;
import vista.vLogin;

public class Controlador {

    public static void main(String[] args) {
    	System.out.println("HASI DA");
        Modelo mDatuak = new Modelo();

        konexioa k1 = new konexioa();
        System.out.println("Konexioa burutuko da");
        Connection saioa = k1.hasi();
        System.out.println("Konexioa burutu da");
        
        k1.fullLoad(saioa);

        vEtorria Ongipanel = new vEtorria(mDatuak);
        Ongipanel.setVisible(true);
         
        while (!mDatuak.irekiLogin) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        Ongipanel.dispose();

        vLogin Loginpanel = new vLogin(mDatuak);
        Loginpanel.setVisible(true);
    }
}
