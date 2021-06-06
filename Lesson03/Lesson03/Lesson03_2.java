public class Lesson03_2 {

    public static void main(String[] args) {
        int n = 0;
        java.util.Scanner scan = new java.util.Scanner(System.in);

        while (true) {
            // add here
            System.out.print("数値を入力してください: ");
            int x = scan.nextInt();
            // add here
            if(x == 0){
                break;
            }
            n += x;
            System.out.println(n);
        }
    }
}
