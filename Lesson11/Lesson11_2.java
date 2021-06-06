public class Lesson11_2 {
  public static void main(String[] args) {
    // ============ 処理の追加 ==============
    try{
      Calc.calc();
    } catch (NumberFormatException s){
      System.out.println("入力が int 型ではないため、エラーが発生しました");
    } catch (ArithmeticException e){
      System.out.println("ゼロで除算しようとしたため、エラーが発生しました");
    }
  }
}
