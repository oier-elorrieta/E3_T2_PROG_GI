import static org.junit.Assert.*;

import org.junit.Test;

public class ErosketaTest {

	

    @Test
    public void testEquals() {
    	Bezero bezero1 = new Bezero();
        Bezero bezero2 = new Bezero();
       
        Erosketa erosketa1 = new Erosketa(1, 123, 10.000f, 25.25, bezero1);
        Erosketa erosketa2 = new Erosketa(1, 123, 10.000f, 25.25, bezero1);
        Erosketa erosketa3 = new Erosketa(2, 456, 20, 34.43, bezero2);

        assertTrue(erosketa1.equals(erosketa2));
        assertFalse(erosketa1.equals(erosketa3));

        // ObjetuaK OBJETU TIPOAREKIN
        Erosketa erosketa4 = new Erosketa(erosketa4, 789, 5, 50.0, "789XYZ");
        Erosketa erosketa5 = new Erosketa(erosketa5, 789, 5, 50.0, "789XYZ");
        Erosketa erosketa6 = new Erosketa(erosketa6, 123, 8, 80.0, "123QWE");
        //

        assertTrue(erosketa4.equals(erosketa5));
        assertFalse(erosketa4.equals(erosketa6));
    }

    @Test
    public void testGettersAndSetters() {
        Erosketa erosketa = new Erosketa(1, 123, 10, 100.0, "123ABC");

        // Setterrak
        erosketa.setErosketa(2);
        erosketa.setJatorria(456);
        erosketa.setDeskontua(20);
        erosketa.setPreziotot(200.0);
        erosketa.setNan("456DEF");

        // Getterrak
        assertEquals(2, erosketa.getErosketa());
        assertEquals(456, erosketa.getJatorria());
        assertEquals(20, erosketa.getDeskontua());
        assertEquals(200.0, erosketa.getPreziotot(), 0.001);
        assertEquals("456DEF", erosketa.getNan());
    }

    @Test
    public void testHashCode() {
        // Hashcode int-ekin
        Erosketa erosketa1 = new Erosketa(1, 123, 10, 100.0, "123ABC");
        Erosketa erosketa2 = new Erosketa(1, 123, 10, 100.0, "123ABC");
        Erosketa erosketa3 = new Erosketa(2, 456, 20, 200.0, "456DEF");

        assertEquals(erosketa1.hashCode(), erosketa2.hashCode());
        assertNotEquals(erosketa1.hashCode(), erosketa3.hashCode());

        // Hashcode objetuekin
        Erosketa erosketa4 = new Erosketa("objeto", 789, 5, 50.0, "789XYZ");
        Erosketa erosketa5 = new Erosketa("objeto", 789, 5, 50.0, "789XYZ");
        Erosketa erosketa6 = new Erosketa("otro", 123, 8, 80.0, "123QWE");

        assertEquals(erosketa4.hashCode(), erosketa5.hashCode());
        assertNotEquals(erosketa4.hashCode(), erosketa6.hashCode());
    }

}

