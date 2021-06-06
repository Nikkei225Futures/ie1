public class Drink {
    private String name;
    private int value;
    public Drink(String name, int value){
        this.name = name;
        this.value = value;
    }
    
    //getter
    public String getName(){
        return this.name;
    }
    
    public int getValue(){
        return this.value;
    }
    
}