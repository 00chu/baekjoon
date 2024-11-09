import java.util.Arrays;

class Solution {
    public int[] solution(int n, int s) {
        int[] answer = {};
        
       if (s < n) {
            answer = new int[]{-1};
        } else {
            int[] temp = new int[n];
            for (int i = 0; i < n; i++) {
                temp[i] = s / n;
            }
            for (int i = 0; i < s % n; i++) {
                temp[i] = temp[i] + 1;
            }
            Arrays.sort(temp);

            answer = temp;
        }
        
        return answer;
    }
}