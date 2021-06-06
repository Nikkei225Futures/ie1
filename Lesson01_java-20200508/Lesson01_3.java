public class Lesson01_3 {
    public static void main(String args[]){
		int n = new java.util.Random().nextInt(3);
		System.out.println("n = " + n);
		
		if(n == 0){
			System.out.println("Oki");
		}else if(n == 1){
			System.out.println("Inadome");
		}	if(n == 2){
			System.out.println("teramura");
		}
    }
}
