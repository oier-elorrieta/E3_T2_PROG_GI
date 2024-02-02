import static org.junit.Assert.*;
import org.junit.Test;

public class AretoaTest {

    @Test
    public void testEqualsAndHashCode() {
        Aretoa aretoa1 = new Aretoa(1, 101, 201);
        Aretoa aretoa2 = new Aretoa(1, 101, 201);
        Aretoa aretoa3 = new Aretoa(2, 102, 202);

        // Test equals method
        assertTrue(aretoa1.equals(aretoa2));
        assertFalse(aretoa1.equals(aretoa3));

        // Test hashCode method
        assertEquals(aretoa1.hashCode(), aretoa2.hashCode());
        assertNotEquals(aretoa1.hashCode(), aretoa3.hashCode());
    }

    @Test
    public void testToString() {
        Aretoa aretoa = new Aretoa(3, 103, 203);
        String expected = "Aretoa [izena=3, id=103, zinema=203]";
        assertEquals(expected, aretoa.toString());
    }

    @Test
    public void testGettersAndSetters() {
        Aretoa aretoa = new Aretoa();

        aretoa.setIzena(4);
        assertEquals(4, aretoa.getIzena());

        aretoa.setId(104);
        assertEquals(104, aretoa.getId());

        aretoa.setZinema(204);
        assertEquals(204, aretoa.getZinema());
    }
}


