import java.util.Random;

public class Lesson19_4 {
    public static final int NUM = 10000; // 配列・ハッシュテーブルのサイズ
    public static final int N = 100; // ハッシュテーブルに追加するデータの個数
    public static final int REP = 50000; // 検索を行う回数

    public static void main(String[] args) {
        for (int i = 0; i < 1; i++) {
            hashtableTest();
        }

        for (int i = 0; i < 1; i++) {
           arrayTest();
        }
    }

    // for HashTable
    public static void hashtableTest() {
        Random r = new Random();
        MyHashtable table = new MyHashtable(NUM);

        for (int i = 0; i < N - 1; i++) {
            table.put(new AddressData(generateName(), "Kochi", "Kami", "782-0003"));
        }
        table.put(new AddressData("oka", "Kyoto", "foo", "000"));

        AddressData result = null;
        long begin = System.nanoTime();
        for (int i = 0; i < REP; i++) {
            result = table.get("oka");
        }
        long end = System.nanoTime();

        System.out.println("=== Hash ===");
        if (result == null || !result.getName().equals("oka")) {
            System.out.println("Key(oka): not found");
        } else {
            System.out.println("Key(oka): found");
        }
        System.out.println("Size of the hashtable: " + NUM);
        System.out.println("Number of added elements: " + N);
        System.out.println("Number of elements in the hashtable: "+ table.size()); // Lesson23_1
        System.out.println("Collision times: " + table.getCollision()); // Lesson23_2
        System.out.println("Start time : " + begin);
        System.out.println("End time   : " + end);
        System.out.println("Search time: " + ((end - begin) / 1000000.0) + "ms");
        System.out.println();
    }

    // for array
    public static void arrayTest() {
        Random r = new Random();
        AddressData[] address = new AddressData[NUM];

        for (int i = 0; i < N; i++) {
            address[i] = new AddressData(generateName(), "Kochi", "Kami", "782-0003");
        }
        //address[r.nextInt(address.length)] = new AddressData("oka", "Kyoto", "bar", "000"); // ランダムな位置に検索対象を入れる
        address[address.length/2] = new AddressData("oka", "Kyoto", "bar", "000"); // 配列の中央に検索対象を入れる

        AddressData result;
        int pos = -1;
        long begin = System.nanoTime();
        for (int i = 0; i < REP; i++) {
            for (int j = 0; j < address.length; j++) {
                result = address[j];
                if (result != null && result.getName().equals("oka")) {
                    pos = j;
                    break;
                }
            }
        }
        long end = System.nanoTime();

        System.out.println("=== Array ===");
        if (pos == -1) {
            System.out.println("Key(oka): not found");
        } else {
            System.out.println("Key(oka): found (pos: " + pos + ")");
        }
        System.out.println("Size of the array: " + NUM);
        System.out.println("Start time : " + begin);
        System.out.println("End time   : " + end);
        System.out.println("Search time: " + ((end - begin) / 1000000.0) + "ms");
        System.out.println();
    }

    private static String generateName() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random r = new Random();

        int n = r.nextInt(20) + 1;
        StringBuffer tmp = new StringBuffer();
        for (int i = 0; i < n; i++) {
            int c = r.nextInt(chars.length());
            tmp.append(chars.charAt(c));
        }
        return tmp.toString();
    }
}
