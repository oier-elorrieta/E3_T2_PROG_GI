
import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

public class BezeroTest {

	@Test
    public void testEquals() {
		Date d2 = new Date(2000, 11, 21);
		Date d1 = new Date();
		Bezero bezero1 = new Bezero("12345678A", "Juan","juan", "Deavila", d1, "juan@gmail.com", 'G',"pasahitz123");
		Bezero bezero2 = new Bezero("12345678A", "Juan","juan", "Deavila", d1, "juan@gmail.com", 'G',"pasahitz123");
        Bezero bezero3 = new Bezero("98765432B", "Maria","maria", "Demario", d2, "maria@gmail.com", 'O',"pasahitz456");

        assertTrue(bezero1.equals(bezero2));
        assertFalse(bezero1.equals(bezero3));
    }
	
	@Test
    public void testGettersAndSetters() {
		Date d1 = new Date();
        Bezero bezero = new Bezero("98765432B", "Maria","maria", "Demario", d1, "maria@gmail.com", 'O',"pasahitz456");
        
        // Setterrak frogatu
        bezero.setNan("87654321B");
        bezero.setIzena("Maria");
        bezero.setJ_data(d1);
        bezero.setMail("maria@gmail.com");

        // Getterren frogak
        assertEquals("87654321B", bezero.getNan());
        assertEquals("Maria", bezero.getIzena());
        assertEquals(d1, bezero.getJ_data());
        assertEquals("maria@gmail.com", bezero.getMail());
        assertEquals('O', bezero.getSexua());
    }
	
}


