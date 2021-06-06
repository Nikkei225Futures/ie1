public class Hero extends Character implements CharInfo, Critical{
    //-------フィールド-------
    //add here
    private int atk;
    private int hp;
    //-------コンストラクタ-------
    //add here
    public Hero(String name, int hp, int atk){
        super(name, hp);
        this.atk = atk;
        this.hp = hp;
    }
    //-------メソッド-------
    //add here
    public int getAtk(){
        return this.atk;
    }

    public void attack(Enemy enemy){
        System.out.println(this.getName() + "の攻撃!");
        System.out.println(this.getName() + "は" + enemy.getName() + "に" + this.atk + "のダメージを与えた!");
        enemy.damage(this.atk);
        System.out.println(enemy.getName() + "の残りHPは" + enemy.getHp());
    }

    public void criticalAttack(Enemy enemy){
        System.out.println(this.getName() + "の攻撃!");
        System.out.println("クリティカルヒット!");
        System.out.println(this.getName() + "は" + enemy.getName() + "に" + calcCritical(this.atk) + "のダメージを与えた!");
        enemy.damage(calcCritical(this.atk));
        System.out.println(enemy.getName() + "の残りHPは" + enemy.getHp());
    }

    public void printName(){
        System.out.println("プレイヤーのキャラクターは" + this.getName() + "だ!");
    }
    
    public void showStatus(){
        System.out.println("HP: " + this.getHp());
        System.out.println("ATK: " + this.getAtk());
    }
    
}
