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

	
	public String zinemaIzena(int i) {
		Zinema zinema = Zinemak[i];
		return zinema.getIzena();
	}
	
	public String ezarriIzenak(int i) {
		Zinema zinema = Zinemak[azinema];
		Saioa[] saioak = zinema.getSaioak();
		Filma filmak;
		filmak = saioak[i].getFilma();
		return filmak.getIzena();
	}
	
	public int saioaklength() {
		Zinema zinema = Zinemak[azinema];
		Saioa[] saioak = zinema.getSaioak();
		return saioak.length;
	}

	public int saioakErabilgarrilength() {
		Zinema zinemak = Zinemak[azinema];
		int cont = 0;
		Saioa[] saioak = new Saioa[zinemak.getSaioak().length];
		saioak = zinemak.getSaioak();
		for (int j = 0; j < saioak.length; j++) {
			if (adata.equals(saioak[j].getData())) {
				cont++;
			}
		}
		return cont;
	}

	public String aukeraSaioOrdua(int i) {
		Zinema zinemak = Zinemak[azinema];
		Saioa[] saioak = new Saioa[zinemak.getSaioak().length];
		saioak = zinemak.getSaioak();
		Saioa[] serabilgarri;
		serabilgarri = new Saioa[saioakErabilgarrilength()];
		for (int j = 0; j < saioak.length; j++) {
			if (adata.equals(saioak[i].getData())) {
				serabilgarri[j] = saioak[j];
			}
		}
		return serabilgarri[i].getOrdua();
	}
	
	public String aukeraSaioFilma(int i) {
		Zinema zinemak = Zinemak[azinema];
		Saioa[] saioak = new Saioa[zinemak.getSaioak().length];
		saioak = zinemak.getSaioak();
		Saioa[] serabilgarri;
		serabilgarri = new Saioa[saioakErabilgarrilength()];
		for (int j = 0; j < saioak.length; j++) {
			if (adata.equals(saioak[i].getData())) {
				serabilgarri[j] = saioak[j];
			}
		}
		Filma filma;
		filma = serabilgarri[i].getFilma();
		return filma.getIzena();
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
		while (pos < bezeroak.length && aurkituta == false) {
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

	public boolean getIrekiLogin() {
		return this.irekiLogin;
	}

}