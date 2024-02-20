package master;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import vista.vLogin;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import vista.vEtorria;

public class Modelo {
    Zinema Zinemak[];
    public int azinema = 0;
    public int afilma = 0;
    public int asaioa = 0;
    public boolean irekiLogin = false;
    
    
    public boolean egiaztatuDatuak(JTextField lblErabiltzailea,JTextField  lblPasahitza) {
        // Erabiltzaile eta pasahitza lortu
        String erabiltzailea = lblErabiltzailea.getText();
        String pasahitza = lblPasahitza.getText();
        
        // Metodora deitu erabiltzailea eta pasahitza berifikatzeko
        boolean datuakBerif = baieztatuAdmin(erabiltzailea, pasahitza);
        
        return datuakBerif;
    }
    public void ezarrizinemak(DefaultTableModel model) {
		Zinema[] Zinemak = getZinemak();
		for (int i = 0; i < Zinemak.length; i++) {
			model.addRow(new Object[] { i, Zinemak[i].getIzena(), false});
		}
	}
    public void ezarrifilmak(DefaultTableModel model) {
		Filma[] Filmak = getFilmak();
		//Filma[] filmak = Zinemak[azinema].getFilmak();
		for (int i = 0; i < Filmak.length; i++) {
			model.addRow(new Object[] { i, Filmak[i].getIzena(), false});
		}
	}

    

    

	public Zinema[] getZinemak() {
		return Zinemak;
	}

	public void setZinemak(Zinema[] zinemak) {
		Zinemak = zinemak;
	}

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
        // Arraya rekorritzen du, bigarren alea-tik zortzigarrenaraino
        System.out.println(Bezeroak.length);
        int pos = 0;
        boolean aurkituta = false;
        while (pos<Bezeroak.length && aurkituta==false) {
        	System.out.println(Bezeroak[pos].getErabiltzailea());
        	System.out.println(erabiltzailea);
        	if (Bezeroak[pos].getErabiltzailea().equals(erabiltzailea)) {
                aurkituta = true;
        	}
        	pos++;
        }
       if (aurkituta) {
    	   pos--;
    	   System.out.println("Encuentra");
    	   if (Bezeroak[pos].getPasahitza().equals(pasahitza)) {
    		   System.out.println("Barruan");
    		   login_ok_admin = true;
    	   }
       }    	   
        return login_ok_admin;
    }
}