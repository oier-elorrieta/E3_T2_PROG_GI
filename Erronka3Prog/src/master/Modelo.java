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
    private Zinema Zinemak[];
    private int azinema = 0;
    private int afilma = 0;
    private int asaioa = 0;
    private Date adata;
    private boolean irekiLogin = false;
    private boolean loginOk = false;
    private Bezero[] bezeroak;
    
    public int getAzinema() {
		return azinema;
	}
	public void setAzinema(int azinema) {
		this.azinema = azinema;
	}
	public int getAfilma() {
		return afilma;
	}
	public void setAfilma(int afilma) {
		this.afilma = afilma;
	}
	public int getAsaioa() {
		return asaioa;
	}
	public void setAsaioa(int asaioa) {
		this.asaioa = asaioa;
	}
	public Date getAdata() {
		return adata;
	}
	public void setAdata(Date adata) {
		this.adata = adata;
	}
	public boolean isIrekiLogin() {
		return irekiLogin;
	}
	public void setIrekiLogin(boolean irekiLogin) {
		this.irekiLogin = irekiLogin;
	}
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
	
	public boolean egiaztatuDatuak(String erabiltzailea,String pasahitza) {
        
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

    public void ezarrisaioak(DefaultTableModel model) {
    	Zinema zinemak = Zinemak[azinema];
    	int cont = 0;
    	Saioa[] saioak = new Saioa[zinemak.getSaioak().length];
    	saioak = zinemak.getSaioak();
    	Saioa[] serabilgarri;
    	for (int i = 0; i < saioak.length; i++) {
    		if (adata.equals(saioak[i].getData())) {
    			cont++;
    		}
    	}

    	serabilgarri = new Saioa[cont];
    	for (int i = 0; i < saioak.length; i++) {
    		if (adata.equals(saioak[i].getData())) {
    			serabilgarri[i] = saioak[i];
    		}
    	}
    	Filma filma;
    	for (int i = 0; i < serabilgarri.length; i++) {
    		filma = serabilgarri[i].getFilma();
    		model.addRow(new Object[] { serabilgarri[i].getOrdua(), filma.getIzena(), false});
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
    
    public boolean baieztatuAdmin(String erabiltzailea, String pasahitza) {
        boolean login_ok_admin = false;
        // Arraya rekorritzen du, bigarren alea-tik zortzigarrenaraino
        int pos = 0;
        boolean aurkituta = false;
        while (pos < bezeroak.length && aurkituta==false) {
        	if (bezeroak[pos].getErabiltzailea().equals(erabiltzailea)) {
                aurkituta = true;
        	}
        	pos++;
        }
       if (aurkituta) {
    	   pos--;
    	   if (bezeroak[pos].getPasahitza().equals(pasahitza)) {
    		   login_ok_admin = true;
    	   }
       }    	   
        return login_ok_admin;
    }
    
    
}