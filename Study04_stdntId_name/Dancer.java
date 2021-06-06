public class Dancer extends Hero implements Member {
    // コンストラクタ
    public Dancer(String name, int hp, int atk) {
        super(name, hp, atk);
    }

    // method
    // 勇者の攻撃力を3倍にする
    public void skill(Character c) {
        c.setAtk(c.getAtk() * THRICE);
        System.out.println(">> " + this.getName() + "は" + c.getName() + "の攻撃力を3倍にした!");
        System.out.println(c.getName() + "のATK: " + c.getAtk());
    }
}