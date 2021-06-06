public class Enemy extends Character implements CharInfo{
    //-------フィールド-------
    //add here
    private int atk;
    //-------コンストラクタ-------
    //add here
    public Enemy(String name, int hp, int atk){
        super(name, hp);
        this.atk = atk;
    }
    //-------メソッド-------
    //add here
    public int getAtk(){
        return this.atk;
    }

    public void attack(Hero hero){
        System.out.println(this.getName() + "の攻撃!");
        System.out.println(this.getName() + "は" + hero.getName() + "に" + this.atk + "のダメージを与えた!");
        hero.damage(this.atk);
        System.out.println(hero.getName() + "の残りHPは" + hero.getHp());
    }

    public void printName(){
        System.out.println("敵のプレイヤーのキャラクターは" + this.getName() + "だ!");
    }
    
    public void showStatus(){
        System.out.println("HP: " + this.getHp());
        System.out.println("ATK: " + this.getAtk());
    }
}
