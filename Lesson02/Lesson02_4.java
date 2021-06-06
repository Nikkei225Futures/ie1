public class Lesson02_4 {
	public static void main(String[] args) {
		int[] mathScores     = {47, 60, 92, 73, 69, 62, 52, 73, 89, 69};
		int[] englishScores  = {82, 45, 69, 73, 58, 59, 87, 72, 34, 50};

		System.out.println("数学");
		System.out.println("最高点: " + maxScore(mathScores) +
		                   " 最低点: " + minScore(mathScores));
		System.out.println("英語");
		System.out.println("最高点: " + maxScore(englishScores) +
		                   " 最低点: " + minScore(englishScores));
	}
	public static int maxScore(int[] array){
		int max = array[0];
		for(int i = 1; i < array.length; i++){
			if(array[i] > max){
				max = array[i];
			}
		}
		return max;
	}

	public static int minScore(int[] array){
		int min = array[0];
		for(int i = 1; i < array.length; i++){
			if(array[i] < min){
				min = array[i];
			}
		}
		return min;
	}

}
