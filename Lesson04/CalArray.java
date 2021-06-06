public class CalArray {
  String name;
  private int sum = 0;
  private int mul = 1;

  //name，sum，mulを表示する
  public void output() {
    System.out.println(" [ " + this.name + " ] ");
    System.out.println("sum : " + this.sum);
    System.out.println("mul : " + this.mul);
  }

  //呼び出されたときsumに数値を足していく
  public void add(int[] array) {
    for(int i = 0; i < array.length; i++){
      this.sum = this.sum + array[i];
    }
  }

  //呼び出されたときmulに数値をかけていく
  public void mul(int[] array) {
    for(int i = 0; i < array.length; i++){
      this.mul = this.mul * array[i];
    }
  }
}
