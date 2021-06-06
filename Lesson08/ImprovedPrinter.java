public class ImprovedPrinter extends Printer {
	/* --- Lesson08_5 ここから --- */
	public ImprovedPrinter(int paper, int ink){
   super(paper, ink);
  }

  public ImprovedPrinter(int battery, int paper, int ink){
    super(battery, paper, ink);
  }

  public void print(){
    this.battery *= 10;
    this.paper *= 10;
    this.ink *= 10;
    super.print();
    this.battery /= 10;
    this.paper /= 10;
    this.ink /= 10;
  }
  
  public void printColor(){
    this.battery *= 10;
    this.paper *= 10;
    this.ink *= 10;
    super.printColor();
    this.battery /= 10;
    this.paper /= 10;
    this.ink /= 10;
  }

  /* --- Lesson08_5 ここまで --- */
}
