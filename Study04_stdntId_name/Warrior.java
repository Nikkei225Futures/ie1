public class Warrior extends Hero implements Member {
    // コンストラクタ
    public Warrior(String name, int hp, int atk) {
        super(name, hp, atk);
    }

    // method
    // 2倍の攻撃力で攻撃する
    public void skill(Character c) {
        System.out.println(">> " + this.getName() + "は2倍の攻撃力で" + c.getName() + "に攻撃した!");
        c.damage(this.getAtk() * TWICE);
    }
}