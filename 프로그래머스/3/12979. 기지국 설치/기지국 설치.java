import java.util.ArrayList;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        
         double length = 1 + 2 * w;

        if (stations.length == 1) {
            if (stations[0] == 1 || stations[0] == n) {
                answer += Math.ceil((double)(n - 1 - w) / length);
            } else {
                answer += Math.ceil((double)(stations[0] - 1 - w) / length);
                answer += Math.ceil((double)(n - stations[0] - w) / length);
            }
        } else if (stations[0] == 1 && stations[1] == n) {
            answer += Math.ceil((double) (n - 2 - 2 * w) / length);
        } else {
            for (int i = 0; i < stations.length; i++) {
                if (stations[i] != 1 && i == 0) {
                    answer += Math.ceil((double) (stations[i] - 1 - w) / length);
                } else if (stations[i] != n && i == stations.length) {
                    answer += Math.ceil((double) (n - stations[i] - w) / length);
                } else if (stations[i] != 1) {
                    answer += Math.ceil((double) (stations[i] - stations[i - 1] - 1 - 2 * w) / length);
                    if (i == stations.length - 1) {
                        answer += Math.ceil((double) (n - stations[i] - w) / length);
                    }
                }
            }
        }
        return answer;
    }
}