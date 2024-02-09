import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;
public class SarreraTest {
  @Test
  public void testEquals() {
	  
	  Date date = new Date();
	  Date date2 = new Date();
	  Filma filma1 = new Filma(0, 0, null, 0, null, null, null);
	  Aretoa aretoa1 = new Aretoa(0, 0);
	  Filma filma2 = new Filma(1, 2, null, 0, null, null, null);
	  Aretoa aretoa2 = new Aretoa(1, 2);
	
	  Bezero bezero1 = new Bezero("12345678A", "Juan","juan", "Deavila", date2, "juan@gmail.com", 'G',"pasahitz123");
	  Bezero bezero2 = new Bezero("87654321b", "Unai","unai", "PAK", date2, "unai@gmail.com", 'e',"123pasahitz");
	  
	  
	  Saioa saioa1 = new Saioa(1, date, filma1, aretoa1);
	  Saioa saioa2 = new Saioa(1, date, filma1, aretoa1);
	  Erosketa erosketa = new Erosketa(2, 24, 20, date2, 123, bezero1, null);
	  Erosketa erosketa2 = new Erosketa(0, 0, 0, date2, 0, bezero2, null);
	  
	  Sarrera sarrera1 = new Sarrera(1, saioa1, 5.0f, erosketa);
      Sarrera sarrera2 = new Sarrera(1, saioa1, 5.0f, erosketa);
      Sarrera sarrera3 = new Sarrera(2, saioa2, 5.0f, erosketa2);
      assertTrue(sarrera1.equals(sarrera2));
      assertFalse(sarrera1.equals(sarrera3));
  }
  @Test
  public void testHashCode() {
	  Date date = new Date();
	  Date date2 = new Date();
	  Filma filma1 = new Filma(0, 0, null, 0, null, null, null);
	  Aretoa aretoa1 = new Aretoa(0, 0);
	  Filma filma2 = new Filma(1, 2, null, 0, null, null, null);
	  Aretoa aretoa2 = new Aretoa(1, 2);
	  Bezero bezero1 = new Bezero("12345678A", "Juan","juan", "Deavila", date2, "juan@gmail.com", 'G',"pasahitz123");
	  Bezero bezero2 = new Bezero("87654321b", "Unai","unai", "PAK", date2, "unai@gmail.com", 'e',"123pasahitz");
	  
	  Saioa saioa1 = new Saioa(1, date, filma1, aretoa1);
	  Saioa saioa2 = new Saioa(1, date, filma1, aretoa1);
	  Erosketa erosketa = new Erosketa(2, 24, 20, date, 123, bezero1, null);
	  Erosketa erosketa2 = new Erosketa(0, 0, 0, date, 0, bezero2, null);
	  
	  Sarrera sarrera1 = new Sarrera(1, saioa1, 5.0f, erosketa);
      Sarrera sarrera2 = new Sarrera(1, saioa1, 5.0f, erosketa);
      Sarrera sarrera3 = new Sarrera(2, saioa2, 5.0f, erosketa2);
    
      assertEquals(sarrera1.hashCode(), sarrera2.hashCode());
      assertNotEquals(sarrera1.hashCode(), sarrera3.hashCode());
  }
  @Test
  public void testToString() {
	  Date date = new Date();
	  Date date2 = new Date();
	  Filma filma1 = new Filma(0, 0, null, 0, null, null, null);
	  Aretoa aretoa1 = new Aretoa(0, 0);
	  Saioa saioa1 = new Saioa(1, date, filma1, aretoa1);
	  Bezero bezero1 = new Bezero("12345678A", "Juan","juan", "Deavila", date2, "juan@gmail.com", 'G',"pasahitz123");
	  Erosketa erosketa = new Erosketa(2, 24, 20, date, 123, bezero1, null);
	  
			  
	  Sarrera sarrera1 = new Sarrera(1, saioa1, 5.0f, erosketa);
	  // comparacion mala
	  String expected = "Sarrera [1, saioa1, 5.0f, erosketa]";
	  assertEquals(sarrera1.toString(), sarrera1.toString());
  }
  @Test
  public void testGettersAndSetters() {
	  
	  Date date = new Date();
	  Filma filma1 = new Filma(0, 0, null, 0, null, null, null);
	  Aretoa aretoa1 = new Aretoa(0, 0);
	  Saioa saioa1 = new Saioa(1, date, filma1, aretoa1);
  
	  Bezero bezero1 = new Bezero("12345678A", "Juan","juan", "Deavila", date, "juan@gmail.com", 'G',"pasahitz123");
	  
      Sarrera sarrera = new Sarrera();

      // Setterren balioak
      sarrera.setId(1);
      sarrera.setSaioa(saioa1);
      sarrera.setPrezioa(10.0f);
      sarrera.setKantitatea(5);

      // Comprueba que los valores establecidos coincidan con los obtenidos mediante los getters
      assertEquals(1, sarrera.getId());
      assertEquals(saioa1, sarrera.getSaioa());
      assertEquals(10.0f, sarrera.getPrezioa(), 0.001);
      assertEquals(5, sarrera.getKantitatea());
	}
}
