public class Lesson13_1{
    public static void main(String[] args){
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

        StringArray check = new StringArray(4);
        check.set("Inadome", 0);
        check.set("Mendori", 1);
        check.set("Teramura", 2);
        String temp = "Naka";
        temp += "mura";
        check.set(temp,3);

        System.out.println("========= Result =========");
        System.out.println("! Searched the Number !");
        for(int i = 0; i < check.length; i++){
            if(ta.search(check.get(i)) != -1){
                System.out.println(String.format(check.get(i) + " found!!"));
                System.out.println(String.format(check.get(i) + " : Index Number is " + ta.search(check.get(i))));
            } else {
                System.out.println(String.format(check.get(i) + " not found..."));
                System.out.println(String.format(check.get(i) + " : Index Number can not be found."));
            }
        }
        System.out.println("==========================");
    }
}
