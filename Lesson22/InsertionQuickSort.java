public class InsertionQuickSort {
    private int[] sort_array;
    private int assignCount = 0;
    private int compareCount = 0;
    private int threshold;

    public InsertionQuickSort(int[] arr){
        this.sort_array = arr;
    }

    public void setThreshold(int thresh){
        this.threshold = thresh;
    }

    public void display() {
        for (int i = 0; i< this.sort_array.length; i++) 
        System.out.print(this.sort_array[i] + " ");
        System.out.println();
    }

    public void insertionQuickSort(int from, int to) {
        if (from >= to){
            return;// 基底条件（base case）
        }

        int pivot = this.sort_array[(from + to) / 2];
        //System.out.print("pivot = " + pivot); // 動作確認用
        int left = from;
        int right = to;
        // 以下のprintlnは動作確認用
        //System.out.println(", from = " + from + ", to " + to);

        if(to-from <= this.threshold){
            System.out.println("from: " + from + "   to: " + to);
            this.insertionSortX(from, to);
        }

        while (left <= right) {
            while (this.sort_array[left] < pivot){
                left++;
            }
            while (this.sort_array[right] > pivot){
                right--;
            }
            if (left <= right) {
                this.swap(left, right);
                //this.display(); // 動作確認用
                left++;
                right--;
            }
        }

        this.insertionQuickSort(from, right);
        this.insertionQuickSort(left, to);
    }


    private void insertionSortX(int from, int to) {
        int in, out, temp;
        for (out = from; out < to; out++) {
            temp = this.sort_array[out];
            this.assignCount++;
            in = out;
            // もし
            //while (in > 0 && this.sort_array[in - 1] > temp) {
            while(in > from && this.compareValue(this.sort_array[in - 1], temp) == 1){
                this.sort_array[in] = this.sort_array[in - 1];
                this.assignCount++;
                in--;
            }
            this.sort_array[in] = temp;
            this.assignCount++;
            this.display();
            
            // 動作確認用
        }
    }

    private void swap(int i, int j) {
        int temp = this.sort_array[i];
        this.sort_array[i] = this.sort_array[j];
        this.sort_array[j] = temp;
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

}