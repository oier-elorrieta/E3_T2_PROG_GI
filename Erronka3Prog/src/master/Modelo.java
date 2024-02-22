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
    public int azinema = 2;
    public int afilma = 0;
    public int asaioa = 0;
    public boolean irekiLogin = false;
    
    private boolean loginOk = false;
    
    private Bezero[] bezeroak;
    
    
    
    
    public Bezero[] getBezeroak() {
		return bezeroak;
	}
	public void setBezeroak(Bezero[] bezeroak) {
		this.bezeroak = bezeroak;
	}
	public boolean isLoginOk() {
		return loginOk;
	}
	public void setLoginOk(boolean loginOk) {
		this.loginOk = loginOk;
	}
	
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
		Zinema zinema = Zinemak[azinema];
		Saioa[] saioak = zinema.getSaioak();
		Filma filmak;
		for (int i = 0; i < saioak.length; i++) {
			filmak = saioak[i].getFilma();
			model.addRow(new Object[] { i, filmak.getIzena(), false});
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
        System.out.println(bezeroak.length);
        int pos = 0;
        boolean aurkituta = false;
        while (pos < bezeroak.length && aurkituta==false) {
        	System.out.println(bezeroak[pos].getErabiltzailea());
        	System.out.println(erabiltzailea);
        	if (bezeroak[pos].getErabiltzailea().equals(erabiltzailea)) {
                aurkituta = true;
        	}
        	pos++;
        }
       if (aurkituta) {
    	   pos--;
    	   System.out.println("Encuentra");
    	   if (bezeroak[pos].getPasahitza().equals(pasahitza)) {
    		   System.out.println("Barruan");
    		   login_ok_admin = true;
    	   }
       }    	   
        return login_ok_admin;
    }
    
    
}