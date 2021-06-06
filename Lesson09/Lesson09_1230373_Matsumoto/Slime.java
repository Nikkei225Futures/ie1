public class Slime extends Monster {
    ///-------フィールド-------
    private String type;

    //-------コンストラクタ-------
    public Slime(String name, int hp, int level){
        super(name, hp, level);
        this.type = "Slime";
    }

    //-------メソッド-------
    
    public String getType(){
	    return this.type;
    }
    
    public void showStatus() {
        System.out.println("Name:"+this.getName());
        System.out.println("Type:"+this.getType());
        System.out.println("Level:"+this.getLevel());
        System.out.println("HP:"+this.getHp());
    }
    
    public void attack(){
	    System.out.println(this.getName() + "の攻撃");
    }
    
    public void encountMonster() {
	    System.out.println(this.getName() + "が現れた！");
    }

    public void run(){
        System.out.println(this.getName() + "は逃げ出した");
    }

}
