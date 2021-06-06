public class Lesson05_1{
	public static void main(String[] args) {
		int[] arr = new int[args.length];
		for (int i = 0; i < arr.length; i++) {
			arr[i]=Integer.parseInt(args[i]);
		}
		ArrayCal cal = new ArrayCal();
		cal.name="Array";
		cal.add(arr);
		cal.mul(arr);
		cal.output();
		return ;
	}
}
