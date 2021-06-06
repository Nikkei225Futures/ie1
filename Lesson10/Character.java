public abstract class Character {
  protected int hp;
  protected String name;
  protected int atk;
  public Character(String name, int hp, int atk) {
    this.name = name;
	  this.hp = hp;
	  this.atk = atk;
  }

  abstract void showStatus();

  public void damage(int atk) {
    if (atk > this.hp) {
      System.out.println("\t" + this.name + " へ " + this.hp + " のダメージ !");
	    this.hp = 0;
	    System.out.println("\t" + this.name + " は力尽きた．");
	  } else {
	    System.out.println("\t" + this.name + " へ " + atk + " のダメージ !");
	    this.hp -= atk;
	    System.out.println("\t" + this.name + " の残りHP " + this.hp);
	  }
  }
}
