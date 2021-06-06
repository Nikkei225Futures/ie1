public class StringArray {
    //---フィールド---
    private String[] array;
    public final int length; 

    //---コンストラクタ---
    public StringArray(int size) {
        this.length = size;
        this.array = new String[this.length];
    }
    
    private StringArray() {
        this.length = 0;
    }
    
    //---メソッド---
    public boolean set(String obj, int index) {
        if (index < 0 || index > this.length -1) {
            System.out.println("ArrayIndexOutOfBoundsException!");
            return false;
        }
        this.array[index] = obj;
        return true;
    }
    public String get(int index) {
        if (index < 0 || index > this.length -1) {
            System.out.println("ArrayIndexOutOfBoundsException!");
            return null;
        }
        return this.array[index];
    }

    public void printAll() {
        for (int i= 0; i< this.length; i++) {
            System.out.println("this.array[" + i+ "] = " + this.array[i]);
        }
    }

    public int search(String str){
        for(int i = 0; i < this.array.length; i++){
            if(str.equals(this.array[i])){
                return i;
            }
        }
        return -1;
    }

    public void exchange(int index1, int index2){
        if(index1 < 0 || index1 >= this.array.length || index2 < 0 || index2 >= this.array.length){
            System.out.println("argument(s) are invalid");
            System.out.println("exchange(" + index1 + ", " + index2 + ")was disabled");
            return;
        }
        String tmp = this.array[index1];
        this.array[index1] = this.array[index2];
        this.array[index2] = tmp;
    }

    public int replace(String obj1, String obj2){
        int repCnt = 0;
        System.out.println(obj1 + "->" + obj2);
        for(int i = 0; i < this.array.length; i++){
            if(obj1.equals(this.array[i])){
                System.out.println(obj1 + "is found at index" + i);
                this.array[i] = obj2;
                repCnt++;
            }
        }
        if(repCnt == 0){
            System.out.println(obj1 + "can not found.");
            return -1;
        }else{
            System.out.println("Replace " + repCnt + " Elements.");
            return repCnt;
        }
    }

    public StringArray trimming(int from, int to){
        if(from < 0 || from >= this.array.length || to < 0 || to >= this.array.length || from > to){
            System.out.println("argument(s) are invalid");
            System.out.println("trimming(" + from + ", " + to + ") was disabled");
            StringArray errObj = new StringArray(1);
            errObj.array[0] = "ERROR";
            return errObj;
        }
        
        StringArray newObj = new StringArray(to - from + 1);
        for(int i = from, j = 0; i <= to; i++, j++){
            newObj.array[j] = this.array[i]; 
        }
        return newObj;
    }
    
    public void sort(){
        boolean isNotSorted = true;
        while(isNotSorted){
            for(int i = 0; i < this.array.length - 1; i++){
                if(this.array[i].compareTo(this.array[i+1]) > 0){
                    this.exchange(i, i+1);
                    isNotSorted &= false;
                }
            }
        }
    }
}