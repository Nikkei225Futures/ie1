public class Lesson11_3 {
  public static void main(String[] args) {
    // ============ 処理の追加 ==============
    int err = 0;
    for(int i = 1; i <= 3; i++){
      try{
        System.out.println("計算を開始します(" + i + "/3)");
        Calc.calc();
      } catch (NumberFormatException s){
        System.out.println("入力が int 型ではないため、エラーが発生しました");
        err++;
      } catch (ArithmeticException e){
        System.out.println("ゼロで除算しようとしたため、エラーが発生しました");
        err++;
      } 
    }
    int nor = 3 - err;
    System.out.println("正常に動作した回数: " + nor);
    System.out.println("例外が発生した回数: " + err);
  }
}
