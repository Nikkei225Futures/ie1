public class Lesson01_4 {
    public static void main(String args[]) {
        String name = args[0];
        if(name.equals("Oki")){
            System.out.println("Takata lab");
        }else if(name.equals("Inadome")){
            System.out.println("Simizu lab");
        }else if(name.equals("Teramura")){
            System.out.println("Matsuzaki lab");
        }else if(name.equals("Nakamura")){
            System.out.println("Fukumoto lab");
        }else{
            System.out.println("No such data.");
        }
    }
}
