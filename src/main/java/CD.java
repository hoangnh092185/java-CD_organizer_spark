import java.util.List;
import java.util.ArrayList;

public class CD implements Comparable<CD>{
  private String mCDName;
  private String mYear;
  private static List<CD> instances = new ArrayList<CD>();
  private int mId;

  public CD(String cdname, String year) {
    mCDName = cdname;
    mYear = year;
    instances.add(this);
    mId = instances.size();
  }

  public String getCDName() {
    return mCDName;
  }


  public String getYear() {
    return mYear;
  }

  public int getId() {
    return mId;
  }

  public int compareTo(CD cd2){
    return getCDName().compareTo(cd2.getCDName());
  }

  public static List<CD> all(){
    return instances;
  }

  public static void clear(){
    instances.clear();
  }

  public static CD find(int id){
    return instances.get(id-1);
  }
}
