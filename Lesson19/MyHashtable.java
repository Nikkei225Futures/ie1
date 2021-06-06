public class MyHashtable {
    //フィールド
    private AddressData[] table;
    private int collision = 0;

    //コンストラクタ
    private MyHashtable() {
    
    }
    
    public MyHashtable(int aMaxSize) {
        this.table = new AddressData[aMaxSize];
    }
    
    //メソッド
    public AddressData get(String aKey) {
        if (null == aKey) {
            throw new NullPointerException(); // 鍵がnull
        }
        // ハッシュ値を計算してデータを取得する
        return this.table[this.calculateHashCode(aKey)];
    }
    
    public void printAll() {
        // テーブルの内容を順番に全て表示
        for (int count = 0; count < this.table.length; count++) {
            System.out.println(count + "\t" + this.table[count]);   //¥t -> \t に変更
        }

        System.out.println();
    }

    public boolean put(AddressData anAddressData) {
        if (null == anAddressData) {
            return false;//データがnull
        }
      
        //課題2
        int argAddr = this.calculateHashCode(anAddressData.getName());
        if(this.table[argAddr] != null){
            this.collision++;
        }
        //

        this.table[this.calculateHashCode(anAddressData.getName())] = anAddressData;
        return true;
    }
    
    public boolean remove(String aKey) {
        if (null == aKey) {
            return false;
        }
        this.table[this.calculateHashCode(aKey)] = null;
        return true;
    }

    private int calculateHashCode(String aKey) {
        // 鍵がnull であるか調べる
        if (null == aKey) {
            // 鍵がnull なので例外を報告して処理を抜ける
            throw new NullPointerException();
        }
        
        // 文字列の各文字をUnicode 数値として扱い、足し合わせる
        int intKey = 0;
        for (int count = 0; count < aKey.length(); count++) {
            intKey += 0xffff & aKey.charAt(count);
        }
        // 合計値からハッシュ値を求める
        return intKey % this.table.length;
    }

    //課題1
    public int size(){
        int size = 0;
        for(int i = 0; i < this.table.length; i++){
            if(this.table[i] != null){
                size++;
            }
        }
        return size;
    }

    public void clear(){
        for(int i = 0; i < this.table.length; i++){
            this.table[i] = null;
        }
    }

    //課題2
    public int getCollision() {
        return this.collision;
    }

    //課題3
    public void search(String aKey){
        //aKeyがnull
        if(aKey.equals(null)){
            System.out.println("Key is null");
            throw new NullPointerException();
        }

        //search
        int argAddr = this.calculateHashCode(aKey);

        if(this.table[argAddr] == null){
            System.out.println(aKey + " does not exists.");
        
        }else if(this.table[argAddr].getName().equals(aKey)){
            System.out.println(aKey + " exists.");
            System.out.println("Data: " + this.table[argAddr].toString());
        
        }else if(!(this.table[argAddr].getName().equals(aKey))){
            System.out.println(aKey + "does not exists.");
        }

    }
    
}