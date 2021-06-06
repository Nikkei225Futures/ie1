public class Lesson13_4 {
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
        ta.printAll();

        System.out.println("========== result ==========");

        System.out.println("-- M1 --");
        StringArray m1 = ta.trimming(4,6);
        m1.printAll();

        System.out.println("-- M2 --");
        StringArray m2 = ta.trimming(-1,4);
        m2.printAll();

        System.out.println("-- Fukumoto_Laboratory --");
        StringArray Fukumoto = ta.trimming(3,4);
        Fukumoto.printAll();

        System.out.println("-- Inadome --");
        StringArray inadome = ta.trimming(1,1);
        inadome.printAll();
        System.out.println("============================");
    }
}
