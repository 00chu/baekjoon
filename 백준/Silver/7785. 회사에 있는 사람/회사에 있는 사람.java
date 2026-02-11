import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        HashMap<String,String> list =  new HashMap<String,String>();

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String state = st.nextToken();

            if(Objects.equals(state, "enter")){
                list.put(name, state);
            }
            else{
                list.remove(name);
            }
        }

        ArrayList<String> nameList = new ArrayList<String>(list.keySet());

        nameList.sort(Comparator.reverseOrder());

        for(String name: nameList){
            System.out.println(name);
        }
    }
}