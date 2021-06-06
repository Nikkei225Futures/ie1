
public class Lesson03_5 {
    
    static int countPrime(int n) {
        // add here
        int numberOfPrimes = 0;
        for(int i = 2; i <= n; i++){
            if(isPrime(i)){
                numberOfPrimes++;
            }
        }
        return numberOfPrimes;
    }

    static boolean isPrime(int n) {
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
        System.out.println(n + "以下に素数は" + countPrime(n) + "個あります．");
    }
}
