public class Lottery {
	public void draw() {
		int rnd = new java.util.Random().nextInt(100);
		if(rnd < 2) {
			System.out.println("１等！！！");
		} else if (2 <= rnd && rnd < 22) {
			System.out.println("２等！！");
		} else if (22 <= rnd && rnd < 52) {
			System.out.println("３等！");
		} else {
			System.out.println("４等");
		}
	}
}