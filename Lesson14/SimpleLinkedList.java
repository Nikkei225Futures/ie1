public class SimpleLinkedList {
    private Element firstElement; // フィールド：リストの先頭
    private int length;

    public SimpleLinkedList() { // コンストラクタ
        this.firstElement = new Element(null); // リストの先頭要素
    }

    public Object get(int index) { // index番目のデータを取り出す
        Element element = this.getElement(index); // 指定された場所にElementオブジェクトがあるか調べる
        if (null == element) { // 指定された場所にElement オブジェクトがないので
            // エラーメッセージを出力して処理を抜ける
            System.out.println("Element-" + index + " is not exist.");
            return null;
        }
        return element.getData();

    }

    public boolean insert(int index, Object obj) { // index番目にobjを挿入
        // 指定された場所が正しいかどうか
        if (index < 1) {
            System.out.println("Cannot insert: " + index);
            return false;
        }
        Element previous = this.getElement(index - 1);
        if (previous == null) {
            System.out.println("Cannot insert: " + index);
            return false;
        }
        Element element = new Element(obj);
        element.setNextElement(previous.getNextElement());
        previous.setNextElement(element);
        this.length++;
        return true;
    }

    public boolean remove(int index) { // index番目の要素を削除
        // 指定された場所が正しいかどうか
        if (index < 1) {
            System.out.println("Cannot remove: " + index);
            return false;
        }
        Element removeElement = this.getElement(index);
        if (removeElement == null) {
            System.out.println("Cannot remove: " + index);
            return false;
        }
        Element previous = this.getElement(index - 1);
        previous.setNextElement(removeElement.getNextElement());
        removeElement.setNextElement(null);
        this.length--;
        return true;

    }

    private Element getElement(int index) { // index番目の要素を取得
        Element currentElement = this.firstElement; // 指定された場所まで、先頭から順番に移動する
        for (int count = 0; count < index; count++) { // リストの最後まで到達
            if (null == currentElement) {
                return null;
            } // 次の要素へ移動
            currentElement = currentElement.getNextElement();
        }
        return currentElement;
    }

    public void printAll() {
        int count = 0;
        Element currentElement = this.firstElement.getNextElement();
        while (currentElement != null) {
            count++;
            System.out.println(count + " : " + currentElement);
            currentElement = currentElement.getNextElement();
        }
        System.out.println();
    }

    //Lesson14_1
    public int getLength(){
        return this.length;
    }

    public boolean append(Object obj){
        if(this.insert(this.length+1, obj)){
            return true;
        }else{
            return false;
        }
        
    }

    //Lesson14_2
    public int search(Object obj){
        int count = 0;
        Element currentElement = this.firstElement.getNextElement();
        while (currentElement != null) {
            count++;
            if(currentElement.getData().toString().equals(obj)){
                return count; 
            }
            currentElement = currentElement.getNextElement();
        }
        System.out.println("Not Found: " + obj);
        return -1;
    }

    //Lesson14_3
    public boolean remove(Object obj){
        if(search(obj) == -1){
            System.out.println("Cannnot remove " + obj);
            return false;
        }
        return remove(this.search(obj));
    }

    //Lesson14_4
    public boolean insertList(SimpleLinkedList list, int index){
        if(list.length == 0){
            System.out.println("Cannot insert list: insert list is empty");
            return false;
        }else if(list.length < 1 || index > this.getLength() || index < 1){
            System.out.println("Cannot insert list: index out of bounds");
            return false;
        }

        for(int i = list.length; i > 0; i--){
            this.insert(index, list.get(i));
        }
        return true;
    }

    //Lesson14_5
    public boolean cut(int from, int to){
        if(from < 1 || from > this.length || to < 1 || to > this.length){
            System.out.println("Cannot cut list: index out of bounds");
            return false;
        }else if(to <= from){
            System.out.println("Cannot cut list: from is bigger than \"to\"");
            return false;
        }
        
        for(int i = from; i <= to; i++){
            this.remove(from);
        }

        return true;
    }
}
