class SelectionSort {
    // フィールド
    private int[] sort_array;
    protected long timeStart;
    protected long timeStop;
    protected int assignCount = 0;
    protected int compareCount = 0;

    // コンストラクタ
    private SelectionSort() {

    }

    public SelectionSort(int[] sort_array) {
        this.sort_array = sort_array;
    }

    // メソッド
    public void display() {
        for (int i = 0; i < this.sort_array.length; i++)
            System.out.print(this.sort_array[i] + " ");
        System.out.println();
    }

    public void swap(int x, int y) {
        int temp = this.sort_array[x];
        this.sort_array[x] = this.sort_array[y];
        this.sort_array[y] = temp;
        this.assignCount += 3;
    }

    public void selectionSort() {
        int out, in, min;
        for (out = 0; out < this.sort_array.length - 1; out++) {
            min = out;
            for (in = out + 1; in < this.sort_array.length; in++) {
                // if (this.sort_array[in] < this.sort_array[min]) {
                if (this.compareValue(this.sort_array[in], this.sort_array[min]) == -1) {
                    min = in;
                }
            }
            this.swap(out, min);
            // this.display() // 途中経過を表示
        }
    }

    public boolean checkSort() {
        for (int i = 1; i < this.sort_array.length; i++) {
            if (this.sort_array[i] < this.sort_array[i - 1]) {
                return false;
            }
        }
        return true;
    }

    public void startTimer() {
        this.timeStart = System.nanoTime();
    }

    public void stopTimer() {
        this.timeStop = System.nanoTime();
    }

    public long getSortTime() {
        return this.timeStop - this.timeStart;
    }

    public int getAssignCount() {
        return this.assignCount;
    }

    protected int compareValue(int n1, int n2) {
        this.compareCount++;
        if (n1 > n2) {
            return 1;
        } else if (n1 < n2) {
            return -1;
        } else {
            return 0;
        }
    }

    public int getCompareCount() {
        return this.compareCount;
    }
}
