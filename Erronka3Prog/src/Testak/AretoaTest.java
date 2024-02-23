package Testak;
import static org.junit.Assert.*;
import org.junit.Test;

import master.Aretoa;

public class AretoaTest {

    @Test
    public void testEqualsAndHashCode() {
        Aretoa aretoa1 = new Aretoa(1, "Yelmo");
        Aretoa aretoa2 = new Aretoa(1, "Yelmo");
        Aretoa aretoa3 = new Aretoa(2, "Cinesa");

        // Test equals method 
        assertTrue(aretoa1.equals(aretoa2));
        assertFalse(aretoa1.equals(aretoa3));

        // Test hashCode method
        assertEquals(aretoa1.hashCode(), aretoa2.hashCode());
        assertNotEquals(aretoa1.hashCode(), aretoa3.hashCode());
    }

    @Test
    public void testToString() {
        Aretoa aretoa = new Aretoa(3, "Zubiarte");
        String expected = "Aretoa [id=3, izena=Zubiarte, zinema=]";
        assertEquals(expected, aretoa.toString());
    }

    @Test
    public void testGettersAndSetters() {
        Aretoa aretoa = new Aretoa(0, "");
        
        aretoa.setId(104);
        assertEquals(104, aretoa.getId());

        aretoa.setIzena("New Name");
        assertEquals("New Name", aretoa.getIzena());
    }
}