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
	//
    Aretoa Aretoak[];
    Bezero Bezeroak[];
    Erosketa Erosketak[];
    Filma Filmak[];
    Saioa Saioak[];
    Sarrera Sarrerak[];
    //
    Zinema Zinemak[];
    public int azinema = 0;
    public int afilma = 0;
    public int asaioa = 0;
    
    public void zinemaproba() {
    	Aretoa aretoa2 = new Aretoa(1, "");
    	Aretoa[] aretoarray = new Aretoa[]{aretoa2};
        Saioa[] saio = new Saioa[1];

        Zinema zinema1 = new Zinema(23, "izena", "Helbidea", "kontaktua", "deskribapena", aretoarray, saio);
        Zinema zinema2 = new Zinema(23, "izena", "Helbidea", "kontaktua", "deskribapena", aretoarray, saio);
        Zinemak = new Zinemak[]{zinema1, zinema2};
        setZinemak(Zinemak);
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
		Filma[] Filmak = getFilmak();
		//Filma[] filmak = Zinemak[azinema].getFilmak();
		for (int i = 0; i < Filmak.length; i++) {
			model.addRow(new Object[] { i, Filmak[i].getIzena(), false});
		}
	}
    public  void Kontsulta() {
    	Date date1 = new Date();
        Date date2 = new Date();
       
        Bezero[] bezeroArray = new Bezero[2];
    
        Bezero bezero1 = new Bezero("12345678A", "Jon", "Jon69", "Pérez", date1, "jon@gmail.com", 'M', "1234");
        Bezero bezero2 = new Bezero("87654321B", "Ane", "Ane44", "González", date2, "ane@gmail.com", 'F', "4321");
        
        bezeroArray[0] = bezero1;
        bezeroArray[1] = bezero2;
        
        setBezeroak(bezeroArray);
        System.out.println(this.Bezeroak.length);
    }
    

    public boolean irekiLogin = false;
    
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