public class Lesson02_1 {
	public static void main(String[] args) {
		int[] array = {1, 3, 5, 7, 9, 11};
		System.out.println("配列の長さ: " + array.length);
		System.out.print("配列の要素: ");
		for(int i = 0; i < array.length; i++){
			System.out.print(array[i] + " ");
		}
	}
}
