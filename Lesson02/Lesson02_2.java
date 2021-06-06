public class Lesson02_2 {
	public static void main(String[] args) {
		int[] scores = {37, 69, 100, 46, 95, 70, 92, 53, 84, 61};
		int highest = scores[0];
		int lowest = scores[0];
		for(int i = 1; i < scores.length; i++){
			if(scores[i] > highest){
				highest = scores[i];
			}else if(scores[i] < lowest){
				lowest = scores[i];
			}
		}
		System.out.println("最高点: " + highest);
		System.out.println("最低点: " + lowest);
	}
}
