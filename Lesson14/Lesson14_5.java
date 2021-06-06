public class Lesson14_5 {
  public static void main(String[] args) {
    SimpleLinkedList list = new SimpleLinkedList();
    list.insert(1, "Nakamura");
    list.insert(1, "Inadome");
    list.insert(1, 4);
    list.insert(1, 3);
    list.insert(1, "T");
    list.insert(1, "U");
    list.insert(1, "K");
    list.insert(1, 2);
    list.insert(1, 1);
    list.printAll();

    System.out.println("[ list cut from 0th to 1st ]");
    list.cut(0, 1);
    System.out.println("[ list cut from 2nd to 150th ]");
    list.cut(2, 150);
    System.out.println("[ list cut from 3rd to 1st ]");
    list.cut(3, 1);

    System.out.println("[ list cut from 3th to 5th ]");
    list.cut(3, 5);
    list.printAll();
    System.out.println("length of list: " + list.getLength());

    System.out.println("[ list cut from 5th to 6th ]");
    list.cut(5, 6);
    list.printAll();
    System.out.println("length of list: " + list.getLength());
  }
}
