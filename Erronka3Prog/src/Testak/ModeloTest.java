package Testak;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import master.Bezero;
import master.Modelo;
import master.Zinema;
import master.Saioa;
import java.util.Date;

public class ModeloTest {

    private Modelo modelo;

    @Before
    public void setUp() {
        modelo = new Modelo();
    }

    @Test
    public void testEgiaztatuDatuak() {
       
        // Datuak sortu
        String erabiltzailea = "erabiltzailea";
        String pasahitza = "pasahitza";

        // Metodoa deitu eta emaitza egiaztatu
        assertFalse(modelo.egiaztatuDatuak(null, null)); // Dena hutsik dagoenean
        assertFalse(modelo.egiaztatuDatuak(null, pasahitza)); // Erabiltzaile eremua hutsik denean
        assertFalse(modelo.egiaztatuDatuak(erabiltzailea, null)); // Pasahitz eremua hutsik denean
        assertFalse(modelo.egiaztatuDatuak(erabiltzailea, pasahitza)); // Bi eremuak hutsik daudenean
        assertFalse(modelo.egiaztatuDatuak(erabiltzailea, null)); // Erabiltzaile eremua beteta denean
        assertFalse(modelo.egiaztatuDatuak(null, pasahitza)); // Pasahitz eremua beteta denean
        assertTrue(modelo.egiaztatuDatuak(erabiltzailea, pasahitza)); // Bi eremuak beteta daudenean
    }

    @Test
    public void testAbrirvEtorria() {
        // Metodoa exekutatzen den konprobatu eta erroreak ez ematea ziurtatu
        modelo.abrirvEtorria();
    }

    @Test
    public void testBaieztatuAdmin() {
        // Array para almacenar instancias de la clase Bezero
        Bezero[] bezeroak = new Bezero[1];
        Date d1 = new Date();
        
        // Crear instancias de Bezero y asignarlas al array
        Bezero bezero1 = new Bezero("12345678A", "Juan","erabiltzailea", "Deavila", d1, "juan@gmail.com", 'G',"pasahitza");

        // Establecer el array de bezeroak en el modelo
        Modelo modelo = new Modelo();
        modelo.setBezeroak(bezeroak);

        // Llamar al método y verificar los resultados
        assertTrue(modelo.baieztatuAdmin("erabiltzailea", "pasahitza")); // Cuando las credenciales son correctas
        assertFalse(modelo.baieztatuAdmin("erabiltzailea", "txarto")); // Cuando la contraseña es incorrecta
        assertFalse(modelo.baieztatuAdmin("txarto", "pasahitza")); // Cuando el nombre de usuario es incorrecto
        assertFalse(modelo.baieztatuAdmin(null, null)); // Cuando se proporcionan credenciales nulas
    }
    
    
    
    
		// JTextField klasea proba klasea, EZ KENDU, BEZTELA  testEgiaztatuDatuak() EZ DU FUNTZIONATZEN
		class JTextField extends javax.swing.JTextField {
				JTextField() {
					super();
				}

				JTextField(String text) {
					super(text);
				}
		}

		// Bezero klasea simulatzeko proba klasea
		class Bezero {
			private String erabiltzailea;
			private String pasahitza;

			Bezero(String erabiltzailea, String pasahitza) {
				this.erabiltzailea = erabiltzailea;
				this.pasahitza = pasahitza;
			}

				public String getErabiltzailea() {
				return erabiltzailea;
				}

				public String getPasahitza() {
					return pasahitza;
    }
}
}
