import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word = br.readLine();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            if (Character.isLowerCase(word.charAt(i))) {
                sb.append(Character.toUpperCase(word.charAt(i)));
            }else{
                sb.append(Character.toLowerCase(word.charAt(i)));
            }
        }

        System.out.println(sb);
    }
}