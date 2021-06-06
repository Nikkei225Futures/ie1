public class Lesson06_4 {
	public static void main(String[] args) {
		Book book1 = new Book("スッキリわかるJava入門", "中山きよたか", 3500);
		Book book2 = new Book("入門bash", "キャメロン・ニューハム", 3000);
		Book book3 = new Book("詳解シェルスクリプト", "ネルソン・H.F.ベーブ", 3200);
		
		// add here
		Store store = new Store(50000);
		store.purchase(book3);
		store.getMoney();
		store.sell(book1);
		store.getMoney();
		store.sell(book2);
		store.getMoney();
	}
}
