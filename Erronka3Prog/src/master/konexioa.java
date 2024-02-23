package master;
import java.sql.*;

public class konexioa {
    public static Connection hasi() {//Konexioa Datu Basearekin// 
        Connection conexioa = null;
        try {
            conexioa = DriverManager.getConnection("jdbc:mysql://localhost:3307/db_e3zinema", "root", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conexioa;
    }
    
    public void itxi(Connection conexioa) {
        try {
            if (conexioa != null && !conexioa.isClosed()) {
                conexioa.close();
            }
        } catch (SQLException e) { 
            e.printStackTrace();
        }
    }
    
    //CONEXIOFROGARENA
    public void fullLoad(Connection conexioa, Modelo mDatuak) {
        Zinema[] zinemak = null;
        try {
            int i = 0;
            Statement s1 = conexioa.createStatement();
            String sql = "SELECT * FROM zinema where Idzinema < 6";
            try (ResultSet lerroak = s1.executeQuery(sql)) {
                int count = 0;
                while(lerroak.next()) {
                    count++;
                }
                zinemak = new Zinema[count];
            }
            
            try (ResultSet lerroak = s1.executeQuery(sql)) {
                while (lerroak.next()) {
                    Zinema zinema = new Zinema();
                    zinema.setId(lerroak.getInt("idzinema"));
                    zinema.setIzena(lerroak.getString("Izena"));
                    zinema.setHelbidea(lerroak.getString("Herria"));
                    zinema.setKontaktua(lerroak.getString("Kontaktua"));
                    zinema.setDeskribapena(lerroak.getString("Deskribapena"));
                    zinemak[i] = zinema;
                    i++;
                }
            }
            for (int j = 0; j < zinemak.length; j++) {
            	zinemak[j].setAretoak(areotoload(zinemak[j].getId(), conexioa));
                zinemak[j].setSaioak(saioaload(zinemak[j].getId(), conexioa));
            }
            
        } catch (Exception sqe) {
            sqe.printStackTrace();
        } finally {
            itxi(conexioa);
        }
        mDatuak.setZinemak(zinemak);
    }
    
    private Aretoa[] areotoload(int id, Connection conexioa) {
    	Aretoa[] Aretoak = null;
        try {
            try (Statement s1 = conexioa.createStatement()) {
                String sql = "SELECT * FROM Aretoa WHERE idZinema = " + id;
                try (ResultSet lerroak = s1.executeQuery(sql)) {
                    int a = 0;
                    while(lerroak.next()) {
                        a++;
                    }
                    Aretoak = new Aretoa[a];
                }
                
                try (ResultSet lerroak = s1.executeQuery(sql)) {
                    int a = 0;
                    while(lerroak.next()) {
                        Aretoa aretoa = new Aretoa(); 
                        aretoa.setId(lerroak.getInt("idAretoa"));
                        aretoa.setIzena(lerroak.getString("Izena"));
                        Aretoak[a] = aretoa;
                        a++;
                    }
                }
            }
        } catch (Exception sqe) {
            sqe.printStackTrace();
        }
        return Aretoak;
    }
    
    private Saioa[] saioaload(int id, Connection conexioa) {
        Saioa[] Saioak = null;
        try {
            try (Statement s1 = conexioa.createStatement()) {
                String sql = "SELECT * FROM Saioa WHERE idZinema = " + id + " order by s_data asc";
                try (ResultSet lerroak = s1.executeQuery(sql)) {
                    int s = 0;
                    while(lerroak.next()) {
                        s++;
                    }
                    Saioak = new Saioa[s];
                }
                
                try (ResultSet lerroak = s1.executeQuery(sql)) {
                    int s = 0;
                    while(lerroak.next()) {
                        Saioa saioa = new Saioa();
                        saioa.setId(lerroak.getInt("IdSaioa"));
                        saioa.setOrdua(lerroak.getString("Ordu_Data"));
                        saioa.setData(lerroak.getDate("S_Data"));
                        Filma filma = filmaload((s + 1), id, conexioa);
                        saioa.setFilma(filma);
                        Saioak[s] = saioa;
                        s++;
                    }
                }
            }
        } catch (Exception sqe) {
            sqe.printStackTrace();
        }
        return Saioak;
    }
    
    private Filma filmaload(int s, int id, Connection conexioa) {
        Filma filma = null;
        try {
            try (Statement s1 = conexioa.createStatement()) {
            	String sql = "SELECT f.* FROM Filma f inner join Saioa s using (idfilma) WHERE IdAretoa = "+ s +" and idZinema = " + id;
                try (ResultSet lerroak = s1.executeQuery(sql)) {
                    filma = new Filma();
                    if (lerroak.next()) {
                        filma.setId(lerroak.getInt("idfilma"));
                        filma.setIraupena(lerroak.getInt("iraupena"));
                        filma.setGeneroa(lerroak.getString("generoa"));
                        filma.setPrezioa(lerroak.getDouble("Prezioa"));
                        filma.setIzena(lerroak.getString("izenburua"));
                        filma.setZuzendaria(lerroak.getString("Zuzendaria"));
                        filma.setSinopsia(lerroak.getString("Sinopsia"));
                    }
                }
            }
        } catch (Exception sqe) {
            sqe.printStackTrace();
        }
        return filma;
    }
    
    public void bezeroLoad(Connection conexioa, Modelo mDatuak) { 

		 Bezero[] bezeroak = null;;
		 try {
	    	   conexioa = konexioa.hasi();
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
		 mDatuak.setBezeroak(bezeroak);
	      
	}
}
