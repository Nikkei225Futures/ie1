public class DoublyLinkedList {
    private DoublyElement firstElement; //リストの先頭
    private DoublyElement lastElement;  //リストの最後
    private int length;
    public DoublyLinkedList() {
        //コンストラクタ
        this.firstElement = new DoublyElement(null);
        this.lastElement = new DoublyElement(null);
        this.firstElement.setNextElement(this.lastElement);
        this.lastElement.setPreviousElement(this.firstElement);
    }
    public Object get(int index) {
        //index番目のデータを取り出す
        DoublyElement element = this.getElement(index); 
        // 指定された場所にDoublyElementオブジェクトがあるか調べる
        if (null == element) { 
            // 指定された場所にDoublyElementオブジェクトがないので
            // エラーメッセージを出力して処理を抜ける
            System.out.println("Not exist: "+ index); 
            return null; 
        } 
        return element.getData();
    }
    public boolean insert(int index, Object obj) {
        //index番目にobjを格納した要素を挿入
        //指定された場所が正しいかどうか
        if (index < 1) {
            System.out.println("Cannot insert: " + index);
            return false;
        }
        DoublyElement previous = this.getElement(index-1);
        if (previous == null) {
            System.out.println("Cannot insert: " + index);
            return false;
        }DoublyElement element = new DoublyElement(obj);
        element.setNextElement(previous.getNextElement());
        previous.getNextElement().setPreviousElement(element);
        previous.setNextElement(element);
        element.setPreviousElement(previous);
        this.length++;
        return true;
    }
    public boolean remove(int index) {
        //index番目の要素を削除
        //指定された場所が正しいかどうか
        if (index < 1) {
            System.out.println("Cannot remove: " + index);
            return false;
        }
        DoublyElement removeElement = this.getElement(index);
        if (removeElement == null) {
            System.out.println("Cannot remove: " + index);
            return false;
        }
        
        DoublyElement previous = this.getElement(index -1);
        previous.setNextElement(removeElement.getNextElement());
        removeElement.getNextElement().setPreviousElement(previous);
        removeElement.setNextElement(null);
        removeElement.setPreviousElement(null);
        this.length--;
        return true;
    }

    private DoublyElement getElement(int index) {
        // index番目の要素を取得
        DoublyElement currentElement = this.firstElement; // 指定された場所まで、先頭から順番に移動する
        for (int count = 0; count < index; count++) {
            // 次の要素へ移動
            currentElement = currentElement.getNextElement();
            // リストの最後まで到達
            if (currentElement == this.lastElement) {
                return null;
            }
        }
        return currentElement;
    }

    public void printAll() {
        DoublyElement currentElement = this.firstElement.getNextElement();
        while (currentElement != this.lastElement) {
            System.out.println(currentElement);
            currentElement = currentElement.getNextElement();
            if (currentElement != this.lastElement) {
                System.out.println("<->");
            }
        }
        System.out.println();
    }

    public void printAllReverse(){
        DoublyElement currentElement = this.lastElement.getPreviousElement();
        while(currentElement != this.firstElement){
            System.out.println(currentElement);
            currentElement = currentElement.getPreviousElement();
            if(currentElement != this.firstElement){
                System.out.println("<->");
            }
        }
        System.out.println();
    }
    
    public int getLength(){
        return this.length;
    }

    public int search(Object obj){
        int count = 0;
        DoublyElement currentElement = this.firstElement.getNextElement();
        while (currentElement.getData() != null) {
            count++;
            if(currentElement.getData().toString().equals(obj)){
                return count;
            }
            currentElement = currentElement.getNextElement();
        }
        return -1;
    }

    public void removeGarbage(Object obj){
        while(this.search(obj) != -1){
            this.remove(this.search(obj));
        }
    }

    public DoublyLinkedList copyList(){
        DoublyLinkedList copyList = new DoublyLinkedList();
        DoublyElement currentElement = this.lastElement.getPreviousElement();
        int i = 1;
        while(currentElement.getData() != null){
            copyList.insert(i, currentElement.getData());

            currentElement = currentElement.getPreviousElement();
        }
        return copyList;
    }

    public DoublyLinkedList split(int index){
        if(index < 0){
            return null;
        }else if (index > this.length){
            return new DoublyLinkedList();
        }

        DoublyLinkedList splitList = new DoublyLinkedList();
        DoublyElement currentElement = this.lastElement.getPreviousElement();
        for(int i = this.length; i > index; i--){
            splitList.insert(1, currentElement.getData());
            currentElement = currentElement.getPreviousElement();
        }
        
        currentElement = this.getElement(index);
        currentElement.setNextElement(null);
        this.lastElement = currentElement.getNextElement();

        this.length -= this.length - index;

        return splitList;
    }

    public DoublyLinkedList copysplit(int index){
        DoublyLinkedList splitList = this.copyList();
        int i;

        if(index < 0){
            System.out.println("invalid index");
            return null;
        }else if(index > splitList.length){
            return new DoublyLinkedList();
        }

        for(i = 1; i <= index; i++){
            splitList.remove(1);
        }

        return splitList;
    }
}