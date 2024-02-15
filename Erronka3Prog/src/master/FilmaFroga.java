package master;
import java.sql.*;

public class FilmaFroga {
	public static void main(String[] args) {
        Connection conexion = null;
        try {
            konexioa konexioaObjeto = new konexioa();
            conexion = konexioaObjeto.hasi();
            Filma filma = new Filma();
            filma.load(conexion);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Cerrar conexión
            try {
                if (conexion != null) {
                    conexion.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
