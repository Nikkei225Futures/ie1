public class Lesson08_3 {
  public static void main(String[] args) {
    Printer printer1 = new Printer(50, 25);
    printer1.start();
    System.out.println("=====");
    printer1.printInfo();
    System.out.println("=====");
    printer1.stop();

    Printer printer2 = new Printer(75, 50, 25);
    printer2.start();
    System.out.println("=====");
    printer2.printInfo();
    System.out.println("=====");
    printer2.stop();
  }
}
