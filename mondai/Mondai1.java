class Data1 {
  int d = 0;
}
public class Mondai1 {
  public static void main(String[] args) {
    Data1 d1 = new Data1();
    Data1 d2 = new Data1();
    d1.d = 1;
    d2.d = 3;
    d1 = d2;
    d1.d++;
    d2.d--;
    System.out.println("d1.d = " + d1.d);
    System.out.println("d2.d = " + d2.d);
  }
}