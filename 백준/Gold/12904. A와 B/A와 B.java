import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String temp = br.readLine();
        ArrayList<Character> necessaryStr = new ArrayList<Character>();

        for (int i = 0; i < temp.length(); i++) {
            necessaryStr.add(temp.charAt(i));
        }

        for (int i = temp.length() - 1; i >= str.length(); i--) {
            if (necessaryStr.get(i) == 'A') {
                necessaryStr.remove(i);
            } else {
                necessaryStr.remove(i);
                Collections.reverse(necessaryStr);
            }
        }

        String result = "";
        for (Character c : necessaryStr) {
            result = result + c;
        }

        if (Objects.equals(str, result)) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }
    }
}