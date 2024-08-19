import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public String solution(String s) {
        String [] list = s.split(" ");

        ArrayList<Integer> arr = new ArrayList<>();
        
        for(String a: list){
            arr.add(Integer.parseInt(a));
        }

        Collections.sort(arr);

        String answer = arr.get(0)+" "+arr.get(list.length-1);

        return answer;
    }
}