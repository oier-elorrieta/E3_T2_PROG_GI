package master;
import java.sql.Connection;

import vista.vEtorria;
import vista.vLogin;

public class Controlador {

    public static void main(String[] args) {

        Modelo mDatuak = new Modelo();
        
        konexioa k1 = new konexioa();
        Connection saioa = k1.hasi();
        k1.fullLoad(mDatuak, saioa);
        
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
