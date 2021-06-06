public class Study01_5 {
    public static void main(String[] args){
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int i;
        //1000以下の素数は168個であるから、配列のサイズは168 + 終端検知用の0 = 169
        int primeNums[] = new int[169];
        for(i = 0; i < primeNums.length; i++){
            primeNums[i] = 0;
        }
        int j = 0;
        
        //Aが1以下なら判定範囲を2に引き上げる
        int start;
        if(a <= 1){
            start = 2;
        }else{
            start = a;
        }

        //a <= bの素数を配列に入れる
        for(i = start; i <= b; i++){
            if(isPrime(i)){
                primeNums[j] = i;
                j++;
            }
        }

        //素数の出力
        i = 0;
        System.out.printf("============%4dから%4dまでの素数=============", a, b);
        System.out.println("");
        while(primeNums[i] != 0){
            if(i != 0 && i % 12 == 0){
                System.out.println("");
            }
            System.out.printf("%3d ", primeNums[i]);
            i++;
        }
        System.out.println("");
        System.out.print("===============================================");
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