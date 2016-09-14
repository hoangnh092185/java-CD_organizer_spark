import org.junit.*;
import static org.junit.Assert.*;

public class CDTest {

  @Test
  public void CD_instantiatesCorrectly_true(){
    CD myCD = new CD("Album",  "2000");
    assertEquals(true, myCD instanceof CD);
  }

  @Test
  public void CD_getsAlbum_Album(){
    CD myCD = new CD("Album", "2000");
    assertEquals("Album", myCD.getCDName());
  }

  @Test
  public void all_GivesListOfAllCDs_true(){
    CD cdOne = new CD("Blackholes","2007");
    CD cdTwo = new CD("2nd Law","2012");
    assertEquals(true,CD.all().contains(cdOne));
    assertEquals(true,CD.all().contains(cdTwo));
  }

  @Test
  public void clear_ClearsAllCDs_0(){
    CD cdOne = new CD("Blackholes","2007");
    CD cdTwo = new CD("2nd Law","2012");
    CD.clear();
    assertEquals(0,CD.all().size());
  }

  @Test
  public void find_FindaSpecificCD_2ndLaw(){
    CD.clear();
    CD cdOne = new CD("Blackholes","2007");
    CD cdTwo = new CD("2nd Law","2012");
    CD cdThree = new CD("Origins of Symetry","2001");
    assertEquals(cdTwo, CD.find(cdTwo.getId()));
  }

}
