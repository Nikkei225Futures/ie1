public class Lesson15_3 {
    public static void main(String[] args) {
      DoublyLinkedList list = new DoublyLinkedList();
      list.insert(1, "A");
      list.insert(2, "garbage");
      list.insert(3, "B");
      list.insert(4, "garbage");
      list.insert(5, "C");
      list.insert(6, "garbage");
      list.insert(7, "D");
      System.out.println("/*   list with a lot of garbage   */");
      list.printAll();

      System.out.println("/*   removeGarbage   */");
      list.removeGarbage("garbage");
      list.printAll();
    }
}
