public class Lesson06_3 {
	public static void main(String[] args) {
		Book book = new Book();

		// add here
		book.setTitle("ゲーム情報学とは");
		book.setAuthor("竹内聖悟先生");
		System.out.println("書籍名: " + book.getTitle());
		System.out.println("著者: " + book.getAuthor());
	}	
}
