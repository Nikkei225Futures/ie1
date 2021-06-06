public class Study02{
    public static void main(String[] args) {
        //飲み物の定義と飲み物の登録
        Drink greentea = new Drink("お茶", 130);
        Drink coke     = new Drink("コーラ", 160);
        Drink soda     = new Drink("ソーダ", 160);
        Drink tea      = new Drink("紅茶", 150);
        Drink coffee   = new Drink("コーヒー", 110);

        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.registDrink(1, greentea);
        vendingMachine.registDrink(2, coke);
        vendingMachine.registDrink(3, soda);
        //vendingMachine.registDrink(4, tea);
        vendingMachine.registDrink(5, coffee);
        vendingMachine.printInfo();

        //操作
        while(true){
            System.out.println("行いたい操作を指定してください");
            int processNum = waitInput("(1:お金の投入, 2:飲み物の購入, 3:お釣りの出力, 4:終了)");

            if(processNum == 1){
                int money = waitInput("投入する金額を指定してください");
                vendingMachine.insertMoney(money);
            
            }else if(processNum == 2){
                int index = waitInput("購入する飲み物の番号を指定してください");
                vendingMachine.buyDrink(index);
            
            }else if(processNum == 3){
                vendingMachine.returnMoney();
            
            }else if(processNum == 4){
                break;
            }
        }
    }

    //display = 指示
    public static int waitInput(String display){
        System.out.println(display);
        System.out.print("> ");
        int input = new java.util.Scanner(System.in).nextInt();
        return input;
    }
}