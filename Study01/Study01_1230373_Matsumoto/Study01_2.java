public class Study01_2 {
    public static void main(String[] args){
        int n = Integer.parseInt(args[0]);
        int i, j;

        //コマンドライン引数の個数の文字列の配列を作成&初期化
        String output[] = new String[2*n];
        for(i = 0; i < 2*n; i++){
            output[i] = "";
        }

        //*の前に入るスペースの数は中間でn-1個、中間で0個
        //*の後に入るスペースの数は最初は0、その後は奇数個のスペースが入る

        //各行の文字列の前方にスペースを挿入し、その後に*を付ける(半分まで)
        int centerOfIndex = 0;
        for(i = n-1, j = 0; i >= 0; i--, j++){
            output[j] = addSpc(i);
            output[j] += "*";

            //空白が0の時の配列の要素を中心とする
            if(i == 0){
               centerOfIndex = j; 
            }
        }

        //1つ目の*の後に入る空白を加えて2つ目の*を付ける
        for(i = 1, j = 1; i <= centerOfIndex; i++, j += 2){
            output[i] = addSpc(j, output[i]);
            output[i] += "*";
        }

        //配列の要素の中心までを中心以降へコピーする
        for(i = 1, j = centerOfIndex+1; i <= centerOfIndex; i++, j++){
            output[j] = output[centerOfIndex-i];
        }

        //配列全体を出力
        for(i = 0; i < output.length; i++){
            System.out.println(output[i]);
        }
    }

    //前半のスペースを加える
    public static String addSpc(int n){
        String str = "";
        for(int i = 0; i < n; i++){
            str += " ";
        }
        return str;
    }

    //中間のスペースを追加する
    public static String addSpc(int n, String string){
        String str = string;
        for(int i = 0; i < n; i++){
            str += " ";
        }
        return str;
    }
}