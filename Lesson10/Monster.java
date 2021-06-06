public class Monster extends Character {
  public Monster(String name, int hp, int atk) {
	  super(name, hp, atk);
  }

  public void showStatus() {
	  System.out.println("[ " + name + " ]");
	  System.out.println("HP: " + this.hp);
  }

  public void attack(Human hu) {
	  System.out.println(this.name + "の攻撃 !");
	  hu.damage(this.atk);
	  return;
  }

  public void battleStart() {
	  System.out.println(this.name + " が現れた !");
  }
}
