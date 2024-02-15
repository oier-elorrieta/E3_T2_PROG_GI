package Testak;
import static org.junit.Assert.*;
import master.Zinema;
import org.junit.Test;

import master.Aretoa;
import master.Saioa;
import master.Zinema;

public class ZinemaTest {

    @Test
    public void testEqualsAndHashCode() {
    	Aretoa aretoa2 = new Aretoa(1, "");
        Aretoa[] aretoarray = new Aretoa[]{aretoa2};
        Aretoa[] aretoarray2 = new Aretoa[]{aretoa2};
        Saioa[] saio = new Saioa[1];
        Saioa[] saio2 = new Saioa[1];

        Zinema zinema1 = new Zinema(23, "izena", "Helbidea", "kontaktua", "deskribapena", aretoarray, saio);
        Zinema zinema2 = new Zinema(23, "izena", "Helbidea", "kontaktua", "deskribapena", aretoarray, saio);
        Zinema zinema3 = new Zinema(24, "ezizena", "ezHelbidea", "ezkontaktua", "ezdeskribapena", aretoarray2, saio2);

        // test equals metodoa
        assertTrue(zinema1.equals(zinema2));
        assertFalse(zinema1.equals(zinema3));

        // Hashcode metodoa
        assertEquals(zinema1.hashCode(), zinema2.hashCode());
        assertNotEquals(zinema1.hashCode(), zinema3.hashCode());
    }
    @Test
    public void testToString() {
        Zinema cinema = new Zinema();
        String expected = "Zinema [id=3, izena=Cinema 3, helbidea=Derio]";
        assertEquals(cinema.toString(), cinema.toString());
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
    }
}

