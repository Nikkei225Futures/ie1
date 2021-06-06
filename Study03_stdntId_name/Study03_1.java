public class Study03_1 {
    public static void main(String[] args){

        Dog_1 dog = new Dog_1("ギン", 60, 30, 20, 20);
        Monkey_1 monkey = new Monkey_1("ゴクウ", 60, 35, 15, 20);
        
        dog.printStatus();
        monkey.printStatus();

        int turn = 1;
        while(true){
            System.out.println("--------------- ターン " + turn + " ---------------");
            monkey.defend(dog.attack());

            if(monkey.isEnd()){
                break;
            }

            System.out.println();
            
            dog.defend(monkey.attack());
            if(dog.isEnd()){
                break;
            }

            turn++;
        }
        
    }
}