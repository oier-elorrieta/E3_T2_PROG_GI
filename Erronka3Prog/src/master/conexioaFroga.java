package master;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
    public Zinema[] Zinemaload(Connection conexioa) {   //Zinemaren Datuak Kargatu//
        Zinema[] zinemak = null;  
        try {
            // Preparamos la consulta SQL para obtener los datos de los cines, salas y películas
            String sql = "SELECT z.*, a.*, s.*, f.* " +
                         "FROM ZINEMA z " +
                         "JOIN ARETOA a ON z.Idzinema = a.IdZinema " +
                         "JOIN SAIOA sa ON a.IdZinema = sa.IdZinema AND a.IdAretoa = sa.IdAretoa " +
                         "JOIN FILMA f ON sa.IdFilma = f.Idfilma";
            PreparedStatement pstmt = conexioa.prepareStatement(sql);
            
            // Ejecutamos la consulta
            ResultSet rs = pstmt.executeQuery();
            
            // Creamos un array para almacenar los cines
            zinemak = new Zinema[5]; // Suponemos que hay 5 cines en la base de datos
            
            // Recorremos los resultados de la consulta
            while (rs.next()) {
                // Obtenemos los datos del cine
                int idCine = rs.getInt("z.Idzinema");
                String nombreCine = rs.getString("z.Izena");
                String direccionCine = rs.getString("z.Kalea");
                String contactoCine = rs.getString("z.Kontaktua");
                String descripcionCine = rs.getString("z.Deskribapena");
                
                // Creamos un objeto Zinema para este cine
                Zinema zinema = new Zinema();
                zinema.setId(idCine);
                zinema.setIzena(nombreCine);
                zinema.setHelbidea(direccionCine);
                zinema.setKontaktua(contactoCine);
                zinema.setDeskribapena(descripcionCine);
                
                // Creamos un array para almacenar las salas de este cine
                Aretoa[] salak = new Aretoa[5]; // Suponemos que hay 5 salas en cada cine
                
                // Creamos una sala por cada iteración del bucle
                for (int i = 0; i < 5; i++) {
                    // Obtenemos los datos de la sala
                    int idSala = rs.getInt("a.IdAretoa");
                    String nombreSala = rs.getString("a.Izena");
                    
                    // Creamos un objeto Aretoa para esta sala y lo agregamos al array
                    Aretoa aretoa = new Aretoa();
                    aretoa.setId(idSala);
                    aretoa.setIzena(nombreSala);
                    
                    salak[i] = aretoa;
                    
                    // Pasamos al siguiente registro si hay más
                    if (!rs.next()) {
                        break;
                    }
                }
                
                // Agregamos las salas al cine
                zinema.setAretoak(salak);
                
                // Guardamos el cine en el array
                zinemak[idCine - 1] = zinema; // Restamos 1 porque los índices de array comienzan en 0
            }
            
            // Cerramos el PreparedStatement
            pstmt.close();
        } catch (Exception sqe) {
            sqe.printStackTrace();
        }
        
        return zinemak;
    }

   
}


