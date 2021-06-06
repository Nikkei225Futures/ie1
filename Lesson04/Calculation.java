public class Calculation {
  int number;
  // add here

  public void printSqu() {
    float square = number * number;
    System.out.println("square: " + square);
  }

  public void printFac() {
    int factorial = 1;
    for(int i = 1; i <= number; i++){
      factorial *= i;
    }
    System.out.println("factorial: " + factorial);
  }

}
