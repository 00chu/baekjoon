class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        
        int[][] ground = new int[n][m];

        for (int i = 0; i < puddles.length; i++) {
            ground[puddles[i][1] - 1][puddles[i][0] - 1] = -1;
        }

        int num = 1;
        for (int i = 0; i < n; i++) {
            if (ground[i][0] == -1) {
                num = 0;
            }
            ground[i][0] = num;
        }

        num = 1;
        for (int i = 0; i < m; i++) {
            if (ground[0][i] == -1) {
                num = 0;
            }
            ground[0][i] = num;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (ground[i][j] == -1) {
                    ground[i][j] = 0;
                } else {
                    ground[i][j] = (ground[i - 1][j] + ground[i][j - 1]) % 1000000007;
                }
            }
        }

        answer = ground[n - 1][m - 1] % 1000000007;
        
        return answer;
    }
}