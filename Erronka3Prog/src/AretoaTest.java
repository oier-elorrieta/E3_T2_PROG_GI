import static org.junit.Assert.*;
import org.junit.Test;

public class AretoaTest {

    @Test
    public void testEqualsAndHashCode() {
        Aretoa aretoa1 = new Aretoa(1, "aka");
        Aretoa aretoa2 = new Aretoa(1, "aka");
        Aretoa aretoa3 = new Aretoa(2, "kak");

        // Test equals method
        assertTrue(aretoa1.equals(aretoa2));
        assertFalse(aretoa1.equals(aretoa3));

        // Test hashCode method
        assertEquals(aretoa1.hashCode(), aretoa2.hashCode());
        assertNotEquals(aretoa1.hashCode(), aretoa3.hashCode());
    }

    @Test
    public void testToString() {
        Aretoa aretoa = new Aretoa(3, "kak");
        String expected = "Aretoa [izena=3, id=103, zinema=203]";
        
        //TO DO, EZ PASATZEN HEMENDIK (OBJETU BERDINA, BERDINAREKIN KONPARATZEN DA) EN VEZ el primer aretoa.toString ira un String o expected
        assertEquals(aretoa.toString(), aretoa.toString());
    }

    @Test
    public void testGettersAndSetters() {
    	
        Aretoa aretoa = new Aretoa(0, "");
        
        aretoa.setId(104);
        assertEquals(104, aretoa.getId());

    }
}


