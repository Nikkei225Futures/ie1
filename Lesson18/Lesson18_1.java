public class Lesson18_1 {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        int[] ids = {40, 24, 15, 33, 36, 20, 9, 60, 52, 55, 70, 73, 85};
        String[] datas = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M"};

        for (int i = 0; i < ids.length; i++) {
          insert(tree, new MyData(ids[i], datas[i]));
        }

        System.out.println();

        System.out.println();

        System.out.println("===== traverse in-order =====");
        tree.printTreeInOrder();

        System.out.println("===== traverse pre-order =====");
        tree.printTreePreOrder();

        System.out.println("===== traverse post-order =====");
        tree.printTreePostOrder();

        System.out.println("===== traverse descending-order =====");
        tree.printTreeDesc();
    }

    private static void insert(BinarySearchTree tree, MyData myData) {
        System.out.println("Insert: " + myData);
        tree.insert(myData);
    }
}
