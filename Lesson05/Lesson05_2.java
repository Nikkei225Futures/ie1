public class Lesson05_2{
	public static void main(String[] args) {
		int num = Integer.parseInt(args[0]);
		Num cal = new Num();
		cal.num= Integer.parseInt(args[1]);
		cal.add(num);
		cal.mul(num);
		return ;
	}
}
