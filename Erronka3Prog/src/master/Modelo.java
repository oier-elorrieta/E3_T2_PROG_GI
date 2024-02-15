package master;
import javax.swing.SwingUtilities;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import vista.vEtorria;

public class Modelo {
	Aretoa Aretoak[];
	Bezero Bezeroak[];
	Erosketa Erosketak[];
	Filma Filmak[];
	Saioa Saioak[];
	Sarrera Sarrerak[];
	Zinema Zinemak[];
	
	
    public boolean irkeiLogin = false;

    public Modelo() {
    }

    public void abrirVetrorria() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                vEtorria ventana = new vEtorria(null);
                ventana.setVisible(true);
            }
        });
    }

    public void dispose() {
        // Lógica para cerrar la ventana o limpiar recursos
    }

    public static void main(String[] args) {
        // Aquí puedes crear una instancia de Modelo y llamar al método para abrir vEtorria
        Modelo modelo = new Modelo();
        modelo.abrirVetrorria();
    }

 }