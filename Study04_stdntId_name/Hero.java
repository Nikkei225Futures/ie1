public class Hero extends Character {
    // フィールド定義
    private int id;
    private static int generatedInstants = 0;

    // コンストラクタ
    public Hero(String name, int hp, int atk) {
        super(name, hp, atk);
        this.id = Hero.generatedInstants;
        Hero.generatedInstants++;
    }

    // methods
    // ステータスを表示
    public void showStatus() {
        super.showStatus();
        System.out.println("ID: " + this.id);
    }

    // 攻撃力を元に戻す
    public final void resetStatus() {
        setAtk(this.getInitAtk());
    }

}