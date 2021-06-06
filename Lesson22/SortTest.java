public class SortTest {
    public static void main(String[] args) {
        int[] array1 = new int[10];
        for (int i = 0; i < array1.length; i++) {
            int j = (int) (Math.random() * 100);
            array1[i] = j;
        }
        // バブルソード，セレクションソート，インサートソート
        // シェルソートのコードをコメントアウトせよ
        QuickSort qs = new QuickSort(array1);
        qs.display();
        qs.quickSort(0, array1.length - 1);
        qs.display();
    }
}