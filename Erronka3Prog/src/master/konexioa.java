package master;
import java.sql.*;

public class konexioa {
    public static Connection hasi() {//Konexioa Datu Basearekin// 
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
    
    
    //CONEXIOFROGARENA
    public Zinema[] fullLoad(Connection conexioa) {
    	System.out.println("FUNCIONA");
		 Zinema[] zinemak = null;
		 try {
		        conexioa = konexioa.hasi();
		        // Prestatu sententzia
		        int i = 0;
		        int a = 0;
		        int s = 0;
		        Statement s1 = conexioa.createStatement();
		        String sql = "SELECT * FROM zinema";
		        ResultSet lerroak = s1.executeQuery(sql);
		        int count = 0;
		        while(lerroak.next()) {
		            count++;
		        }
		        zinemak = new Zinema[count];
		        lerroak = s1.executeQuery(sql);
		        while (lerroak.next()) {
		            Zinema zinema = new Zinema();
		            zinema.setId(lerroak.getInt("idzinema"));
		            zinema.setIzena(lerroak.getString("Izena"));
		            zinema.setHelbidea(lerroak.getString("Helbidea"));
		            zinema.setKontaktua(lerroak.getString("Kontaktua"));
		            zinema.setDeskribapena(lerroak.getString("Deskribapena"));
		            
		            //Aretoa kalkulatu
		            Aretoa[] Aretoak = null;
		            a = 0;
		            sql = "SELECT * FROM Aretoa WHERE idZinema = " + i;
		            while(s1.executeQuery(sql).next()) {
		            	a++;
		            }
		            Aretoak = new Aretoa[a];
		            a = 0;
		            while(s1.executeQuery(sql).next()) {
		            	Aretoa aretoa = new Aretoa(); 
			            aretoa.setId(lerroak.getInt("idAretoa"));
			            aretoa.setIzena(lerroak.getString("Izena"));
			            Aretoak[a] = aretoa;
			            a++;
		            }
		            zinema.setAretoak(Aretoak);
		            
		            //Saioak kalkulatu
		            Saioa[] Saioak = null;
		            s = 0;
		            sql = "SELECT * FROM Saioa WHERE idZinema = " + i + " order by s_data asc"; // Datarik baxuena lehen
		            while(s1.executeQuery(sql).next()) {
		            	s++;
		            }
		            Saioak = new Saioa[s];
		            s = 0;
		            /*
		    		private int id;
		    		private Date data;
		    		private Filma filma;
		    		private Aretoa areto;*/
		            
		            while(s1.executeQuery(sql).next()) {
		            	Saioa saioa = new Saioa();
		            	saioa.setId(s1.executeQuery(sql).getInt("IdSaioa"));
		            	saioa.setData(s1.executeQuery(sql).getDate("S_Data"));
		            	Filma filma = new Filma();
		            	sql = "SELECT f.* FROM Filma f inner join Saioa s using (idfilma) WHERE IdSaioa = "+ s +" and idZinema = " + i;
		            	filma.setId(s1.executeQuery(sql).getInt("idfilma"));
		            	filma.setIraupena(s1.executeQuery(sql).getInt("iraupena"));
		            	filma.setGeneroa(s1.executeQuery(sql).getString("generoa"));
		            	filma.setPrezioa(s1.executeQuery(sql).getDouble("Prezioa"));
		            	filma.setIzena(s1.executeQuery(sql).getString("izenburua"));
		            	filma.setZuzendaria(s1.executeQuery(sql).getString("Zuzendaria"));
		            	filma.setSinopsia(s1.executeQuery(sql).getString("Sinopsia"));
		            	
		            	saioa.setFilma(filma);
		            	Saioak[s] = saioa;
		            	s++;
		            }
		            zinema.setSaioak(Saioak);
		            zinemak[i] = zinema;
		            i++;
		        }
		    } catch (Exception sqe) {
		        sqe.printStackTrace();
		    }		
		 		
		 			
		 
		 return zinemak;
		 
		 
		 
	 }
     
}
