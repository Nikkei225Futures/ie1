import java.util.Random;

public class Monkey_2 extends Animal{
    private int agl;

    //コンストラクタ
    public Monkey_2(String name, int hp, int power, int defence, int agility){
        super(name, hp, power, defence);
        this.agl = agility;
    }

    //methods
    public void defend(int damage){
        //乱数生成
        Random r = new Random();
        int num = r.nextInt(100);

        //回避
        if(num < this.agl){
            System.out.println("しかし、" + this.getName() + "は素早く回避した");
            return;
        }else{
            super.defend(damage);
        }
    }

    //ステータスを表示
    public void printStatus(){
        super.printStatus();
        System.out.println("回避率: " + this.agl);
        System.out.println();
    }

}