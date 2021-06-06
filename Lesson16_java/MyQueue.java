public class MyQueue {
    // ----フィールド----
    private Object[] queueArray; // キューを実現する配列
    private int head; // キューの先頭を示すインデックス
    private int tail; // キューの最後を示すインデックス
    private int maxSize; // キューを実現ずる配列のサイズ
    private int num; // キューに格納されているオブジェクト数
    // ----コンストラクタ----

    public MyQueue(int size) {
        this.queueArray = new Object[size];
        this.head = 0;
        this.tail = 0;
        this.num = 0;
        this.maxSize = size;
    }

    private MyQueue() {

    }

    // ----メソッド----
    // 敢えて，格納された配列のidnexを返すようにしている
    public int enqueue(Object obj) {
        // 格納されているオブジェクト数が配列のサイズよりも小さいときだけ追加
        if (this.num < this.maxSize) {
            this.queueArray[this.tail] = obj;
            // キューの最後に追加
            int oldtail = this.tail;
            // 配列の最後であれば先頭へ
            this.tail = (this.tail + 1) % this.maxSize;
            this.num++;
            return oldtail; // objが格納されたqueueArrayのindexを返す
        } else {
            return -1;// 配列が一杯なら-1を返す
        }

    }

    public Object dequeue() {
        // 1個以上のオブジェクトが格納されているときだけ取り出し
        // isEmpty()メソッドを利用するのも可
        if (this.num > 0) {
            Object obj = this.queueArray[head];
            // 配列の最後であれば先頭へ
            this.head = (this.head + 1) % this.maxSize;
            this.num--;
            return obj;
        } else {
            return null;
        }

    }

    public boolean isEmpty() {
        return (this.num == 0);
    }

    public boolean isFull() {
        return (this.num == this.maxSize);
    }

    public void printAll() {
        System.out.println("Contents of Queue");
        if (!this.isEmpty()) {
            int position = this.head;
            for (int i = 0; i < this.num; i++) {
                position = (this.head + i) % this.maxSize;
                System.out.println(this.queueArray[position]);
            }
        }
    }

    //課題3
    public void clear(){
        while(true){
            if(this.dequeue() == null){
                break;
            }
        }
    }

    public Object peek(){
        if(this.isEmpty()){
            System.out.println("Queue is Empty");
            return null;
        }else{
            Object peekObj = this.queueArray[head];
            return peekObj;
        }
    }

    public int forceEnqueue(Object obj){
        if(!this.isFull()){
            return this.enqueue(obj);
        }else{
            this.dequeue();
            this.queueArray[this.tail] = obj;
            this.num++;
            return this.tail;
        }
    }

    //課題4
    public void rotate(int n){
        if(this.num == 0){
            return;
        }
        for(int i = 0; i < n; i++){
            Object headObj = this.dequeue();
            this.enqueue(headObj);
        }
    }
}
