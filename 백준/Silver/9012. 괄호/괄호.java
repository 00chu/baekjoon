import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            Stack<Character> stack = new Stack<Character>();

            String st = br.readLine();

            int num = st.length();
            boolean flag = true;

            for (int j = 0; j < num; j++) {
                char brackets = st.charAt(j);

                if (brackets == '(') {
                    stack.push(brackets);
                } else if (stack.isEmpty()) {
                    System.out.println("NO");
                    flag = false;
                    break;
                } else {
                    stack.pop();
                }
            }
            if (flag) {
                if (stack.isEmpty()) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }

        br.close();
    }
}