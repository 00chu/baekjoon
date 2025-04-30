import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String document = br.readLine();
        String word = br.readLine();

        int count = 0;

        for (int i = 0; i <= document.length() - word.length(); i++) {
            if (document.charAt(i) == word.charAt(0)
                    && Objects.equals(document.substring(i, i + word.length()), word)) {
                count++;
                i += word.length() - 1;
            }
        }

        System.out.println(count);
    }
}