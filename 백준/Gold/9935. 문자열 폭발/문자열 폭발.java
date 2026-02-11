import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        String select = br.readLine();

        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < str.length(); i++) {
            int count = 0;
            stack.push(str.charAt(i));

            if (stack.size() >= select.length()) {
                for (int j = select.length() - 1, k = stack.size() - 1; j >= 0; j--, k--) {
                    if (select.charAt(j) == stack.get(k)) {
                        count++;
                    }
                }
            }

            if (count == select.length()) {
                for (int j = 0; j < select.length(); j++) {
                    stack.pop();
                }
            }
        }

        if (!stack.empty()) {
            for (char c : stack) {
                sb.append(c);
            }
        } else {
            sb.append("FRULA");
        }

        System.out.println(sb);
    }
}