public class Lesson08_4 {
  public static void main(String[] args) {
    Printer printer = new Printer(100, 100, 100);
    printer.start();
    System.out.println("=====");
    printer.printInfo();
    System.out.println("=====");

    printer.print();
    System.out.println("=====");
    printer.printInfo();
    System.out.println("=====");

    printer.printColor();
    System.out.println("=====");
    printer.printInfo();
    System.out.println("=====");

    printer.printColor();

    printer.stop();
    System.out.println("=====");
    printer.printInfo();
    System.out.println("=====");
  }
}
