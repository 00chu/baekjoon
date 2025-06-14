import javax.swing.text.DefaultStyledDocument;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] list = br.readLine().split("");

        Stack<String> left = new Stack<>();
        Stack<String> right = new Stack<>();

        if (list.length < 4) {
            if (list.length == 1 && Objects.equals(list[0], "P")) {
                System.out.println("PPAP");
                return;
            } else {
                System.out.println("NP");
                return;
            }
        }
        for (int i = 0; i < list.length; i++) {
            left.push(list[i]);

            if (4 <= left.size()) {
                int count = 0;

                for (int j = 0; j < 4; j++) {
                    String s = left.pop();
                    right.push(s);
                    if ((j != 1 && Objects.equals(s, "P")) || (j == 1 && Objects.equals(s, "A"))) {
                        count++;
                    } else {
                        break;
                    }
                }

                if (count == 4) {
                    if (i != list.length - 1) {
                        left.push("P");
                        right.clear();
                    }
                } else {
                    while (!right.isEmpty()) {
                        left.push(right.pop());
                    }
                }
            }
        }

        if (left.isEmpty()) {
            System.out.println("PPAP");
        } else {
            System.out.println("NP");
        }
    }
}