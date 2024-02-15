package master;
import java.sql.*;

public class konexioa {
    public Connection hasi() {//Konexioa Datu Basearekin// 
        Connection conexioa = null;
        try {
            conexioa = DriverManager.getConnection("jdbc:mysql://localhost:3307/db_zinema", "root", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conexioa;
    }
    
    public void itxi(Connection conexioa) {
        try {
            conexioa.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void fullLoad(Modelo modelo, Connection conexioa) {
        konexioa k1= new konexioa();
        modelo.setAretoak(k1.Aretoload(conexioa));
    	modelo.setBezeroak(k1.Bezeroload(conexioa));
    	modelo.setErosketak(k1.Erosketaload(conexioa));
    	modelo.setFilmak(k1.Filmaload(conexioa));
    	modelo.setSaioak(k1.Saioaload(conexioa));
    	modelo.setSarrerak(k1.Sarreraload(conexioa));
    	modelo.setZinemak(k1.Zinemaload(conexioa));
    }
    
    
    public Aretoa[] Aretoload(Connection conexioa) { //Aretoaren Datuak Kargatu//  
        Aretoa[] aretoak = null;  
        try {
              conexioa = konexioa.hasi();
              System.out.println("Konektatuta");
              // Prestatu sententzia
              int i = 0;
              Statement s1 = conexioa.createStatement();
              String sql = "select * from aretoa";
              ResultSet lerroak = s1.executeQuery(sql);
              int count = 0;
              while(lerroak.next()) {
            	  count++;
              
              }
              aretoak = new Aretoa[count];
              lerroak = s1.executeQuery(sql);
              while (lerroak.next()) {
                  Aretoa aretoa = new Aretoa();
                  aretoa.setId(lerroak.getInt("id"));
                  aretoa.setIzena(lerroak.getString("izena"));
                  
                  aretoak[i] = aretoa;
                  i++;
              
              }
          } catch (Exception sqe) {
              sqe.printStackTrace();
          }

          return (aretoak);
   }
    
    public Bezero[] Bezeroload(Connection conexioa) { //Bezeroaren Datuak Kargatu//
		 
		 Bezero[] bezeroak = null;;
		 try {
	    	   conexioa = konexioa.hasi();
	           System.out.println("Konektatuta");
	           // Prestatu sententzia
	           int i = 0;
	           Statement s1 = conexioa.createStatement();
	           String sql = "select * from bezeroa";
	           ResultSet lerroak = s1.executeQuery(sql);
	           int count = 0;
	           while (lerroak.next()) {
	        	   count++;
	           }
	           bezeroak =  new Bezero[count];
	           lerroak = s1.executeQuery(sql);
	           while (lerroak.next()) {
	        	   System.out.println("a");
	        	   Bezero bezeroa = new Bezero();
	               bezeroa.setNan(lerroak.getString("NAN"));
	               bezeroa.setErabiltzailea(lerroak.getString("Erabiltzailea"));
	               bezeroa.setIzena(lerroak.getString("Izena"));
	               bezeroa.setAbizena(lerroak.getString("Abizena"));
	               bezeroa.setJ_data(lerroak.getDate("J_data"));
	               bezeroa.setMail(lerroak.getString("Mail"));
	               bezeroa.setSexua(lerroak.getString("Generoa").charAt(0));
	               bezeroa.setPasahitza(lerroak.getString("Pasahitza"));
	               bezeroak[i] = bezeroa;
	               i++;
	           }
	       } catch (Exception sqe) {
	           sqe.printStackTrace();
	       }
	       return (bezeroak);
	}
    
    public Filma[] Filmaload(Connection conexioa) {  //Filmen Datuak Kargatu//
        Filma[] filmak = null;
        try {
            System.out.println("Konektatuta");
            // Preparar sentencia
            Statement s1 = conexioa.createStatement();
            String sql = "select * from filma";
            ResultSet lerroak = s1.executeQuery(sql);
            int count = 0;
            while (lerroak.next()) {
                count++;
            }
            filmak = new Filma[count];
            lerroak = s1.executeQuery(sql);
            int i = 0;
            while (lerroak.next()) {
                Filma filma = new Filma();
                filma.setId(lerroak.getInt("Idfilma"));
                filma.setIzena(lerroak.getString("Izenburua"));
                filma.setIraupena(lerroak.getInt("Iraupena"));
                filma.setGeneroa(lerroak.getString("Generoa"));
                filma.setPrezioa(lerroak.getDouble("Prezioa"));
                filma.setZuzendaria(lerroak.getString("Zuzendaria"));
                filma.setSinopsia(lerroak.getString("Sinopsia"));
                filmak[i] = filma;
                i++;
            }
        } catch (Exception sqe) {
            sqe.printStackTrace();
        }
        for (int j = 0; j < filmak.length; j++) {
            System.out.println(filmak[j].toString());
        }
        return filmak;
    }
    
    public Saioa[] Saioaload(Connection conexioa) {   //Saioen Datuak Kargatu//
	    Saioa[] saioak = null;  
	    try {
	        conexioa = konexioa.hasi();
	        System.out.println("Konektatuta");
	        // Prestatu sententzia
	        int i = 0;
	        Statement s1 = conexioa.createStatement();
	        String sql = "select * from saioa";
	        ResultSet lerroak = s1.executeQuery(sql);
	        int count = 0;
	        while(lerroak.next()) {
	            count++;
	        }
	        saioak = new Saioa[count];
	        lerroak = s1.executeQuery(sql);
	        while (lerroak.next()) {
	            Saioa saioa = new Saioa();
	            saioa.setId(lerroak.getInt("id"));
	            saioa.setData(lerroak.getDate("data"));
	            
	            // Obtener los datos de la película y la sala
	            Filma filma = new Filma(); // Debes crear una instancia de Filma aquí
	            filma.setId(lerroak.getInt("id_pelicula")); // Suponiendo que el ID de la película está en una columna llamada id_pelicula
	            saioa.setFilma(filma);
	            
	            Aretoa aretoa = new Aretoa(); // Debes crear una instancia de Aretoa aquí
	            aretoa.setId(lerroak.getInt("id_aretoa")); // Suponiendo que el ID de la sala está en una columna llamada id_aretoa
	            saioa.setAreto(aretoa);
	            
	            saioak[i] = saioa;
	            i++;
	        }
	    } catch (Exception sqe) {
	        sqe.printStackTrace();
	    }
	    
	    
	    return saioak;
	}
    
    public Sarrera[] Sarreraload(Connection conexioa) {  //Sarreren Datuak Kargatu// 
	    Sarrera[] sarrerak = null;  
	    try {
	        conexioa = konexioa.hasi();
	        System.out.println("Konektatuta");
	        // Prestatu sententzia
	        int i = 0;
	        Statement s1 = conexioa.createStatement();
	        String sql = "select * from sarrera";
	        ResultSet lerroak = s1.executeQuery(sql);
	        int count = 0;
	        while(lerroak.next()) {
	            count++;
	        }
	        sarrerak = new Sarrera[count];
	        lerroak = s1.executeQuery(sql);
	        while (lerroak.next()) {
	            Sarrera sarrera = new Sarrera();
	            sarrera.setId(lerroak.getInt("id"));
	            Saioa saioa = new Saioa(); 
	            saioa.setId(lerroak.getInt("IdSaioa")); 
	            sarrera.setSaioa(saioa);
	            
	            sarrera.setPrezioa(lerroak.getFloat("Prezioa"));
	            sarrera.setKantitatea(lerroak.getInt("Prezioa"));
	            sarrerak[i] = sarrera;
	            i++;
	        }
	    } catch (Exception sqe) {
	        sqe.printStackTrace();
	    }
	    
	    return sarrerak;
	}
    
    public Zinema[] Zinemaload(Connection conexioa) {   //Zinemaren Datuak Kargatu//
	    Zinema[] zinemak = null;  
	    try {
	        conexioa = konexioa.hasi();
	        System.out.println("Konektatuta");
	        // Prestatu sententzia
	        int i = 0;
	        Statement s1 = conexioa.createStatement();
	        String sql = "select * from zinema";
	        ResultSet lerroak = s1.executeQuery(sql);
	        int count = 0;
	        while(lerroak.next()) {
	            count++;
	        }
	        zinemak = new Zinema[count];
	        lerroak = s1.executeQuery(sql);
	        while (lerroak.next()) {
	            Zinema zinema = new Zinema();
	            zinema.setId(lerroak.getInt("id"));
	            zinema.setIzena(lerroak.getString("Izena"));
	            zinema.setHelbidea(lerroak.getString("Helbidea"));
	            zinema.setKontaktua(lerroak.getString("Kontaktua"));
	            zinema.setDeskribapena(lerroak.getString("Deskribapena"));
	            
	            Aretoa aretoa = new Aretoa(); 
	            aretoa.setId(lerroak.getInt("id_aretoa")); 
	            zinema.setAretoak(new Aretoa[] {aretoa}); 
	            
	            Saioa saioa = new Saioa(); 
	            saioa.setId(lerroak.getInt("IdSaioa")); 
	            zinema.setSaioak(new Saioa[] {saioa}); 
	  
	            zinemak[i] = zinema;
	            i++;
	        }
	    } catch (Exception sqe) {
	        sqe.printStackTrace();
	    }
	    
	    return zinemak;
	}
    
    public Erosketa[] Erosketaload(Connection conexioa) { //Erosketaren Datuak Kargatu//  
	    Erosketa[] erosketak = null;  
	    try {
	        conexioa = konexioa.hasi();
	        System.out.println("Konektatuta");
	        // Prestatu sententzia
	        int i = 0;
	        Statement s1 = conexioa.createStatement();
	        String sql = "select * from zinema";
	        ResultSet lerroak = s1.executeQuery(sql);
	        int count = 0;
	        while(lerroak.next()) {
	            count++;
	        }
	        erosketak = new Erosketa[count];
	        lerroak = s1.executeQuery(sql);
	        while (lerroak.next()) {
	            Erosketa erosketa = new Erosketa();
	            erosketa.setId(lerroak.getInt("id"));
	            erosketa.setJatorria(lerroak.getInt("Jatorria"));
	            erosketa.setDeskontua(lerroak.getInt("Deskontua"));
	            erosketa.setData(lerroak.getDate("Data"));
	            erosketa.setPreziotot(lerroak.getDouble("PrezioTot"));
	            Bezero bezero = new Bezero();
	            erosketa.setId(lerroak.getInt("NAN"));
	            erosketa.setBezero(bezero);  
	            
	            Sarrera sarrera= new Sarrera(); 
	            sarrera.setId(lerroak.getInt("IdSarrera")); 
	            erosketa.setSarrera(new Sarrera[] {sarrera}); 
	            
	            erosketak[i] = erosketa;
	            i++;
	        }
	    } catch (Exception sqe) {
	        sqe.printStackTrace();
	    }
	    
	    return erosketak;
	}
     
}
