public class Lesson04_5{
  public static void main(String args[]){
    int[] even = {0, 2, 4, 6, 8, 10};
    int[] odd = {1, 3, 5, 7, 9, 11};

    // add here
    CalArray ev = new CalArray();
    ev.name = "Even";
    ev.add(even);
    ev.mul(even);
    ev.output();
    CalArray od = new CalArray();
    od.name = "Odd";
    od.add(odd);
    od.mul(odd);
    od.output();
    CalArray evod = new CalArray();
    evod.name = "Even & Odd";
    evod.add(even);
    evod.add(odd);
    evod.mul(even);
    evod.mul(odd);
    evod.output();
  }
}
