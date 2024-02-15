package master;
import javax.swing.SwingUtilities;
import vista.vLogin;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import vista.vEtorria;

public class Modelo {
	Aretoa Aretoak[];
	Bezero Bezeroak[];
	Erosketa Erosketak[];
	Filma Filmak[];
	Saioa Saioak[];
	Sarrera Sarrerak[];
	Zinema Zinemak[];
	
	private String admin_user = "admin";
	private String admin_pass = "1234";
	private String erabiltzailea_user = "erabili";
	private String erabiltzailea_pass = "4321";

	
    public boolean irkeiLogin = false;

    public Modelo() {
    }

    public void abrirvEtorria() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                vEtorria ventana = new vEtorria(null);
                ventana.setVisible(true);
            }
        });
    }

    public void dispose() {
        // Lógica para cerrar la ventana o limpiar recursos
    }
    
    public static boolean baieztatuAdmin(String erabiltzailea, String pasahitza) {
		boolean login_ok_admin = false;
		if ((erabiltzailea.equals(1234)) && (pasahitza.equals(1234))) {
			erabiltzailea = erabiltzailea;
		}
		return login_ok_admin;
	}

    public static void main(String[] args) {
        // Aquí puedes crear una instancia de Modelo y llamar al método para abrir vEtorria
        Modelo modelo = new Modelo();
        modelo.abrirvEtorria();
    }

 }