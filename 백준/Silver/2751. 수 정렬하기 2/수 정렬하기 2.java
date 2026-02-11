import java.io.*;
import java.util.ArrayList;
import java.util.Collections;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //선언
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer> arr = new ArrayList<Integer>();

        for (int i = 0; i < n; i++) {
            arr.add(Integer.parseInt(br.readLine()));
        }

        br.close();
        
        Collections.sort(arr);

        for (int i : arr) {
            bw.write(i + "\n");
        }

        bw.flush();
        bw.close();
    }
}