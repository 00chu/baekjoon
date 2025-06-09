import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            String[] password = br.readLine().split("");

            Stack<String> left = new Stack<>();
            Stack<String> right = new Stack<>();

            for (int j = 0; j < password.length; j++) {
                if (Objects.equals(password[j], "<")) {
                    if (!left.isEmpty()) {
                        right.push(left.pop());
                    }
                } else if (Objects.equals(password[j], ">")) {
                    if (!right.isEmpty()) {
                        left.push(right.pop());
                    }
                } else if (Objects.equals(password[j], "-")) {
                    if (!left.isEmpty()) {
                        left.pop();
                    }
                } else {
                    left.push(password[j]);
                }
            }

            StringBuilder temp = new StringBuilder();

            while (!right.isEmpty()) {
                temp.append(right.pop());
            }
            temp.reverse();
            while (!left.isEmpty()) {
                temp.append(left.pop());
            }
            temp.reverse();

            sb.append(temp);
            if (i < T - 1) {
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}