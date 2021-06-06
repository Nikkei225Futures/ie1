class ShellSort {
    // フィールド
    private int[] sort_array;

    //課題2 フィールド
    private int assignCount = 0;
    private int compareCount = 0;

    //課題3 フィールド
    protected long timeStart;
    protected long timeStop;

    // コンストラクタ
    private ShellSort() {

    }

    public ShellSort(int[] sort_array) {
        this.sort_array = sort_array;
    }

    // メソッド
    public void display() {
        for (int i = 0; i < this.sort_array.length; i++)
            System.out.print(this.sort_array[i] + " ");
        System.out.println();
    }

    public void shellSort() {
        int in, out, temp, h;
        h = 1;
        while (h < this.sort_array.length / 3)
            h = h * 3 + 1; // Knuth's interval sequence
        while (h > 0) {
            System.out.println("h = " + h);
            // 動作確認用
            for (out = h; out < this.sort_array.length; out++) {
                temp = this.sort_array[out];
                this.assignCount++;
                in = out;
                //while (in > h - 1 && this.sort_array[in - h] > temp) {
                while(in > h - 1 && this.compareValue(this.sort_array[in - h], temp) == 1){
                    this.sort_array[in] = this.sort_array[in - h];
                    this.assignCount++;
                    in -= h; // in = in –h;
                }
                this.sort_array[in] = temp;
                this.assignCount++;
                //this.display();
                // 動作確認用
            }
            h = (h - 1) / 3;
            // Knuth's interval sequence
        }
    }

    //課題2 メソッド
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

    public int getAssignCount(){
        return this.assignCount;
    }

    public int getCompareCount(){
        return this.compareCount;
    }

    public boolean checkSort(){
        for(int i = 1; i < this.sort_array.length; i++){
            if(this.sort_array[i] < this.sort_array[i-1]){
                return false;
            }
        }
        return true;
    }

    //課題3 メソッド
    public void startTimer(){
        this.timeStart = System.nanoTime();
    }

    public void stopTimer(){
        this.timeStop = System.nanoTime();
    }

    public long getSortTime(){
        return this.timeStop - this.timeStart;
    }
}
