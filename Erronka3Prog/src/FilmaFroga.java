import java.sql.*;

public class FilmaFroga {
    public static void main(String[] args) {
        Connection conexion = null;
        Statement statement = null;
        ResultSet resultSet = null;
        
     
        konexioa konexioaObjeto = new konexioa();
        conexion = konexioaObjeto.hasi();

        try {
           
            statement = conexion.createStatement();

     
            String consulta = "SELECT * FROM FILMA";
            resultSet = statement.executeQuery(consulta);

          
            while (resultSet.next()) {
              
                int id = resultSet.getInt("Idfilma");
                String izenburua = resultSet.getString("Izenburua");
                int iraupena = resultSet.getInt("Iraupena");
                String generoa = resultSet.getString("Generoa");
                double prezioa = resultSet.getDouble("Prezioa");
                String zuzendaria = resultSet.getString("Zuzendaria");
                String sinopsia = resultSet.getString("Sinopsia");
                
                System.out.println("Idfilma: " + id);
                System.out.println("Izenburua: " + izenburua);
                System.out.println("Iraupena: " + iraupena);
                System.out.println("Generoa: " + generoa);
                System.out.println("Prezioa: " + prezioa);
                System.out.println("Zuzendaria: " + zuzendaria);
                System.out.println("Sinopsia: " + sinopsia);
                System.out.println("-----------------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cerrar los recursos (en orden inverso al que se abrieron)
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (conexion != null) conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
