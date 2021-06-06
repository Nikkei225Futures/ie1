public class Element {
    // フィールド
    private Object data; // データ
    private Element next; // 次の要素への参照
    // コンストラクタ

    private Element() {

    }// 引数無しの初期化を防ぐ

    public Element(Object obj) {
        this.data = obj; // コンストラクタ
    }

    // メソッド
    public Object getData() {
        return this.data;// データを返す
    }

    public Element getNextElement() {
        return this.next;// 次の要素（の参照）を返す
    }

    public void setNextElement(Element nextElement) {
        this.next = nextElement;// 次の要素（の参照）を設定
    }

    public String toString() {
        if (this.next != null) {
            return this.data.toString() + " -> ";
        } else {
            return this.data.toString();
        }
    }
}