package master;

import javax.swing.SwingUtilities;
import vista.vLogin;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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


<<<<<<< HEAD
    public boolean irkeiLogin = false;
=======
	
	
	
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
>>>>>>> 9ee74e23f500cc999a4f6e26e7aa59ef7d0ae101

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
      // leioa ixteko
    }
    
    public boolean baieztatuAdmin(String erabiltzailea, String pasahitza) {
        boolean login_ok_admin = false;
        Connection conexioa = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            // Datu basearekin konexioa egiteko
            conexioa = konexioa.hasi();

            // Datu baseari kontsulta egin
            String query = "SELECT * FROM bezeroa WHERE Erabiltzailea = ? AND Pasahitza = ?";
            ps = conexioa.prepareStatement(query);
            ps.setString(1, erabiltzailea);
            ps.setString(2, pasahitza);

            // Hau, kontsulta exekutatzeko da
            rs = ps.executeQuery();

            // Berifikatu usuariorenbat dagoela Karakteristika hauekin
            login_ok_admin = rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
           
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conexioa != null) {
                    conexioa.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return login_ok_admin;
    }

    public static void main(String[] args) {
        Modelo modelo = new Modelo();
        modelo.abrirvEtorria();
    }
}