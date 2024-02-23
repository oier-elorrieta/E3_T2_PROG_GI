package master;
import java.sql.Connection;
import vista.vData;

import vista.vEtorria;
import vista.vLogin;

public class Controlador {

    public static void main(String[] args) {
    	
        Modelo mDatuak = new Modelo();

        //Konexioa eta datuak
        konexioa k1 = new konexioa();
        Connection saioa = k1.hasi();
        k1.fullLoad(saioa, mDatuak);
        k1.bezeroLoad(saioa, mDatuak);
        
        //Ongi etorri menua kargatu
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

        //Login ezarri eta jarraitu ondo badago
        vLogin vLogin = new vLogin(mDatuak);
		vLogin.setVisible(true);
		if (mDatuak.isLoginOk() == true)
		vLogin.dispose();
    }
}
