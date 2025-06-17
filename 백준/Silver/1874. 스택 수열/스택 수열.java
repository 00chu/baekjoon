import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        StringBuilder sb = new StringBuilder();

        int index = 1;

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            while (index <= num && (stack.isEmpty() || num != stack.peek())) {
                stack.push(index++);
                sb.append("+\n");
            }

            if (!stack.isEmpty() && num == stack.peek()) {
                stack.pop();
                sb.append("-\n");
            } else if (index > num || (!stack.isEmpty() && num != stack.peek())) {
                System.out.println("NO");
                return;
            }
        }

        while (!stack.isEmpty()) {
            stack.pop();
            sb.append("-");
            if (!stack.isEmpty()) {
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }
}