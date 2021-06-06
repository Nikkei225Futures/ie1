public class Study01_3 {
    public static void main(String[] args){
        int n = Integer.parseInt(args[0]);
        System.out.println("input = " + n);
        //1000以下の素数を全て配列に入れる(1000以下の素数は168個であるから、配列のサイズは168)
        int primeNums[] = new int[168];
        int j = 0;
        for(int i = 2; i <= 1000; i++){
            if(isPrime(i)){
                primeNums[j] = i;
                j++;
            }
        }

        //素数の配列の要素の出現回数を保存する配列を作成&初期化
        int appearances[] = new int[168];
        for(int i = 0; i < appearances.length; i++){
            appearances[i] = 0;
        }

        //入力が1なら終了
        if(n == 1){
            System.out.print("1 = 1");
            System.exit(0);
        
        //入力がそもそも素数なら入力を出力
        }else if(isPrime(n)){
            System.out.print(args[0] + " = " + n + "^1");
            System.exit(0);

        //素因数分解
        }else{
            //素数になるまで素因数分解, 素数の出現回数を記録
            while(isPrime(n) == false){

                int index = findDivisibleMinPrime(n, primeNums);  //appearances, primeNumsのインデックス
                appearances[index] ++;
                n /= primeNums[index];
            }

            //余った素数を出現回数に加算
            for(int i = 0; i < primeNums.length; i++){
                if(n == primeNums[i]){
                    appearances[i] ++;
                }
            }

            //結果を出力
            System.out.print(args[0] + " = ");
            for(int i = 0; i < primeNums.length; i++){
                if(appearances[i] == 0){
                    continue;
                }
                
                System.out.print(primeNums[i] + "^" + appearances[i]);
                
                if(primeNums[i] != n){
                    System.out.print(" * ");
                }        
            }
        }
    }

    //入力が割り切れる最小の素数を探索
    public static int findDivisibleMinPrime(int n, int[] primeNums){
        int i = 0;
        for(i = 0; i < primeNums.length; i++){
            if(n % primeNums[i] == 0){
                return i;
            }
        }
        return i;
    }

    //素数かどうかを判定
    public static boolean isPrime(int n) {
        for(int i = 2; i < n; i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
}