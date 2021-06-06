public class Lesson10_1 {
  public static void main(String args[]) {
	Character[] characters = new Character[3];
    characters[0] = new Hero("Hiro", 150, 40);
	characters[1] = new Wizard("Wizz", 100, 12);
	characters[2] = new Priest("Ris", 110, 18);

	System.out.println("=====  Status  =====");
	for(int i = 0; i < characters.length; i++){
		characters[i].showStatus();
	}
	System.out.println("====================");
  }
}
