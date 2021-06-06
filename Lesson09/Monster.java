public abstract class Monster {
    //-------フィールド-------
    private int hp;
    private String name;
    private int level;
    
    //-------コンストラクタ-------
    public Monster(String name, int hp, int level){
        this.name = name;
        this.hp = hp;
        this.level = level;
    }
    
    //-------メソッド-------
    public void damage(int atk) {
	if (atk > this.hp)
	    this.hp = 0;
	else
	    this.hp -= atk;
    }
    
    public String getName(){
	    return this.name;
    }
    
    public int getHp(){
	    return this.hp;
    }
    
    public int getLevel(){
	    return this.level;
    }
    
    public abstract void encountMonster();
}
