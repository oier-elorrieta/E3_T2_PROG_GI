package Testak;

import static org.junit.Assert.*;
import org.junit.Test;
import master.Zinema;
import master.Aretoa;
import master.Saioa;

import org.junit.Test;

public class ZinemaTest {

	 @Test
	    public void testHashCode() {
	        Zinema zinema1 = new Zinema(1, "Zinema1", "Helbidea1", "Kontaktua1", "Deskribapena1", null, null);
	        Zinema zinema2 = new Zinema(1, "Zinema1", "Helbidea1", "Kontaktua1", "Deskribapena1", null, null);
	        
	        assertEquals(zinema1.hashCode(), zinema2.hashCode());
	    }

	    @Test
	    public void testGetId() {
	        Zinema zinema = new Zinema(1, "Zinema1", "Helbidea1", "Kontaktua1", "Deskribapena1", null, null);
	        
	        assertEquals(1, zinema.getId());
	    }

	    @Test
	    public void testSetId() {
	        Zinema zinema = new Zinema();
	        zinema.setId(1);
	        
	        assertEquals(1, zinema.getId());
	    }

	    @Test
	    public void testGetIzena() {
	        Zinema zinema = new Zinema(1, "Zinema1", "Helbidea1", "Kontaktua1", "Deskribapena1", null, null);
	        
	        assertEquals("Zinema1", zinema.getIzena());
	    }

	    @Test
	    public void testSetIzena() {
	        Zinema zinema = new Zinema();
	        zinema.setIzena("Zinema1");
	        
	        assertEquals("Zinema1", zinema.getIzena());
	    }

	    @Test
	    public void testGetHelbidea() {
	        Zinema zinema = new Zinema(1, "Zinema1", "Helbidea1", "Kontaktua1", "Deskribapena1", null, null);
	        
	        assertEquals("Helbidea1", zinema.getHelbidea());
	    }

	    @Test
	    public void testSetHelbidea() {
	        Zinema zinema = new Zinema();
	        zinema.setHelbidea("Helbidea1");
	        
	        assertEquals("Helbidea1", zinema.getHelbidea());
	    }

	    @Test
	    public void testGetKontaktua() {
	        Zinema zinema = new Zinema(1, "Zinema1", "Helbidea1", "Kontaktua1", "Deskribapena1", null, null);
	        
	        assertEquals("Kontaktua1", zinema.getKontaktua());
	    }

	    @Test
	    public void testSetKontaktua() {
	        Zinema zinema = new Zinema();
	        zinema.setKontaktua("Kontaktua1");
	        
	        assertEquals("Kontaktua1", zinema.getKontaktua());
	    }

	    @Test
	    public void testGetDeskribapena() {
	        Zinema zinema = new Zinema(1, "Zinema1", "Helbidea1", "Kontaktua1", "Deskribapena1", null, null);
	        
	        assertEquals("Deskribapena1", zinema.getDeskribapena());
	    }

	    @Test
	    public void testSetDeskribapena() {
	        Zinema zinema = new Zinema();
	        zinema.setDeskribapena("Deskribapena1");
	        
	        assertEquals("Deskribapena1", zinema.getDeskribapena());
	    }

	    @Test
	    public void testGetAretoak() {
	        Aretoa[] aretoak = new Aretoa[2];
	        aretoak[0] = new Aretoa();
	        aretoak[1] = new Aretoa();
	        Zinema zinema = new Zinema(1, "Zinema1", "Helbidea1", "Kontaktua1", "Deskribapena1", aretoak, null);
	        
	        assertArrayEquals(aretoak, zinema.getAretoak());
	    }

	    @Test
	    public void testSetAretoak() {
	        Aretoa[] aretoak = new Aretoa[2];
	        aretoak[0] = new Aretoa();
	        aretoak[1] = new Aretoa();
	        Zinema zinema = new Zinema();
	        zinema.setAretoak(aretoak);
	        
	        assertArrayEquals(aretoak, zinema.getAretoak());
	    }

	    @Test
	    public void testGetSaioak() {
	        Saioa[] saioak = new Saioa[2];
	        saioak[0] = new Saioa();
	        saioak[1] = new Saioa();
	        Zinema zinema = new Zinema(1, "Zinema1", "Helbidea1", "Kontaktua1", "Deskribapena1", null, saioak);
	        
	        assertArrayEquals(saioak, zinema.getSaioak());
	    }

	    @Test
	    public void testSetSaioak() {
	        Saioa[] saioak = new Saioa[2];
	        saioak[0] = new Saioa();
	        saioak[1] = new Saioa();
	        Zinema zinema = new Zinema();
	        zinema.setSaioak(saioak);
	        
	        assertArrayEquals(saioak, zinema.getSaioak());
	    }

	    @Test
	    public void testEqualsObject() {
	        Zinema zinema1 = new Zinema(1, "Zinema1", "Helbidea1", "Kontaktua1", "Deskribapena1", null, null);
	        Zinema zinema2 = new Zinema(1, "Zinema1", "Helbidea1", "Kontaktua1", "Deskribapena1", null, null);
	        Zinema zinema3 = new Zinema(2, "Zinema2", "Helbidea2", "Kontaktua2", "Deskribapena2", null, null);
	        
	        assertTrue(zinema1.equals(zinema2));
	        assertFalse(zinema1.equals(zinema3));
	    }

	    @Test
	    public void testToString() {
	        Zinema zinema = new Zinema(1, "Zinema1", "Helbidea1", "Kontaktua1", "Deskribapena1", null, null);
	        String expected = "Zinema [id=1, izena=Zinema1, helbidea=Helbidea1, kontaktua=Kontaktua1, deskribapena=Deskribapena1, aretoak=null, saioak=null]";
	        
	        assertEquals(expected, zinema.toString());
	    }

	    
	}
