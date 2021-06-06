public class Lesson10_3 {
  public static void main(String args[]) {
		Monster[] monsters = new Monster[2];
		Human hiro = new Hero("Hiro", 120, 10);
		monsters[0] = new Slime("Slime 1", 12, 10);
		monsters[1] = new MetalSlime("Metal slime 1", 100, 100);
		System.out.println("==========  Battle Start ==========");
		hiro.attack(monsters[0]);
		for(int i = 0; i < monsters.length; i++){
			monsters[i].attack(hiro);
		}
		System.out.println("===================================");
  }
}
