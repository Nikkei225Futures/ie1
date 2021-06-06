
public class Lesson03_4 {
    
    static boolean isPrime(int n) {
        // add here
        if(n == 1){
            return false;
        }
        for(int i = 2; i < n; i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.print("数値を入力してください: ");
        int n = new java.util.Scanner(System.in).nextInt();
        if (isPrime(n)) {
            System.out.println(n + "は素数です");
        } else {
            System.out.println(n + "は素数ではありません");
        }
    }

}
