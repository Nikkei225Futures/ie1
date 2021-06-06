public class Priest extends Hero implements Member {
    // コンストラクタ
    public Priest(String name, int hp, int atk) {
        super(name, hp, atk);
    }

    // method
    // 勇者を全回復させる。最大HPを超えてはならない
    public void skill(Character c) {
        c.setHp(c.getInitHp());
        System.out.println(">> " + this.getName() + "は" + c.getName() + "のHPを全回復させた!");
        System.out.println(c.getName() + "のHP: " + c.getHp());
    }

}