import java.util.Scanner;
public class Calc {
  public static void calc() {
    // =============== ここに追加 ===================
    System.out.print("> ");
    Scanner scan = new Scanner(System.in);
    String input1Str = scan.next();
    String input2Str = scan.next();
    int input1 = Integer.parseInt(input1Str);
    int input2 = Integer.parseInt(input2Str);

    int result = input1 + input2;
    System.out.println(input1 + " + " + input2 + " = " + result);
    result = input1 - input2;
    System.out.println(input1 + " - " + input2 + " = " + result);
    result = input1 * input2;
    System.out.println(input1 + " * " + input2 + " = " + result);
    result = input1 / input2;
    System.out.println(input1 + " / " + input2 + " = " + result);

    // ============================================
  }
}
