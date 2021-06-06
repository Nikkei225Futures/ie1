public class BinarySearchTree {
    // フィールド
    private MyNode root;
    private int numOfNodes = 0;

    // コンストラクタ
    public BinarySearchTree() {
        this.root = null;
    }

    // メソッド
    public void insert(MyData aData) {
        numOfNodes++;
        MyNode newNode = new MyNode(aData);
        if (null == this.root) {
            this.root = newNode;
            return;
        }
        MyNode currentNode = this.root;
        while (true) {
            if (currentNode.getData().compareTo(aData) > 0) {
                if (currentNode.getLeft() == null) {
                    currentNode.setLeft(newNode);
                    return;
                }
                currentNode = currentNode.getLeft();
            } else {
                if (currentNode.getRight() == null) {
                    currentNode.setRight(newNode);
                    return;
                }
                currentNode = currentNode.getRight();
            }
        }
    }

    // 動作確認用
    public void printRoot() {
        // ルートノードを表示
        System.out.println(this.root);
        // ルートノードの左の子ノードを表示
        System.out.println(this.root.getLeft());
        // ルートノードの右の子ノードを表示
        System.out.println(this.root.getRight());
    }

    // 課題1
    public MyData getMaximumData() {
        if (this.root == null) {
            return null;
        }
        MyNode currentNode = this.root;
        while (currentNode.getRight() != null) {
            currentNode = currentNode.getRight();
        }
        return currentNode.getData();
    }

    public MyData getMinimumData() {
        if (this.root == null) {
            return null;
        }
        MyNode currentNode = this.root;
        while (currentNode.getLeft() != null) {
            currentNode = currentNode.getLeft();
        }
        return currentNode.getData();
    }

    // 課題2
    public int getNumOfNodes() {
        return this.numOfNodes;
    }

    public int countNodes(MyNode currentNode) {
        if (currentNode == null) {
            return 0;
        } else if (currentNode != null) {
            return 1;
        }
        return this.countNodes(currentNode.getLeft()) + this.countNodes(currentNode.getRight());
    }

    // 課題3
    public int getHeight() {
        return this.getNodeHeight(this.root);
    }

    private int getNodeHeight(MyNode currentNode) {
        if (currentNode == null) {
            return 0;
        }
        int right = getNodeHeight(currentNode.getRight());
        int left = getNodeHeight(currentNode.getLeft());
        if (right < left) {
            return left + 1;
        } else {
            return right + 1;
        }
    }

    // 課題4
    public void showTree() {
        System.out.println(this.showSubTree(this.root, 0));
    }

    public String showSubTree(MyNode localNode, int counter) {
        if (localNode == null) {
            return "";
        }

        StringBuffer buf = new StringBuffer();
        if (localNode != null) {
            String str = this.align(counter) + counter + ":" + localNode.getData().toString();
            buf.append(str + "\n");
        }

        buf.append(showSubTree(localNode.getLeft(), counter + 1));
        buf.append(showSubTree(localNode.getRight(), counter + 1));

        return buf.toString();

    }

    private String align(int counter) {
        String ret = "";
        for (int i = 0; i < counter; i++) {
            ret += "   ";
        }
        return ret;
    }

    // 2020/07/07

    // 指定されたノードをルートとする部分木内の最小のノードを取得する
    private MyNode getMinimumNode(MyNode localNode) {
        // 指定されたノードがnull であるか調べる
        if (localNode == null) {// 指定されたノードがnull なので，null を返して処理を抜ける
            return null;
        }
        // 木をたどって最小のノードを見つける
        MyNode currentNode = localNode;
        while (true) {
            // 左の子がなくなれば、それが最小ノード
            if (currentNode.getLeft() == null) {
                return currentNode;
            }
            currentNode = currentNode.getLeft();
        }
    }

    public boolean remove(MyData aData) {
        // 木が空であるか調べる
        if (this.root == null) {
            // 木が空なので，false を返し処理を抜ける
            return false;
        }
        // 削除対象ノードの親ノード
        MyNode parentNode = this.root;
        // 削除対象ノード
        MyNode currentNode = this.root;
        // 削除対象が親ノードの左の子であるか否か
        boolean inLeftSubTree = false;

        // 削除する対象のノード（currentNode）を探す
        while (currentNode.getData().compareTo(aData) != 0) {
            parentNode = currentNode;
            if (currentNode.getData().compareTo(aData) > 0) {
                currentNode = currentNode.getLeft();
                inLeftSubTree = true;
            } else {
                currentNode = currentNode.getRight();
                inLeftSubTree = false;
            }
            if (null == currentNode) {
                return false;
            }
        }

        // 削除するノードが子を持たないとき
        if (currentNode.getLeft() == null && currentNode.getRight() == null) {
            // 削除対象がルートノード
            if (currentNode == this.root) {
                this.root = null;
            }
            // 削除対象が親ノードの左の子
            else if (inLeftSubTree) {
                parentNode.setLeft(null);
            }
            // 削除対象が親ノードの右の子
            else {
                parentNode.setRight(null);
            }
        }

        // 削除するノードが左の子ノードを一つだけ持つ場合
        else if (currentNode.getRight() == null) {
            // 削除対象がルートノード
            if (currentNode == this.root) {
                // 削除対象の左の子をルートノードに設定
                this.root = currentNode.getLeft();
            }
            // 削除対象が親ノードの左の子
            else if (inLeftSubTree) {
                // 削除対象の左の子を親ノードの左の子として設定
                parentNode.setLeft(currentNode.getLeft());
            }
            // 削除対象が親ノードの右の子
            else {
                // 削除対象の左の子を親ノードの右の子として設定
                parentNode.setRight(currentNode.getLeft());
            }
        }

        // 削除するノードが右の子ノードを一つだけ持つ場合
        else if (currentNode.getLeft() == null) {
            // 削除対象がルートノード
            if (currentNode == this.root) {
                // 削除対象の右の子をルートノードに設定
                this.root = currentNode.getRight();
            }
            // 削除対象が親ノードの左の子
            else if (inLeftSubTree) {
                // 削除対象の右の子を親ノードの左の子に設定
                parentNode.setLeft(currentNode.getRight());
            }
            // 削除対象が親ノードの右の子
            else {
                // 削除対象の右の子を親ノードの右の子として設定
                parentNode.setRight(currentNode.getRight());
            }
        }

        // 削除するノードが子を二つ持つ場合
        else {
            // 右部分木の中で一番小さい値を持つノードを探索
            MyNode minimumNode = this.getMinimumNode(currentNode.getRight());
            // 右部分木の中から右部分木の中で一番小さい値を持つノードを削除
            this.remove(minimumNode.getData());
            // 右部分木の中で一番小さい値を持つノードを削除対象のノードと置き換える
            minimumNode.setLeft(currentNode.getLeft());
            minimumNode.setRight(currentNode.getRight());
            if (currentNode == this.root) {
                this.root = minimumNode;
            } else if (inLeftSubTree) {
                parentNode.setLeft(minimumNode);
            } else {
                parentNode.setRight(minimumNode);
            }
        }
        currentNode.setLeft(null);
        currentNode.setRight(null);
        return true;
    }

    public MyNode search(MyData aData) {
        // 木が空であるか調べる
        if (this.root == null) {
            // 木が空なので，null を返し処理を抜ける
            return null;
        }
        // 木をたどって対象のノードを探す
        MyNode currentNode = this.root;
        while (true) {
            // 対象のノードであるか判定する
            if (currentNode.getData().compareTo(aData) == 0) {
                // 対象のノードなのでノードを返して処理を抜ける
                return currentNode;
            }
            // データを左の子ノードに探索するべきか右の子ノードに探索するべきか調べる
            if (currentNode.getData().compareTo(aData) > 0) {
                // 左に子ノードがあるか調べる
                if (currentNode.getLeft() == null) {
                    return null;
                    // 該当する子ノードがない
                }
                currentNode = currentNode.getLeft();
            } else {
                // 右に子ノードがあるか調べる
                if (currentNode.getRight() == null) {
                    return null;
                    // 該当する子ノードがない
                }
                currentNode = currentNode.getRight();
            }
        }
    }

    // 間順走査
    public void printTreeInOrder() {
        System.out.println(this.traverseInOrder(this.root));
    }

    private String traverseInOrder(MyNode localNode) {
        // ノードがnull であるか調べる（基底条件）
        if (localNode == null) {
            return "";
            // ノードがnull なので空文字列を返し処理を抜ける
        }
        // 木の文字列表現を取得する
        StringBuffer tr = new StringBuffer();
        // 左の子ノードの文字列表現を取得する
        tr.append(this.traverseInOrder(localNode.getLeft()));
        // 本ノードの文字列表現を取得する
        tr.append(localNode + "¥n");
        // "¥"は環境によって"＼"（半角）に
        // 右の子ノードの文字列表現を取得する
        tr.append(this.traverseInOrder(localNode.getRight()));
        return tr.toString();
        // trはStringBuffer
    }

}