public class Lesson08_5 {
  public static void main(String[] args) {
    ImprovedPrinter iPrinter = new ImprovedPrinter(50, 50, 50);
    iPrinter.start();
    System.out.println("=====");
    iPrinter.printInfo();
    System.out.println("=====");

    iPrinter.print();  
    System.out.println("=====");
    iPrinter.printInfo();
    System.out.println("=====");

    iPrinter.printColor();
    System.out.println("=====");
    iPrinter.printInfo();
    System.out.println("=====");

    iPrinter.printColor();
    iPrinter.stop();
    System.out.println("=====");
    iPrinter.printInfo();
    System.out.println("=====");
    
  }
}
