public class Lesson15_2 {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.insert(1, "A");
        list.insert(2, "B");
        list.insert(3, "C");
        list.insert(4, "D");
        System.out.println("/*   list length:" + list.getLength() + "   */");
        list.printAll();
        System.out.println("/*   search   */");
        System.out.println("search \"A\" : " + list.search("A"));
        System.out.println("search \"B\" : " + list.search("B"));
        System.out.println("search \"C\" : " + list.search("C"));
        System.out.println("search \"D\" : " + list.search("D"));
        System.out.println("search \"E\" : " + list.search("E"));
        System.out.println();
    }

}
