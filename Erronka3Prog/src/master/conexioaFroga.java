package master;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class conexioaFroga {
	public static void main(String[] args) {
		Connection conexioa = null; // Debes inicializar la conexión
		conexioa = konexioa.hasi();
		System.out.println("Konektatuta");

		// Cargar cines
		conexioaFroga froga = new conexioaFroga();
		Zinema[] cines = froga.Zinemaload(conexioa);

		// Imprimir los resultados para verificar si se han cargado correctamente
		for (Zinema cine : cines) {
			if (cine != null) {
				System.out.println("Cine ID: " + cine.getId());
				System.out.println("Nombre del cine: " + cine.getIzena());
				Aretoa[] salas = cine.getAretoak();
				if (salas != null) {
					for (Aretoa sala : salas) {
						System.out.println("  Sala ID: " + sala.getId());
						System.out.println("  Nombre de la sala: " + sala.getIzena());
					}
				}
				System.out.println("----------------------------------");
			}
		}
	}

	public Zinema[] fullLoad(Connection conexioa) {
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
		            	saioa.setFilma(filma);
		            	
		            	Saioak[s] = saioa;
		            	s++;
		            }
		            zinemak[i] = zinema;
		            i++;
		        }
		    } catch (Exception sqe) {
		        sqe.printStackTrace();
		    }
		 
		 return zinemak;
	 }
	/*
	 * public Zinema[] Zinemaload(Connection conexioa) { //Zinemaren Datuak
	 * Kargatu// Zinema[] zinemak = null; try { // Preparamos la consulta SQL para
	 * obtener los datos de los cines, salas y películas String sql =
	 * "SELECT z.*, a.*, s.*, f.* " + "FROM ZINEMA z " +
	 * "JOIN ARETOA a ON z.Idzinema = a.IdZinema " +
	 * "JOIN SAIOA s ON a.IdZinema = s.IdZinema AND a.IdAretoa = s.IdAretoa " +
	 * "JOIN FILMA f ON s.IdFilma = f.Idfilma"; PreparedStatement pstmt =
	 * conexioa.prepareStatement(sql);
	 * 
	 * // Ejecutamos la consulta ResultSet rs = pstmt.executeQuery();
	 * 
	 * // Creamos un array para almacenar los cines zinemak = new Zinema[5]; //
	 * Suponemos que hay 5 cines en la base de datos
	 * 
	 * // Recorremos los resultados de la consulta while (rs.next()) { // Obtenemos
	 * los datos del cine int idCine = rs.getInt("z.Idzinema"); String nombreCine =
	 * rs.getString("z.Izena"); String direccionCine = rs.getString("z.Kalea");
	 * String contactoCine = rs.getString("z.Kontaktua"); String descripcionCine =
	 * rs.getString("z.Deskribapena");
	 * 
	 * // Creamos un objeto Zinema para este cine Zinema zinema = new Zinema();
	 * zinema.setId(idCine); zinema.setIzena(nombreCine);
	 * zinema.setHelbidea(direccionCine); zinema.setKontaktua(contactoCine);
	 * zinema.setDeskribapena(descripcionCine);
	 * 
	 * // Creamos un array para almacenar las salas de este cine Aretoa[] salak =
	 * new Aretoa[5]; // Suponemos que hay 5 salas en cada cine
	 * 
	 * // Creamos una sala por cada iteración del bucle for (int i = 0; i < 5; i++)
	 * { // Obtenemos los datos de la sala int idSala = rs.getInt("a.IdAretoa");
	 * String nombreSala = rs.getString("a.Izena");
	 * 
	 * // Creamos un objeto Aretoa para esta sala y lo agregamos al array Aretoa
	 * aretoa = new Aretoa(); aretoa.setId(idSala); aretoa.setIzena(nombreSala);
	 * 
	 * salak[i] = aretoa;
	 * 
	 * // Pasamos al siguiente registro si hay más if (!rs.next()) { break; } }
	 * 
	 * // Agregamos las salas al cine zinema.setAretoak(salak);
	 * 
	 * // Guardamos el cine en el array zinemak[idCine - 1] = zinema; // Restamos 1
	 * porque los índices de array comienzan en 0 }
	 * 
	 * // Cerramos el PreparedStatement pstmt.close(); } catch (Exception sqe) {
	 * sqe.printStackTrace(); }
	 * 
	 * return zinemak; }
	 */

}
