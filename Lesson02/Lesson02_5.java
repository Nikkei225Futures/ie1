public class Lesson02_5 {
	public static void main(String[] args) {
		int timesTables[][] = new int[9][9];
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				timesTables[i][j] = (i+1) * (j+1);
				System.out.printf("%2d ", timesTables[i][j]);
			}
			System.out.println("");
		}
	}
}
