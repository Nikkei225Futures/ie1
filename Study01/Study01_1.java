public class Study01_1 {
    public static void main(String[] args){
        int i;      //ループカウンタ用変数
        int input;  //入力された文字列の変換先

        //コマンドライン引数と同じ個数の各文字列の長さを格納するための配列を作成
        int lenArgs[] = new int[args.length];
        for(i = 0; i < args.length; i++){
            lenArgs[i] = args[i].length();
        }


        while(true){        
            //文字列を入力
            System.out.println("正の整数もしくはexitを入力して下さい.");
            System.out.print("> ");
            String str = new java.util.Scanner(System.in).next();

            //文字列が"exit"なら終了、それ以外ならintへキャスト
            if(str.equals("exit")){
                break;
            }else{
                input = Integer.parseInt(str);
            }

            //入力された数値が各文字列の長さと一致すれば、同じインデックスのコマンドライン引数を出力
            for(i = 0; i < args.length; i++){
                if(input == lenArgs[i]){
                    System.out.println(args[i]);
                }
            }
        }
    }
}