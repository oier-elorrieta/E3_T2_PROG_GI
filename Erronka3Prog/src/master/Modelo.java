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

	
	
	
    public Aretoa[] getAretoak() {
		return Aretoak;
	}

	public void setAretoak(Aretoa[] aretoak) {
		Aretoak = aretoak;
	}

	public Bezero[] getBezeroak() {
		return Bezeroak;
	}

	public void setBezeroak(Bezero[] bezeroak) {
		Bezeroak = bezeroak;
	}

	public Erosketa[] getErosketak() {
		return Erosketak;
	}

	public void setErosketak(Erosketa[] erosketak) {
		Erosketak = erosketak;
	}

	public Filma[] getFilmak() {
		return Filmak;
	}

	public void setFilmak(Filma[] filmak) {
		Filmak = filmak;
	}

	public Saioa[] getSaioak() {
		return Saioak;
	}

	public void setSaioak(Saioa[] saioak) {
		Saioak = saioak;
	}

	public Sarrera[] getSarrerak() {
		return Sarrerak;
	}

	public void setSarrerak(Sarrera[] sarrerak) {
		Sarrerak = sarrerak;
	}

	public Zinema[] getZinemak() {
		return Zinemak;
	}

	public void setZinemak(Zinema[] zinemak) {
		Zinemak = zinemak;
	}

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