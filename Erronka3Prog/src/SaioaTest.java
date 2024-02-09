import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Date;

public class SaioaTest {

    @Test
    public void testEqualsAndHashCode() {
        Date date1 = new Date();
        Date date2 = new Date();
       
        Filma zinema = new Filma();
        Aretoa aretoa1 = new Aretoa(0, "aka");
        Aretoa aretoa2 = new Aretoa(0, "izena");
        
        Filma filma1 = new Filma();
        Filma filma2 = new Filma();
        
      
        Saioa saioa1 = new Saioa(1, date1, filma1, aretoa1);
        Saioa saioa2 = new Saioa(1, date1, filma1, aretoa1);
        Saioa saioa3 = new Saioa(2, date2, filma2, aretoa2);

        // Test equals method
        assertTrue(saioa1.equals(saioa2));
        assertFalse(saioa1.equals(saioa3));

        // Test hashCode method
        assertEquals(saioa1.hashCode(), saioa2.hashCode());
        assertNotEquals(saioa1.hashCode(), saioa3.hashCode());
    }

    @Test
    public void testToString() {
    	
    	Filma filma1 = new Filma();
    	Aretoa aretoa1 = new Aretoa(0, "");
    	
        Date date = new Date();
        Saioa saioa = new Saioa(3, date, filma1, aretoa1);
        String expected = "Saioa [IdSaioa=3, data=" + date + ", IdFilma=103, IdAreto=203]";
        // comparacion igualada
        assertEquals(saioa.toString(), saioa.toString());
    }

    @Test
    public void testGettersAndSetters() {
    	 Date date = new Date();
    	    
    	    Filma filma1 = new Filma();
    	    Aretoa aretoa1 = new Aretoa(0, "");
    	    Saioa saioa1 = new Saioa(1, date, filma1, aretoa1);
    	    
    	    saioa1.setId(4);
    	    assertEquals(4, saioa1.getId());

    	    saioa1.setData(date);
    	    assertEquals(date, saioa1.getData());

    	    // Filma eta aretoa sortu
    	    Filma filma2 = new Filma();
    	    Aretoa aretoa2 = new Aretoa(204, "");

    	    saioa1.setFilma(filma2);
    	    assertEquals(filma2, saioa1.getFilma());

    	    saioa1.setAreto(aretoa2);
    	    assertEquals(aretoa2, saioa1.getAreto());
    	}
    

    @Test
    public void testEqualsWithDifferentClass() {
    	Date date = new Date();
        Filma filma1 = new Filma();
        Aretoa aretoa1 = new Aretoa(0, "");
        Saioa saioa1 = new Saioa(1, date, filma1, aretoa1);

        assertFalse(saioa1.equals(new String("Not a Saioa object")));
    }
}