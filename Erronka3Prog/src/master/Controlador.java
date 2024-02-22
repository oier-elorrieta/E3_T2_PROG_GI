package master;
import java.sql.Connection;
import vista.vData;

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
        
        k1.fullLoad(saioa, mDatuak);
        k1.bezeroLoad(saioa, mDatuak);
		/*Zinema zinema = mDatuak.Zinemak[0];
		Saioa[] saioak = zinema.getSaioak();
		Filma filmak;
		for (int i = 0; i < saioak.length; i++) {
			filmak = saioak[i].getFilma();
			System.out.println(filmak);
		}*/
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

        vLogin vLogin = new vLogin(mDatuak);
		vLogin.setVisible(true);
		if (mDatuak.isLoginOk() == true)
		vLogin.dispose();
    }
}
