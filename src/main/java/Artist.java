import java.util.List;
import java.util.ArrayList;

public class Artist implements Comparable<Artist>{
  private String mArtist;
  private static List<Artist> instances = new ArrayList<Artist>();
  private int mId;
  private List<CD> mCDs;

  public Artist(String artist) {
    mArtist = artist;
    instances.add(this);
    mId = instances.size();
    mCDs = new ArrayList<CD>();
  }
  public String getArtist(){
    return mArtist;
  }
  public static List<Artist>all(){
    return instances;
  }
  public static void clear(){
    instances.clear();
  }
  public int getId(){
    return mId;
  }
  public List<CD> getCDs(){
    return mCDs;
  }
  public void addCDs(CD theCD){
    mCDs.add(theCD);
  }
  public static Artist find(int id){
    return instances.get(id -1);
  }

  public int compareTo(Artist artist2){
    return getArtist().compareTo(artist2.getArtist());
  }
}
