import java.util.PriorityQueue;
import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        PriorityQueue<Integer> min = new PriorityQueue<Integer>();
        PriorityQueue<Integer> max = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -Integer.compare(o1, o2);
            }
        });
    
        
        for (String s : operations) {
            String[] temp = s.split(" ");

            if (Objects.equals(temp[0], "I")) {
                min.add(Integer.parseInt(temp[1]));
                max.add(Integer.parseInt(temp[1]));
            } else {
                if (Objects.equals(temp[1], "1")) {
                    min.remove(max.poll());
                } else {
                    max.remove(min.poll());
                }
            }
        }

        if (!max.isEmpty()) {
            answer[0] = max.poll();
        }

        if (!min.isEmpty()) {
            answer[1] = min.poll();
        }
        
        
        return answer;
    }
}