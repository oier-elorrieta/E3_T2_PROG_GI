
import static org.junit.Assert.*;

import org.junit.Test;

public class BezeroTest {

	@Test
    public void testEquals() {
        Bezero bezero1 = new Bezero("12345678A", "Juan", 19900101, "juan@gmail.com", "pasahitz123", "juan123");
        Bezero bezero2 = new Bezero("12345678A", "Juan", 19900101, "juan@gmail.com", "pasahitz123", "juan123");
        Bezero bezero3 = new Bezero("98765432B", "Maria", 19901231, "maria@gmail.com", "pasahitz456", "maria456");

        assertTrue(bezero1.equals(bezero2));
        assertFalse(bezero1.equals(bezero3));
    }
	
	@Test
    public void testGettersAndSetters() {
        Bezero bezero = new Bezero("12345678A", "Juan", 19900101, "juan@gmail.com", "pasahitz123", "juan123");

        // Setterrak frogatu
        bezero.setNan("87654321B");
        bezero.setIzena("Maria");
        bezero.setJ_data(19901231);
        bezero.setMail("maria@gmail.com");

        // Getterren frogak
        assertEquals("87654321B", bezero.getNan());
        assertEquals("Maria", bezero.getIzena());
        assertEquals(19901231, bezero.getJ_data());
        assertEquals("maria@gmail.com", bezero.getMail());
        assertEquals("maria456", bezero.getErabiltzailea());
    }
	
}


