import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(br.readLine());
        br.close();

        Stack<Integer> stack = new Stack<Integer>();
        int stick = 64;
        int count = 0;

        while(X!=0) {
            if(stick>X){
                stick/=2;
                if(stick<X){
                    stack.push(stick);
                }
            } else{
                X-=stick;
                if(!stack.isEmpty()){
                    stick=stack.pop();
                }
                count++;
            }
        }

        System.out.println(count);


    }
}