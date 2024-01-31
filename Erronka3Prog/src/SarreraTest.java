import static org.junit.Assert.*;
import org.junit.Test;
public class SarreraTest {
  @Test
  public void testEquals() {
      Sarrera sarrera1 = new Sarrera(1, 20220130, "avatar", 1200, 1, 10.5f);
      Sarrera sarrera2 = new Sarrera(1, 20220130, "avatar", 1200, 1, 10.5f);
      Sarrera sarrera3 = new Sarrera(2, 20220130, "harry potter", 1300, 2, 15.0f);
      assertTrue(sarrera1.equals(sarrera2));
      assertFalse(sarrera1.equals(sarrera3));
  }
  @Test
  public void testHashCode() {
      Sarrera sarrera1 = new Sarrera(1, 20220130, "avatar", 1200, 1, 10.5f);
      Sarrera sarrera2 = new Sarrera(1, 20220130, "avatar", 1200, 1, 10.5f);
      Sarrera sarrera3 = new Sarrera(2, 20220130, "harry potter", 1300, 2, 15.0f);
    
      assertEquals(sarrera1.hashCode(), sarrera2.hashCode());
      assertNotEquals(sarrera1.hashCode(), sarrera3.hashCode());
  }
  @Test
  public void testToString() {
      Sarrera sarrera = new Sarrera(1, 20220130, "avatar", 1200, 1, 10.5f);
     
      assertEquals("Sarrera [id=1, data=20220130, ordutegia=1200, aretoa=1, prezioa=10.5]", sarrera.toString());
  }
 
  @Test
  public void testGettersAndSetters() {
      Sarrera sarrera = new Sarrera();
      sarrera.setId(1);
      sarrera.setData(20220130);
      sarrera.setFilma("avatar");
      sarrera.setOrdutegia(1200);
      sarrera.setAretoa(1);
      sarrera.setPrezioa(10.5f);
      assertEquals(1, sarrera.getId());
      assertEquals(20220130, sarrera.getData());
      assertEquals("avatar", sarrera.getFilma());
      assertEquals(1200, sarrera.getOrdutegia());
      assertEquals(1, sarrera.getAretoa());
      assertEquals(10.5f, sarrera.getPrezioa(), 0.001);
  }
}
