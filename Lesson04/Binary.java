public class Binary {
  // add here
  int num1, num2;

  public int and() {
    String andBin = Integer.toBinaryString(num1 & num2);
    return Integer.parseInt(andBin);
  }

  public int exclusiveOR(){
    String exORBin = Integer.toBinaryString(num1 ^ num2);
    return Integer.parseInt(exORBin);
  }
}
