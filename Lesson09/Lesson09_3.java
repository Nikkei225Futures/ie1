public class Lesson09_3 {
	public static void main(String[] args) {
		Hero hero=new Hero("勇者",100,16);
		Enemy enemy=new Enemy("スライム",50,5);
		hero.printName();
		hero.showStatus();
		enemy.printName();
		enemy.showStatus();
		hero.criticalAttack(enemy);
	}
}
