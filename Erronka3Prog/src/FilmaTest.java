import static org.junit.Assert.*;
import org.junit.Test;
public class FilmaTest {
  @Test
  public void testEquals() {
      Filma filma1 = new Filma(1, 120, "drama", 7.5 ,"avatar");
      Filma filma2 = new Filma(1, 120, "drama", 7.5 ,"avatar");
      Filma filma3 = new Filma(2, 220, "komedia", 8.5 ,"harry potter");
      assertTrue(filma1.equals(filma2));
      assertFalse(filma1.equals(filma3));
  }
  @Test
  public void testHashCode() {
	  Filma filma1 = new Filma(1, 120, "drama", 7.5 ,"avatar");
      Filma filma2 = new Filma(1, 120, "drama", 7.5 ,"avatar");
      Filma filma3 = new Filma(2, 220, "komedia", 8.5 ,"harry potter");
    
      assertEquals(filma1.hashCode(), filma2.hashCode());
      assertNotEquals(filma1.hashCode(), filma3.hashCode());
  }
  @Test
  public void testToString() {
      Filma Filma = new Filma(1, 120, "drama", 7.5 ,"avatar");
     
      assertEquals("Filma [id=1, iraupena=120, generoa=drama, presioa=7.5, izena=avatar]", Filma.toString());
  }
 
  @Test
  public void testGettersAndSetters() {
      Filma Filma = new Filma();
      Filma.setId(1);
      Filma.setIraupena(120);
      Filma.setGeneroa("drama");
      Filma.setprezioa(7.5);
      Filma.setIzena("avatar");
      assertEquals(1, Filma.getId());
      assertEquals(120, Filma.getIraupena());
      assertEquals("drama", Filma.getGeneroa());
      assertEquals(7,5, Filma.getprezioa());
      assertEquals("avatar", Filma.getIzena());
  }
}
