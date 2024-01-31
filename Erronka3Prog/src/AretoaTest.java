import static org.junit.Assert.*;

import org.junit.Test;

public class AretoaTest {

	

    @Test
    public void testEquals() {
        Aretoa aretoa1 = new Aretoa(1, 123, 20220130, 1200, "Filmak");
        Aretoa aretoa2 = new Aretoa(1, 123, 20220130, 1200, "Filmak");
        Aretoa aretoa3 = new Aretoa(2, 456, 20220130, 1400, "Beste filmak");

        assertTrue(aretoa1.equals(aretoa2));
        assertFalse(aretoa1.equals(aretoa3));
    }
    
    @Test
    public void testGettersAndSetters() {
        Bezero bezero = new Bezero("12345678A", "Juan", 19900101, "juan@gmail.com", "pasahitza123", "juan123");

        // Setter froga
        bezero.setNan("87654321B");
        bezero.setIzena("Maria");
        bezero.setJ_data(19901231);
        bezero.setMail("maria@gmail.com");


        // Getters froga
        assertEquals("87654321B", bezero.getNan());
        assertEquals("Maria", bezero.getIzena());
        assertEquals(19901231, bezero.getJ_data());
        assertEquals("maria@gmail.com", bezero.getMail());
        assertEquals("maria456", bezero.getErabiltzailea());
    }
<<<<<<< HEAD
    
}

=======
}
>>>>>>> 0cb6962a20965ce7c3a9ec6eeeab7f2bc9d829df
