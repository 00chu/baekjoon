import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Objects;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        Stack<Integer> stack = new Stack<Integer>();

        Integer[] result = new Integer[N];
        Integer[] list = new Integer[1000001];

        for (int i = N - 1; i >= 0; i--) {
            int num = Integer.parseInt(st.nextToken());
            result[i] = num;
            if(list[num]==null){
                list[num]=1;
            }else{
                list[num]++;
            }
        }

        for (int i = 0; i < N; i++) {
            if (i == 0) {
                stack.push(result[i]);
                result[i] = -1;
            } else {
                while (!stack.isEmpty() && list[ result[i]] >= list[stack.peek()]) {
                    stack.pop();
                }
                if (i < N - 1 && !stack.isEmpty() && list[ result[i]] > list[result[i+1]]) {
                    stack.push(result[i]);
                    result[i] = stack.get(stack.size() - 2);
                } else {
                    if (!stack.isEmpty() && list[result[i]] < list[stack.peek()]) {
                        result[i] = stack.peek();
                    } else {
                        stack.push(result[i]);
                        result[i] = -1;
                    }
                }
            }
        }

        for (int i = N - 1; i >= 0; i--) {
            sb.append(result[i]).append(" ");
        }

        System.out.println(sb);
    }
}