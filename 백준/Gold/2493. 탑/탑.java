import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static class tower {
        int number;
        int height;

        tower(int number, int height) {
            this.number = number;
            this.height = height;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        Stack<tower> stack = new Stack<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            int num = Integer.parseInt(st.nextToken());

            while (true) {
                if (stack.isEmpty()) {
                    sb.append("0 ");
                    stack.push(new tower(i, num));
                    break;
                } else {
                    if (stack.peek().height < num) {
                        stack.pop();
                    } else {
                        sb.append(stack.peek().number).append(" ");
                        stack.push(new tower(i, num));
                        break;
                    }
                }
            }
        }

        System.out.println(sb);
    }
}