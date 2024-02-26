package Testak;
import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import master.Aretoa;
import master.Bezero;
import master.Erosketa;
import master.Filma;
import master.Saioa;
import master.Sarrera;
public class SarreraTest {
	 @Test
	    public void testEquals() {
	        Saioa saioa1 = new Saioa();
	        Saioa saioa2 = new Saioa();

	        Sarrera sarrera1 = new Sarrera(1, saioa1, 10.0f, 5);
	        Sarrera sarrera2 = new Sarrera(1, saioa1, 10.0f, 5);
	        Sarrera sarrera3 = new Sarrera(2, saioa2, 15.0f, 3);

	        assertTrue(sarrera1.equals(sarrera2)); // Mismo id, saioa, prezioa y kantitatea
	        assertFalse(sarrera1.equals(sarrera3)); // Diferente id y saioa
	    }

	    @Test
	    public void testHashCode() {
	        Saioa saioa1 = new Saioa();

	        Sarrera sarrera1 = new Sarrera(1, saioa1, 10.0f, 5);
	        Sarrera sarrera2 = new Sarrera(1, saioa1, 10.0f, 5);

	        assertEquals(sarrera1.hashCode(), sarrera2.hashCode()); // Mismo id, saioa, prezioa y kantitatea
	    }

	    @Test
	    public void testToString() {
	        Saioa saioa1 = new Saioa();

	        Sarrera sarrera1 = new Sarrera(1, saioa1, 10.0f, 5);
	        String expectedString = "Sarrera [id=1, saioa=Saioa [id=1, izena=Saioa 1], prezioa=10.0, kantitatea=5]";
	        assertEquals(expectedString, sarrera1.toString());
	    }
	}
