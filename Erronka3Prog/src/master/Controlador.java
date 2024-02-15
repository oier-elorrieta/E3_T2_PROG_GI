package master;
import vista.vEtorria;
import vista.vLogin;

public class Controlador {

    public static void main(String[] args) {

        Modelo mDatuak = new Modelo();

        vEtorria Ongipanel = new vEtorria(mDatuak);
        Ongipanel.setVisible(true);

        while (!mDatuak.irkeiLogin) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Ongipanel.dispose();

        vLogin Loginpanel = new vLogin();
        Loginpanel.setVisible(true);
    }
}
