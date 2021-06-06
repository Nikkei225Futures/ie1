import java.util.Arrays;
import java.util.Random;

public class Lesson21_3 {
	// フィールド
	static int[] ascendingArray;  // 昇順に値が格納された配列
	static int[] descendingArray; // 降順に値が格納された配列
	static int[] randomArray;     // ランダムな値が格納された配列
	static Random random; // 乱数の種

	// メソッド
	public static void main(String[] args) {
		int arraySize = 100;  // 配列のサイズ
		long seed = 20200717;  // 乱数の種
		init(arraySize, seed); // 配列を作る
		for (int i = 0; i < 3; i++) { // ソートする配列を決める
			int[] currentArray = null; // ソートする配列
			if (i == 0) {
				currentArray = ascendingArray;
				System.out.println("=== ascending  =============================");
			} else if (i == 1) {
				currentArray = descendingArray;
				System.out.println("=== descending =============================");
			} else if (i == 2) {
				currentArray = randomArray;
				System.out.println("=== random     =============================");
			}

			InsertionSortX is = new InsertionSortX(currentArray.clone()); // 挿入ソート
			System.out.println("- InsertionSortX -");
			is.startTimer();
			is.insertionSortX(); // ソート
			is.stopTimer();
			System.out.println("Sort: " + is.checkSort());
			System.out.println("assign count: " + is.getAssignCount());
			System.out.println("compare count: " + is.getCompareCount());
			System.out.println("sort time: " + (double)is.getSortTime() / 1000000.0 + "[ms]");

			ShellSort sh = new ShellSort(currentArray.clone()); // シェルソート
			System.out.println("- ShellSort -");
			sh.startTimer();
			sh.shellSort(); // ソート
			sh.stopTimer();
			System.out.println("Sort: " + sh.checkSort());
			System.out.println("assign count: " + sh.getAssignCount());
			System.out.println("compare count: " + sh.getCompareCount());
			System.out.println("sort time: " + (double)sh.getSortTime() / 1000000.0 + "[ms]");

			OriginalShellSort osh = new OriginalShellSort(currentArray.clone()); // オリジナルシェルソート
			System.out.println("- OriginalShellSort -");
			osh.startTimer();
			osh.shellSort(); // ソート
			osh.stopTimer();
			System.out.println("Sort: " + osh.checkSort());
			System.out.println("assign count: " + osh.getAssignCount());
			System.out.println("compare count: " + osh.getCompareCount());
			System.out.println("sort time: " + (double)osh.getSortTime() / 1000000.0 + "[ms]");
		}
	}

	private static void init(int arraySize, long seed) {
		ascendingArray = new int[arraySize];
		descendingArray = new int[arraySize];
		randomArray = new int[arraySize];

		random = new Random(seed);
		ascendingArray[0] = 0;
		descendingArray[descendingArray.length - 1] = 0;
		randomArray[0] = random.nextInt(randomArray.length * 3);

		for (int i = 1; i < ascendingArray.length; i++) {
			// 1つ前より0--9大きい数
			ascendingArray[i] = ascendingArray[i-1] + random.nextInt(10);
			// 1つ後より0--9小さい数
			descendingArray[descendingArray.length - 1 - i]
			= descendingArray[descendingArray.length - i] + random.nextInt(10);
			// ランダム
			randomArray[i] = random.nextInt(randomArray.length * 3);
		}
	}
}
