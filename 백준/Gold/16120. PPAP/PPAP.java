import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] list = br.readLine().split("");

        Stack<String> stack = new Stack<>();

        if (list.length < 4) {
            if (list.length == 1 && Objects.equals(list[0], "P")) {
                System.out.println("PPAP");
            } else {
                System.out.println("NP");
            }
            return;
        }
        for (int i = 0; i < list.length; i++) {
            stack.push(list[i]);

            while (stack.size() > 3
                    && Objects.equals(stack.get(stack.size() - 4), "P")
                    && Objects.equals(stack.get(stack.size() - 3), "P")
                    && Objects.equals(stack.get(stack.size() - 2), "A")
                    && Objects.equals(stack.peek(), "P")) {
                stack.pop();
                stack.pop();
                stack.pop();
                if (stack.size() == 1 && i == list.length - 1) {
                    stack.pop();
                }
            }
        }

        if (stack.isEmpty()) {
            System.out.println("PPAP");
        } else {
            System.out.println("NP");
        }
    }
}