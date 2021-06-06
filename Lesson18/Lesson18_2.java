public class Lesson18_2 {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        int[] ids = {30, 22, 14, 26, 7, 19, 23, 35, 31, 33, 48};
        String[] datas = {"lemon", "apple", "orange", "banana", "cherry", "peach", "grape", "cassis", "pineapple", "melon", "kiwi"};

        for (int i = 0; i < ids.length; i++) {
          insert(tree, new MyData(ids[i], datas[i]));
        }

        System.out.println();

        System.out.println();

        tree.showTree();
        System.out.println();

        tree.removeLevel(2);

        System.out.println("==== Remove Level 2 ====");
        tree.showTree();
    }

    private static void insert(BinarySearchTree tree, MyData myData) {
        System.out.println("Insert: " + myData);
        tree.insert(myData);
    }
}
