import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;

        int K = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i <K; i++){
            int n = Integer.parseInt(br.readLine());

            if(n == 0){
                sum -= stack.pop();
            }
            else{
                stack.add(n);
                sum +=n;
            }
        }

        br.close();

        System.out.println(sum);
    }
}