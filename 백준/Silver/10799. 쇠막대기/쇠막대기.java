import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] list = br.readLine().split("");

        Stack<String> stack = new Stack<>();

        int result = 0;

        for (int i = 0; i < list.length; i++) {
            if (Objects.equals(list[i], "(")) {
                stack.push(list[i]);
            } else {
                stack.pop();
                if (Objects.equals(list[i-1], "(") && Objects.equals(list[i], ")")) {
                    result += stack.size();
                } else {
                    result++;
                }
            }
        }

        System.out.println(result);
    }
}