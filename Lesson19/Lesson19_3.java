public class Lesson19_3 {
    public static void main(String[] args) {
        MyHashtable ht = new MyHashtable(10);

		ht.put(new AddressData("Isobe","President", "Main Build.", "VIP room"));
		ht.put(new AddressData("Mendori","Teacher", "Mendori Lab", "A307"));
		ht.put(new AddressData("Takeuchi","Teacher", "Takeuchi Lab","A501"));
		
		ht.put(new AddressData("Inadome","M2", "Shimizu Lab", "A305"));
		ht.put(new AddressData("Oki","M2", "Takata Lab", "A355"));
		ht.put(new AddressData("Teramura","M2", "Matsuzaki Lab", "A310"));
		ht.put(new AddressData("Nakamura","M2", "Fukumoto Lab", "A357"));
		
		ht.put(new AddressData("Onoda","M1", "Fukumoto Lab", "A357"));
		ht.put(new AddressData("Takahashi","M1", "Yoshida Lab", "A309"));
		ht.put(new AddressData("Tochikawa","M1", "Takeuchi Lab", "A501"));

        System.out.println("------------ MyHashtable ------------");
        ht.printAll();

        ht.search("Takahashi");
        System.out.println();
        ht.search("Isobe");
        System.out.println();
        ht.search("KUTinfo");
        System.out.println();
        ht.search(null);
    }
}
