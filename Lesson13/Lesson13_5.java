public class Lesson13_5 {
    public static void main(String args[]){
        StringArray ta = new StringArray(8);
        for(int i = 0; i < ta.length; i++){
            ta.set("ARRAY-" + i, i);
        }

        ta.set("Oki", 0);
        ta.set("Inadome", 1);
        ta.set("Teramura", 2);
        ta.set("Nakamura", 3);
        ta.set("Onoda", 4);
        ta.set("Takahashi", 5);
        ta.set("Tochikawa", 6);
        ta.set("Teramura", 7);
        ta.printAll();

        System.out.println("========== result ==========");
        ta.sort();
        ta.printAll();
        System.out.println("============================");
    }
}
