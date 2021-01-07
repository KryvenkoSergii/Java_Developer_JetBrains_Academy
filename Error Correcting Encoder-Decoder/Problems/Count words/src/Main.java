import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = reader.readLine().trim().split("\\s+");
        reader.close();
        System.out.println(strings[0].length() != 0 ? strings.length : "0");
    }
}