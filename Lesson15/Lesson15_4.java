public class Lesson15_4 {
    public static void main(String[] args) {
        DoublyLinkedList list1 = new DoublyLinkedList();
        list1.insert(1, "A");
        list1.insert(2, "B");
        list1.insert(3, "C");
        list1.insert(4, "D");
        list1.insert(5, "E");
        System.out.println("/*   list1   */");
        list1.printAll();
	
	System.out.println("---------listをcopyをする場合-------------");
        System.out.println("Split list1 at 2.");
        DoublyLinkedList copylist2 = list1.copysplit(2);
        System.out.println("/*   list1   */");
        list1.printAll();
        System.out.println("/*   list2   */");
        copylist2.printAll();

	System.out.println("Split list2 at 3.");
        DoublyLinkedList copylist3 = copylist2.copysplit(3);
        System.out.println("/*   list2   */");
        copylist2.printAll();
        System.out.println("/*   list3   */");
        copylist3.printAll();	
	System.out.println("---------------------------------------");
	
	System.out.println("---------listをcopyしない場合-------------");
	System.out.println("Split list1 at 2.");
        DoublyLinkedList list2 = list1.split(2);
        System.out.println("/*   list1   */");
        list1.printAll();
        System.out.println("/*   list2   */");
        list2.printAll();

        System.out.println("Split list2 at 3.");
        DoublyLinkedList list3 = list2.split(3);
        System.out.println("/*   list2   */");
        list2.printAll();
        System.out.println("/*   list3   */");	
	System.out.println("---------------------------------------");
    }
}
