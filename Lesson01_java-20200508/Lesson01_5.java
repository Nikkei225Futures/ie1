public class Lesson01_5 {
	public static void main(String args[]) {
		System.out.print("自然数を入力して下さい : ");
		int input = new java.util.Scanner(System.in).nextInt();
		for(int i = 1; i <= input; i++){
			System.out.println(i);
		}
    }
}
