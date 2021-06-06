public class Lesson04_4 {
  public static void main(String[] args) {
    int left = Integer.parseInt(args[0]);
    int right = Integer.parseInt(args[1]);
    // add here
    Binary bin = new Binary();
    bin.num1 = left;
    bin.num2 = right;

    int and = bin.and();
    int exOR = bin.exclusiveOR();

    System.out.println("AND: " + and);
    System.out.println("Exclusive OR: " + exOR);
  }
}
