public class Lesson06_5 {
	public static void main(String[] args) {
		Hero h = new Hero();
		
		//h.setName("工科大介");
		//h.setLevel(50);
		//h.setName("");
		//h.setLevel(50);
		//h.setName("ルイス・イ・ピカソ");
        //h.setLevel(100);
		h.setName("工科大介");
        h.setLevel(5000);
		
		System.out.println("勇者「" + h.getName() + "」のレベルは" + h.getLevel() + "です");
	}
}
