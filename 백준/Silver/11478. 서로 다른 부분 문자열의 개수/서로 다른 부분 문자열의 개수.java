import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();

        Set<String> set = new HashSet<>();

        for (int i = 1; i <= S.length(); i++) {
            for (int j = 0; j <= S.length() - i; j++) {
                set.add(S.substring(j, j + i));
            }
        }

        System.out.println(set.size());
    }
}