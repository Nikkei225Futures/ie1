public class Lesson10_4 {
  public static void main(String args[]) {
	  Hero hero = new Hero("Hiro", 150, 10);

	  System.out.println("========= encount =========");
	  Human mura1 = new Murabito("Murbaito 1", 10, 1);
	  hero.encount(mura1); // 人間(Human)とエンカウント
    
	  System.out.println();

	  System.out.println("========= encount =========");
	  Monster mo1 = new Slime("Slime 1", 10, 2);
	  hero.encount(mo1); // モンスター(Monster)とエンカウント
  }
}
