public abstract class Character {
    //-------フィールド-------
    private int hp;
    private String name;
    
    //-------コンストラクタ-------
    public Character(String name, int hp){
	this.name = name;
	this.hp = hp;
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
    
    public abstract void printName();
}
