
public class Record implements java.io.Serializable {
  private int score ;
  private String name ;

  public Record( String name, int score ) {
    this.name = name ;
    this.score = score ;
  }

  public Record() {
    this( "---", 0 ) ;
  }

  public int getScore() {
    return score ;
  }

  public String getName() {
    return name ;
  }

  public void incScore(int s) {
    score+=s ;
  }

  public void setName( String str ) {
    name = str ;
  }

  public String toString() {
    return " "+name+"  : "+score ;
  }
}
