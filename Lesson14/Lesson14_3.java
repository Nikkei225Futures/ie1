public class Lesson14_3 {
	public static void main(String[] args) {
		SimpleLinkedList list = new SimpleLinkedList();
		list.insert(1, "E");
		list.insert(1, "D");
		list.insert(1, "C");
		list.insert(1, "B");
		list.insert(1, "A");
		list.printAll();

		System.out.println("remove Element: B");
		list.remove(new String("B"));
		list.printAll();
		System.out.println("Legnth: " + list.getLength());
		System.out.println("remove Element: X");
		list.remove(new String("X"));
		System.out.println("Legnth: " + list.getLength());		
	}
}
