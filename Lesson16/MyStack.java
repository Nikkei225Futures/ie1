public class MyStack {
    private int maxSize; // スタックの大きさ
    private Object[] stackArray; // スタックを実現する配列
    private int stackPointer; // スタックポインタ

    private MyStack() {
    }

    public MyStack(int size) {
        this.maxSize = size;
        this.stackArray = new Object[size];
        this.stackPointer = 0; // push時に格納される配列のindex
    }

    // スタックが空かどうかを判定するメソッド
    public boolean isEmpty() {
        return (this.stackPointer == 0);
    }

    // スタックが一杯かどうかを判定するメソッド
    public boolean isFull() {
        return (this.stackPointer == this.maxSize);
    }

    public Object pop() {
        if (this.isEmpty()) {
            // 特にエラーメッセージを表示する場合に使うメソッド（標準エラーストリーム）
            System.err.println("Stack is Empty.");
            return null;
        }
        this.stackPointer--;
        Object popObject = this.stackArray[this.stackPointer];
        this.stackArray[this.stackPointer] = null;
        return popObject;
    }

    public void push(Object obj) {
        if (this.isFull()) {
            System.err.println("Stack is full.");
            return;
        }
        this.stackArray[this.stackPointer] = obj;
        this.stackPointer++;
    }

    public void printAll() {
        System.out.println("Contents of Stack");
        int count = 1;
        int position = this.stackPointer - 1;
        while (position >= 0) {
            System.out.println(count + "¥t" + this.stackArray[position]);
            count++;
            position--;
        }
        System.out.println();
    }
}
