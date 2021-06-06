public class Lesson04_3 {
  public static void main(String args[]) {
    //インスタンスの生成
    Calculation c = new Calculation();
    int number = Integer.parseInt(args[0]);
    c.number = number;
    c.printSqu();
    c.printFac();
  }
}
