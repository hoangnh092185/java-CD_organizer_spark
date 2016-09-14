import java.util.List;
import java.util.ArrayList;
import org.junit.*;
import static org.junit.Assert.*;


public class ArtistTest {
  @Test
  public void Artist_instanctiatesCorrectly_true() {
    Artist testArtist = new Artist("Home");
    assertEquals(true, testArtist instanceof Artist);
  }
  @Test
  public void getArtist_artistInstantiatesWithName_Home(){
    Artist testArtist = new Artist("Home");
    assertEquals("Home", testArtist.getArtist());
  }
  @Test
  public void all_returnsAllInstantcesOfArtist_true(){
    Artist firstArtist = new Artist("Home");
    Artist secondArtist = new Artist("work");
    assertEquals(true, Artist.all().contains(firstArtist));
    assertEquals(true, Artist.all().contains(secondArtist));
  }
  @Test
  public void clear_returnsAllArtistFormListSize_0(){
    Artist firstArtist = new Artist("Home");
    Artist secondArtist = new Artist("work");
    Artist.clear();
    assertEquals(0, Artist.all().size());
  }
  @Test
  public void getId_artistInstantiateWithAnId_1(){
    Artist.clear();
    Artist testArtist = new Artist("Home");
    assertEquals(1, testArtist.getId());
  }

  @Test
  public void find_FindsASpecificArtist_Muse(){
    Artist.clear();
    Artist artistOne = new Artist("AC/DC");
    Artist artistTwo = new Artist("Muse");
    Artist artistThree = new Artist("Metalica");
    assertEquals(artistTwo, Artist.find(artistTwo.getId()));
  }

  @Test public void add_AddsACD_true(){
    Artist.clear();

    Artist artistOne = new Artist("AC/DC");
    CD cdOne = new CD("Back in Black","1979");
    artistOne.addCDs(cdOne);
    assertTrue(artistOne.getCDs().contains(cdOne));
  }

  @Test public void getCD_GivesAnEmptyCDList_ArrayList(){
      Artist.clear();
      Artist artistOne = new Artist("AC/DC");
      assertEquals(0,artistOne.getCDs().size());
  }

}
