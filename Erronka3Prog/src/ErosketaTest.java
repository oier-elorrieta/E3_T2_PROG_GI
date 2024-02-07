import static org.junit.Assert.*;

import org.junit.Test;

public class ErosketaTest {

    @Test
    public void testEquals() {
        Bezero bezero1 = new Bezero("16110577c", "Jon", null);
        Bezero bezero2 = new Bezero("16110566a", "Unai", null);

        Erosketa erosketa1 = new Erosketa(1, 123, 10, 25.25, bezero1);
        Erosketa erosketa2 = new Erosketa(1, 123, 10, 25.25, bezero1);
        Erosketa erosketa3 = new Erosketa(2, 456, 20, 34.43, bezero2);

        assertTrue(erosketa1.equals(erosketa2));
        assertFalse(erosketa1.equals(erosketa3));
    }

    @Test
    public void testGettersAndSetters() {
        Erosketa erosketa = new Erosketa(1, 123, 10, 100.0, new Bezero("123ABC", "Jon", null));

        // Setters
        erosketa.setJatorria(456);
        erosketa.setDeskontua(20);
        erosketa.setPreziotot(200.0);
        erosketa.setBezero(new Bezero("456DEF", "Mikel", null));

        // Getters
        assertEquals(1, erosketa.getId());
        assertEquals(456, erosketa.getJatorria());
        assertEquals(20, erosketa.getDeskontua());
        assertEquals(200.0, erosketa.getPreziotot(), 0.001);
        assertEquals("456DEF", erosketa.getBezero().getNan());
    }

    @Test
    public void testHashCode() {
        Bezero bezero1 = new Bezero("123ABC", "Jon", null);
        Bezero bezero2 = new Bezero("456DEF", "Unai", null);

        Erosketa erosketa1 = new Erosketa(1, 123, 10, 100.0, bezero1);
        Erosketa erosketa2 = new Erosketa(1, 123, 10, 100.0, bezero1);
        Erosketa erosketa3 = new Erosketa(2, 456, 20, 200.0, bezero2);

        assertEquals(erosketa1.hashCode(), erosketa2.hashCode());
        assertNotEquals(erosketa1.hashCode(), erosketa3.hashCode());
    }
}
