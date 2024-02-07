import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;
public class SarreraTest {
  @Test
  public void testEquals() {
	  
	  Date date = new Date();
	  Filma filma1 = new Filma(0, 0, null, 0, null, null, null);
	  Aretoa aretoa1 = new Aretoa(0, 0, new Filma(0, 0, null, 0, null, null, null));
	  Saioa saioa1 = new Saioa(1, date, filma1, aretoa1);
	  
	  Sarrera sarrera1 = new Sarrera(1, saioa1, 5.0f, erosketa);
      Sarrera sarrera2 = new Sarrera(1, 10, 5.0f,1);
      Sarrera sarrera3 = new Sarrera(2, 11, 5.0f,2);
      assertTrue(sarrera1.equals(sarrera2));
      assertFalse(sarrera1.equals(sarrera3));
  }
  @Test
  public void testHashCode() {
	  Sarrera sarrera1 = new Sarrera(1, 10, 5.0f,1);
      Sarrera sarrera2 = new Sarrera(1, 10, 5.0f,1);
      Sarrera sarrera3 = new Sarrera(2, 11, 5.0f,2);
    
      assertEquals(sarrera1.hashCode(), sarrera2.hashCode());
      assertNotEquals(sarrera1.hashCode(), sarrera3.hashCode());
  }
  @Test
  public void testToString() {
	  Sarrera sarrera = new Sarrera(1, 10, 5.0f,1);
	     
      assertEquals("Sarrera [id=1, saioa=10, prezioa=5.0, erosketa=1]", sarrera.toString());
  }
  @Test
  public void testGettersAndSetters() {
	  Date date = new Date();
	    
	    Filma filma1 = new Filma(0, 0, null, 0, null, null, null);
	    Aretoa aretoa1 = new Aretoa(0, 0, new Filma(0, 0, null, 0, null, null, null));
	    Saioa saioa1 = new Saioa(1, date, filma1, aretoa1);
	    
	    saioa1.setId(4);
	    assertEquals(4, saioa1.getId());

	    saioa1.setData(date);
	    assertEquals(date, saioa1.getData());

	    saioa1.setFilma(104);
	    assertEquals(104, saioa1.getFilma());

	    saioa1.setAreto(204);
	    assertEquals(204, saioa1.getAreto());
	}
}
