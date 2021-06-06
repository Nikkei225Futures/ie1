public class Lesson06_2 {
	public static void main(String[] args) {
		Book book1 = new Book();
		Book book2 = new Book();
		Book book3 = new Book();
		Book book4 = new Book();
		Book book5 = new Book("教育情報工学とは", "妻鳥貴彦先生", 1230);

		// add here
		book1.printData();
		book2.printData();
		book3.printData();
		book4.printData();
		book5.printData();
		System.out.println("生成されたインスタンス: " + Book.getCount());
	}
}
