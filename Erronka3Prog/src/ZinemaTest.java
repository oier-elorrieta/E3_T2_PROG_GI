import static org.junit.Assert.*;
import org.junit.Test;

public class ZinemaTest {

    @Test
    public void testEqualsAndHashCode() {
        Zinema cinema1 = new Zinema(1, "Cinema 1", "Elorrieta",20);
        Zinema cinema2 = new Zinema(1, "Cinema 1", "Elorrieta",20);
        Zinema cinema3 = new Zinema(2, "Cinema 2", "Mungia", 15);

        // Test equals method
        assertTrue(cinema1.equals(cinema2));
        assertFalse(cinema1.equals(cinema3));

        // Test hashCode method
        assertEquals(cinema1.hashCode(), cinema2.hashCode());
        assertNotEquals(cinema1.hashCode(), cinema3.hashCode());
    }

    @Test
    public void testToString() {
        Zinema cinema = new Zinema(3, "Cinema 3", "Derio",8);
        String expected = "Zinema [id=3, izena=Cinema 3, helbidea=Derio, aretokop=8]";
        assertEquals(expected, cinema.toString());
    }

    @Test
    public void testGettersAndSetters() {
        Zinema cinema = new Zinema();

        cinema.setId(4);
        assertEquals(4, cinema.getId());

        cinema.setIzena("Cinema 4");
        assertEquals("Cinema 4", cinema.getIzena());

        cinema.setHelbidea("elorrieta");
        assertEquals("elorrieta", cinema.getHelbidea());
        
        cinema.setAretokop(12);
        assertEquals(12, cinema.getAretokop());
    }
}

