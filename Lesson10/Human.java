public class Human extends Character {
  public Human(String name, int hp, int atk) {
	  super(name, hp, atk);
  }

  protected void showStatus() {
    System.out.println("[ " + name + " ]");
	  System.out.println("  HP:" + this.hp);
	  System.out.println("  ATK:" + this.atk);
  }

  public void attack(Monster mo) {
	  System.out.println(this.name + "の攻撃 !");
	  mo.damage(this.atk);
	  return;
  }

  public void talk() {
	  System.out.println(this.name + ": お疲れさまです．");
  }
}
