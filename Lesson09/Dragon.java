public class Dragon extends Monster{
    //-------フィールド-------
    private String type;
    private int mp;

    //-------コンストラクタ-------
    public Dragon(String name, int hp, int level, int mp){
        super(name, hp, level);
        this.type = "Dragon";
        this.mp = mp;
    }

    //-------メソッド-------
    
    public String getType(){
	    return this.type;
    }

    public int getMp(){
        return this.mp;
    }
    
    public void showStatus() {
        System.out.println("Name:"+this.getName());
        System.out.println("Type:"+this.getType());
        System.out.println("Level:"+this.getLevel());
        System.out.println("HP:"+this.getHp());
        System.out.println("MP:"+this.mp);
    }
    
    public void attack(){
	    System.out.println(this.getName() + "の攻撃");
    }
    
    public void encountMonster() {
	    System.out.println(this.getName() + "が現れた！");
    }
    
}
