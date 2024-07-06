import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] result = br.readLine().split("");


        for (int i = 1; i < N; i++) {
            String[] temp = br.readLine().split("");
            for (int j = 0; j < result.length; j++){
                if(!result[j].equals(temp[j])){
                    result[j] = "?";
                }
            }
        }

        for(String s: result){
            System.out.print(s);
        }

        br.close();
    }
}