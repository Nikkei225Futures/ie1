import java.util.Random;

public class Dog_2 extends Animal{
    private int crt;

    public Dog_2(String name, int hp, int power, int defence, int critical){
        super(name, hp, power, defence);
        this.crt = critical;
    }

    public int attack(){
        Random r = new Random();
        int num = r.nextInt(100);
        
        //critical 
        if(num < this.crt){
            int dmg = super.attack();
            System.out.println(this.getName() + "は強く噛み付いた!");
            return (int)(Math.floor(dmg * 1.5));
        }else{
            return super.attack();
        }
    }

    //ステータスを表示
    public void printStatus(){
        super.printStatus();
        System.out.println("会心率: " + this.crt);
        System.out.println();
    }
}