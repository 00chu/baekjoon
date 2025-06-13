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
            int temp = 0;
            if (Objects.equals(list[i], "(") || Objects.equals(list[i], "[")) {
                stack.push(list[i]);
            } else {
                while (!stack.isEmpty() && !Objects.equals(stack.peek(), "(") && !Objects.equals(stack.peek(), "[")) {
                    temp += Integer.parseInt(stack.pop());
                }
                if (!stack.isEmpty()) {
                    if (Objects.equals(stack.peek(), "(") && Objects.equals(list[i], ")")) {
                        stack.pop();
                        if (temp == 0) {
                            stack.push("2");
                        } else {
                            stack.push(String.valueOf(temp * 2));
                        }
                    } else if (Objects.equals(stack.peek(), "[") && Objects.equals(list[i], "]")) {
                        stack.pop();
                        if (temp == 0) {
                            stack.push("3");
                        } else {
                            stack.push(String.valueOf(temp * 3));
                        }
                    } else {
                        System.out.println(0);
                        return;
                    }
                }else{
                    System.out.println(0);
                    return;
                }
            }
            if (i == list.length - 1) {
                while (!stack.isEmpty()) {
                    String s = stack.pop();
                    if (Objects.equals(s, "(") || Objects.equals(s, "[")) {
                        System.out.println(0);
                        return;
                    }
                    result += Integer.parseInt(s);
                }
            }

        }

        System.out.println(result);
    }
}