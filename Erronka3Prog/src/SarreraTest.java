import static org.junit.Assert.*;
import org.junit.Test;
public class SarreraTest {
  @Test
  public void testEquals() {
      Sarrera sarrera1 = new Sarrera(1, 10, 5.0f,1);
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
      Sarrera sarrera = new Sarrera();
      sarrera.setId(1);
      sarrera.setSaioa(10);
      sarrera.setPrezioa(5.0f);
      sarrera.setErosketa(1);
      assertEquals(1, sarrera.getId());
      assertEquals(10, sarrera.getSaioa());
      assertEquals(5.0f, sarrera.getPrezioa(), 0.001);
      assertEquals(1, sarrera.getErosketa());
  }
}
