public class Lesson08_2 {
  public static void main(String[] args) {
    Printer printer = new Printer();
    printer.start();
    System.out.println("=====");
    printer.printInfo();
    System.out.println("=====");
    printer.stop();
    System.out.println("=====");
    printer.printInfo();
    System.out.println("=====");
  }
}
