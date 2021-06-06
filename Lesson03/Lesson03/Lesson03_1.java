public class Lesson03_1 {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        for(int i = 1; i <= n; i++){
            out(i);
            System.out.println("");
        }
    }
    
    public static void out(int n){
        for(int j = 0; j < n; j++){
            System.out.print("*");
        }
    }
    
}

