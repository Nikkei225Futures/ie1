public class Book {
	private String title;
	private String author;
	private int price;
	private int id;
	private static int count = -1;
	
	// add here(Lesson06_2)

	Book() {
		// add here(Lesson06_1)
		this.title = "情報学群実験第1";
		this.author = "工科大介";
		this.price = 0;
		// add here(Lesson06_2)
		this.id = getCount();
	}
	
	void printData() {
		// add here(Lesson06_2)
                
		// add here(Lesson06_1)
		System.out.println("ID: " + this.id);
		System.out.println("書籍名: " + this.title);
		System.out.println("著者: " + this.author);
		System.out.println("価格: " + this.price + "円");
		System.out.println("----------");
    }

	Book(String title, String author, int price) {
		// add here(Lesson06_2)
		this.title = title;
		this.author = author;
		this.price = price;
		this.id = getCount();
	}
	
	public static int getCount() {
		// add here(Lesson06_2)
		Book.count++;
		return Book.count;
	}
	
	// add here(Lesson06_3)
	
	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return this.title;
	}

	public void setAuthor(String author){
		this.author = author;
	}

	public String getAuthor(){
		return this.author;
	}

	public void setPrice(int price){
		this.price = price;
	}

	public int getPrice(){
		return this.price;
	}
}