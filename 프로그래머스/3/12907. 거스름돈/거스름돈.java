import java.util.Arrays;

class Solution {
    public int solution(int n, int[] money) {
        int answer = 0;
        
         int count = 0;

        Arrays.sort(money);

        int[][] result = new int[money.length][n + 1];

         for (int i = 1; i < n + 1; i++) {
            if (i % money[0] == 0) {
                result[0][i] = 1;
            } else {
                result[0][i] = 0;
            }
        }

        for (int j = 0; j < money.length; j++) {
            result[j][0] = 1;
        }

        for (int i = 1; i < money.length; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (j < money[i]) {
                    result[i][j] = result[i - 1][j];
                } else {
                    result[i][j] = result[i - 1][j] + result[i][j - money[i]];
                }
            }
        }

        answer = result[money.length-1][n];
        
        return answer % 1000000007;
    }
}