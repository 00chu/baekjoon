import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        int sum = 0;

        PriorityQueue<Integer> list = new PriorityQueue<>(Collections.reverseOrder());

        for (int i : works) {
            list.offer(i);
            sum += i;
        }

         if (sum <= n) {
            answer = 0;
        } else {
            for (int i = 0; i < n; i++) {
                int num = list.poll();
                list.offer(num - 1);
            }
            int num = list.size();
            for (int i = 0; i < num; i++) {
                System.out.println(i);
                answer += (int) Math.pow(list.poll(), 2);
            }
        }
        
        return answer;
    }
}