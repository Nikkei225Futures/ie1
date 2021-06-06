public class Lesson18_3 {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        int[] ids = {25, 18, 70, 22, 38, 75, 76};
        String[] datas = {"lemon", "apple", "orange", "banana", "cherry", "peach", "grape"};

        for (int i = 0; i < ids.length; i++) {
          insert(tree, new MyData(ids[i], datas[i]));
        }

        System.out.println();

        System.out.println();

        tree.showTree();
        System.out.println();

        BinarySearchTree tree2 = tree.cutTree(new MyData(70, "orange"));

      	System.out.println("/* Tree1 */");
      	tree.showTree();

      	System.out.println("/* Tree2 */");
      	tree2.showTree();
    }

    private static void insert(BinarySearchTree tree, MyData myData) {
        System.out.println("Insert: " + myData);
        tree.insert(myData);
    }
}
