public class Lesson02_3 {
	public static void main(String[] args) {
    	int[] array = {1, 2, 3, 4, 5};
		printArray(array);

		System.out.println(0 + "番目の要素と" + 1 + "番目の要素を交換");
		swap(array, 0, 1);
		printArray(array);

		System.out.println(1 + "番目の要素と" + 3 + "番目の要素を交換");
		swap(array, 1, 3);
		printArray(array);

		System.out.println(2 + "番目の要素と" + 4 + "番目の要素を交換");
		swap(array, 2, 4);
		printArray(array);
	}

	public static void printArray(int[] array) {
		for(int i = 0; i < array.length; i++){
			System.out.print(array[i] + " ");
		}
		System.out.println("");
	}

	public static void swap(int[] array, int m, int n) {
		int tmp = array[m];
		array[m] = array[n];
		array[n] = tmp;
	}

}
