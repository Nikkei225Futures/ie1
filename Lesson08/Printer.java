public class Printer extends Machine {
  protected int paper;
  protected int ink;

  public Printer() {
    paper = 100;
    ink = 100;
  }

  /* --- Lesson08_3 ここから --- */
  public Printer(int paper, int ink){
    this.paper = paper;
    this.ink = ink;
  }

  public Printer(int battery, int paper, int ink){
    this(paper, ink);
    this.battery = battery;
  }
  /* --- Lesson08_3 ここまで --- */


  /* --- Lesson08_4 ここから --- */
  public void print(){
    if(this.battery-10 < 0 || this.paper-10< 0 || this.ink-10 < 0){
      System.out.println("プリントに失敗しました.");
    }else{
      this.battery-=10;
      this.paper-=10;
      this.ink-=10;
      System.out.println("プリントに成功しました.");
    }
  }

  public void printColor(){
    if(this.battery-10 < 0 || this.paper-10< 0 || this.ink-50 < 0){
      System.out.println("カラープリントに失敗しました.");
    }else{
      this.battery-=10;
      this.paper-=10;
      this.ink-=50;
      System.out.println("カラープリントに成功しました.");
    }
  }

  /* --- Lesson08_4 ここまで --- */


  /* --- Lesson08_2 ここから --- */
  public void printInfo(){
    super.printInfo();
    System.out.println("用紙残量:" + this.paper);
    System.out.println("バッテリー残量:" + this.ink);
  }
  /* --- Lesson08_2 ここまで --- */
}
