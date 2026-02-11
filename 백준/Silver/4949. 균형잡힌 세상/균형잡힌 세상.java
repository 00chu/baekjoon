import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            Stack<Character> stack = new Stack<Character>();
            boolean flag = true;

            String st = br.readLine();
            if (".".equals(st)) {
                br.close();
                break;
            }
            int num = st.length();

            for (int j = 0; j < num; j++) {
                char brackets = st.charAt(j);

                if (brackets == '.') {
                    if (!stack.isEmpty()) {
                        flag = false;
                    }
                    break;
                } else if ((brackets == ')' || brackets == ']') && stack.isEmpty()) {
                    flag = false;
                    break;
                } else if (brackets == '(' || brackets == '[') {
                    stack.push(brackets);
                } else if (brackets == ')') {
                    if (stack.peek() != '(') {
                        flag = false;
                        break;
                    } else {
                        stack.pop();
                    }
                } else if (brackets == ']') {
                    if (stack.peek() != '[') {
                        flag = false;
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }

            if (stack.isEmpty() && flag) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}