public class Enemy extends Character {
    // コンストラクタ
    public Enemy(String name, int hp, int atk) {
        super(name, hp, atk);
    }

    // 勇者のパーティ全員にatk分のダメージを与える
    public void attack(Hero[] party) {
        System.out.println(">> " + this.getName() + "の全体攻撃!");
        for (int i = 0; i < party.length; i++) {
            party[i].damage(this.getAtk());
        }
    }

    // キャラクターの保持する情報を出力
    public void showStatus() {
        System.out.println(this.getName() + "が現れた!");
        super.showStatus();
    }
}