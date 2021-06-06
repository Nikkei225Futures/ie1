public class Lesson03_3 {
    
    public static void main(String[] args) {
        
        System.out.print("数値を入力してください: ");
        int n = new java.util.Scanner(System.in).nextInt();
        long fib[] = new long[n+1];
        fib[0] = 0;
        if(n != 0){
            fib[1] = 1;   
        }
        for(int i = 2; i <= n; i++){
            fib[i] = fib[i-1] + fib[i-2];
        }
        System.out.println(n + "番目のフィボナッチ数は" + fib[n] + "です。");
    }
}
