public class HyperLottery extends Lottery{
	public void draw() {
		super.draw();
		int luckyRnd = new java.util.Random().nextInt(100);
		if(luckyRnd < 50) {
			super.draw();
		}
	}
}