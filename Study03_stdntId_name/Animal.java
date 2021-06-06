public class Animal{
    private int hp, pow, def, initHp;
    private String name;
    private boolean flag = false;

    //コンストラクタ
    public Animal(String name, int hp, int power, int defence){
        this.name = name;
        this.hp = hp;
        this.pow = power;
        this.def = defence;
        this.initHp = hp;
    }

    //methods
    public int attack(){
        System.out.println(this.name + "の攻撃!");
        return this.pow;
    }

    public void defend(int damage){
        //ダメージ計算
        damage -= this.def;
        this.hp -= damage;
        //HPが0になった時
        if(this.hp <= 0){
            System.out.println(this.name + "は" + damage + "のダメージを受けた!(0" + "/" + this.initHp + ")");
            System.out.println(this.name + "のHPが0になった!");
            this.flag = true;
        
        //それ以外    
        }else{
            System.out.println(this.name + "は" + damage + "のダメージを受けた!(" + this.hp + "/" + this.initHp + ")");
        }
    }

    public void printStatus(){
        System.out.println("[" + this.name + "]");
        System.out.println("HP: " + this.hp);
        System.out.println("攻撃力: " + this.pow);
        System.out.println("防御力: " + this.def);
    }

    //getter
    public String getName(){
        return this.name;
    }

    public int getHp(){
        return this.hp;
    }

    public int getPower(){
        return this.pow;
    }

    public int getDefence(){
        return this.def;
    }

    public boolean isEnd(){
        return this.flag;
    }

}