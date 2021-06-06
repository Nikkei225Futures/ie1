public class Lesson17_4 {
  public static void main(String[] args) {
    BinarySearchTree tree = new BinarySearchTree();

    insert(tree, new MyData(35, "lemon"));
    insert(tree, new MyData(17, "apple"));
    insert(tree, new MyData(69, "orange"));
    insert(tree, new MyData(21, "banana"));
    insert(tree, new MyData(38, "cherry"));
    insert(tree, new MyData(75, "peach"));
	  insert(tree, new MyData(79, "grape"));

	  System.out.println();

	  System.out.println("========== Binary Search Tree ==========");
	  tree.showTree();
  }

  private static void insert(BinarySearchTree tree, MyData myData) {
    System.out.println("Insert: " + myData);
    tree.insert(myData);
  }
}
