import java.util.Arrays;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        Arrays.sort(times);

       long start = 0;
        long end = (long) times[times.length - 1] * n;

        while (start <= end) {
            long count = 0;
            long mid = (start + end) / 2;

            for (int i = 0; i < times.length; i++) {
                count += mid / times[i];
                if (count > n) break;
            }

            if (count >= n) {
                end = mid - 1;
                answer = mid;
            } else {
                start = mid + 1;
            }
        }
        
        return answer;
    }
}