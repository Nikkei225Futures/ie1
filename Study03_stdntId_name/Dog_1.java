import java.util.Random;

public class Dog_1 {
    //フィールドの定義
    private int hp, pow, def, crt, initHp;
    private String name;
    private boolean flag = false;

    //コンストラクタ
    public Dog_1(String name, int hp, int power, int defence, int critical){
        this.name = name;
        this.hp = hp;
        this.pow = power;
        this.def = defence;
        this.crt = critical;
        this.initHp = hp;
    }

    //methods
    public int attack(){
        System.out.println(this.name + "の攻撃!");

        //乱数生成
        Random r = new Random();
        int num = r.nextInt(100);
        
        //critical
        if(num < this.crt){
            System.out.println(this.name + "は強く噛み付いた!");
            return (int)(Math.floor(this.pow * 1.5));
        }

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

    //ステータスを表示
    public void printStatus(){
        System.out.println("[" + this.name + "]");
        System.out.println("HP: " + this.hp);
        System.out.println("攻撃力: " + this.pow);
        System.out.println("防御力: " + this.def);
        System.out.println("会心率: " + this.crt);
        System.out.println();
    }

    //終了したかどうか, getter
    public boolean isEnd(){
        return this.flag;
    }
    
}