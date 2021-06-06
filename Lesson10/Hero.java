public class Hero extends Human {
  Hero(String name, int hp, int atk) {
    super(name, hp, atk);
  }

  // Add here (Lesson10_2)
  public void check(Checkable ch){
    ch.beChecked();
  }
  // Add here (Lesson10_4)
  public void encount(Character ch){
    if(ch instanceof Human){
      Human hu = (Human)ch;
      hu.talk();
    }else if(ch instanceof Monster){
      Monster mo = (Monster)ch;
      mo.battleStart();
    }
  }
}
