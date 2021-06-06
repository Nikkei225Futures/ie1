class InsertionSortX {
    //フィールド
    private int[] sort_array;

    //課題2 フィールド
    private int assignCount = 0;
    private int compareCount = 0;

    //課題3 フィールド
    protected long timeStart;
    protected long timeStop;

    //コンストラクタ
    private InsertionSortX() {

    }
    
    public InsertionSortX(int[] sort_array) {
        this.sort_array = sort_array;
    }
    
    //メソッド
    public void display() {
        for (int i = 0; i< this.sort_array.length; i++) 
        System.out.print(this.sort_array[i] + " ");
        System.out.println();
    }

    public void insertionSortX() {
        int in, out, temp;
        for (out = 1; out < this.sort_array.length; out++) {
            temp = this.sort_array[out];
            this.assignCount++;
            in = out;
            // もし
            //while (in > 0 && this.sort_array[in - 1] > temp) {
            while(in > 0 && this.compareValue(this.sort_array[in - 1], temp) == 1){
                this.sort_array[in] = this.sort_array[in - 1];
                this.assignCount++;
                in--;
            }
            this.sort_array[in] = temp;
            this.assignCount++;
            //this.display();
            // 動作確認用
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
