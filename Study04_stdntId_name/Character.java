abstract class Character {
    // フィールド定義
    private String name;
    private int hp, atk, initAtk, initHp;

    // コンストラクタ
    public Character(String name, int hp, int atk) {
        this.name = name;
        this.hp = hp;
        this.atk = atk;
        this.initAtk = atk;
        this.initHp = hp;
    }

    // methods
    // atk分の値のダメージを受ける
    public void damage(int atk) {
        if(this.hp == 0){
            System.out.println(this.getName() + "は倒れている!");
            return;
        }

        this.hp -= atk;
        // hpが0以下になったら0に戻す
        if (this.hp <= 0) {
            this.hp = 0;
            System.out.println(this.getName() + "は倒れた!");
        } else {
            System.out.println(this.name + "の残り HP: " + this.hp);
        }
    }

    // 指定されたキャラクターに攻撃
    public void attack(Character c) {
        System.out.println(">> " + this.name + "の攻撃!");
        c.damage(this.atk);
    }

    // キャラクターの保持する情報を出力
    public void showStatus() {
        System.out.println(this.name + "のステータス HP: " + this.hp + " ATK: " + this.atk);
    }

    // getter
    public int getAtk() {
        return this.atk;
    }

    public int getHp() {
        return this.hp;
    }

    public String getName() {
        return this.name;
    }

    public int getInitHp() {
        return this.initHp;
    }

    public int getInitAtk() {
        return this.initAtk;
    }

    // setter
    public void setAtk(int atk) {
        this.atk = atk;
    }

    public void setHp(int hp) {
        // 最大HPを超えていないか
        if (hp <= this.initHp) {
            this.hp = hp;
        } else {
            System.out.println("invalid argument (argument hp is over initial hp)");
        }
    }

}