public class Lesson14_2 {
	public static void main(String[] args) {
		SimpleLinkedList list = new SimpleLinkedList();
		list.insert(1, "E");
		list.insert(1, "D");
		list.insert(1, "C");
		list.insert(1, "B");
		list.insert(1, "A");
		list.printAll();
		
		System.out.println("Legnth: " + list.getLength());
		System.out.println("search element C");
		System.out.println("index of C: " + list.search(new String("C")));

		System.out.println("search element X");
		System.out.println("index of X: " + list.search(new String("X")));
	}
}
