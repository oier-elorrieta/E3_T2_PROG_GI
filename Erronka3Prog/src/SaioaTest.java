import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Date;

public class SaioaTest {

    @Test
    public void testEqualsAndHashCode() {
        Date date1 = new Date();
        Date date2 = new Date();
        
        Saioa saioa1 = new Saioa(1, date1, 101, 201);
        Saioa saioa2 = new Saioa(1, date1, 101, 201);
        Saioa saioa3 = new Saioa(2, date2, 102, 202);

        // Test equals method
        assertTrue(saioa1.equals(saioa2));
        assertFalse(saioa1.equals(saioa3));

        // Test hashCode method
        assertEquals(saioa1.hashCode(), saioa2.hashCode());
        assertNotEquals(saioa1.hashCode(), saioa3.hashCode());
    }

    @Test
    public void testToString() {
        Date date = new Date();
        Saioa saioa = new Saioa(3, date, 103, 203);
        String expected = "Saioa [IdSaioa=3, data=" + date + ", IdFilma=103, IdAreto=203]";
        assertEquals(expected, saioa.toString());
    }

    @Test
    public void testGettersAndSetters() {
        Date date = new Date();
        Saioa saioa = new Saioa(0, date, 0, 0);

        saioa.setIdSaioa(4);
        assertEquals(4, saioa.getIdSaioa());

        saioa.setData(date);
        assertEquals(date, saioa.getData());

        saioa.setIdFilma(104);
        assertEquals(104, saioa.getIdFilma());

        saioa.setIdAreto(204);
        assertEquals(204, saioa.getIdAreto());
    }

    

    @Test
    public void testEqualsWithDifferentClass() {
        Date date = new Date();
        Saioa saioa1 = new Saioa(1, date, 101, 201);

        assertFalse(saioa1.equals("Not a Saioa object"));
    }
}