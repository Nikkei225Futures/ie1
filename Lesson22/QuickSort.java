class QuickSort {
    // フィールド
    private int[] sort_array;

    // コンストラクタ
    private QuickSort() {
    }

    public QuickSort(int[] sort_array) {
        this.sort_array = sort_array;
    }

    // メソッド
    public void display() {
        for (int i = 0; i < sort_array.length; i++)
            System.out.print(sort_array[i] + " ");
        System.out.println();
    }

    public void swap(int i, int j) {
        int temp = this.sort_array[i];
        this.sort_array[i] = this.sort_array[j];
        this.sort_array[j] = temp;
    }

    public void quickSort(int from, int to) {
        if (from >= to)
            return;// 基底条件（base case）
        int pivot = this.sort_array[(from + to) / 2];
        System.out.print("pivot = " + pivot); // 動作確認用
        int left = from;
        int right = to;
        // 以下のprintlnは動作確認用
        System.out.println(", from = " + from + ", to " + to);
        while (left <= right) {
            while (this.sort_array[left] < pivot)
                left++;
            while (this.sort_array[right] > pivot)
                right--;
            if (left <= right) {
                this.swap(left, right);
                this.display(); // 動作確認用
                left++;
                right--;
            }
        }
        this.quickSort(from, right);
        this.quickSort(left, to);
    }

}