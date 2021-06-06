import java.util.Properties;

public class GetEnvironmentProperty {
    public static void main(String[] args) {
        Properties prop = System.getProperties();
        for (Object key : prop.keySet()) {
            System.out.println(key.toString() + ":" + prop.get(key));

        }
    }
}