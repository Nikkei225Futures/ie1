public class VendingMachine {
    //変数の宣言
    private String nameOfDrinks[] = new String[5];
    private int valueOfDrinks[] = new int[5];
    private int money;

    public void registDrink(int index, Drink drink){
        //index番目に既に登録されている場合
        if(this.valueOfDrinks[index-1] != 0){
            System.out.println(index + "番には既に飲み物が登録されています");

        //indexが6以上0以下の場合、登録しない
        }else if(index > 5 || index < 1){
            System.out.println("index must be less than equals to 5 or higher than 0");
            System.out.println("this process of registering in index of" + index + "was disabled");
        
        //値段と名前の配列のindex-1番目のインデックスに登録
        }else{
            this.nameOfDrinks[index-1] = drink.getName();
            this.valueOfDrinks[index-1] = drink.getValue();
            System.out.println(index + "番に「" + drink.getName() + "」を登録しました");
        }
    }

    public void insertMoney(int money){
        //-money円は投入できないので0以上の時のみ入力
        if(money >= 0){
            this.money += money;
            System.out.println(money + " 円を投入しました");
            System.out.println("現在 " + this.money + " 円入っています");
        }
        System.out.println();
    }

    public void buyDrink(int index){
        //不正な値の場合
        if(index > 5 || index < 1){
            System.out.println("index of " + index + " does not exist");

        //所持金>=飲み物の値段かつindex番の飲み物の名前がnullでない場合
        }else if(this.money >= this.valueOfDrinks[index-1] && this.nameOfDrinks[index-1] != null){
            this.money -= this.valueOfDrinks[index-1];
            System.out.println(index + "番の「" + this.nameOfDrinks[index-1] + "」を購入しました" );
        
        //所持金が足りない場合
        }else if(this.money <  this.valueOfDrinks[index-1]){
            System.out.println("購入できませんでした(お金が足りません)");
        
        //飲み物が登録されていない場合
        }else if(this.nameOfDrinks[index-1] == null){
            System.out.println("購入できませんでした(" + index + " 番には飲み物が登録されていません)");
        }
        System.out.println();
    }

    public void returnMoney(){
        System.out.println(this.money + " 円のお釣りを出力しました");
        this.money = 0;
        System.out.println();
    }

    public void printInfo(){
        //登録されている飲み物の名前と値段を出力
        System.out.println("====================================");
        System.out.println("　名前\t\t値段");
        for(int i = 0; i < this.valueOfDrinks.length; i++){

            //飲み物が登録されている場合
            if(this.valueOfDrinks[i] != 0){
                //水平タブの数を調整
                if(this.nameOfDrinks[i].length() < 3){
                    System.out.println(i+1 + " " + this.nameOfDrinks[i] + "\t\t" + this.valueOfDrinks[i] + "円");
                }else{
                    System.out.println(i+1 + " " + this.nameOfDrinks[i] + "\t" + this.valueOfDrinks[i] + "円");
                }

            //飲み物が登録されていない場合
            }else{
                System.out.println(i+1 + " " + " --- 未登録 ---");
            }
        }
        System.out.println("====================================");

        //現在の投入額を出力
        System.out.println("現在の投入額は" + this.money + "円です");
    }
}