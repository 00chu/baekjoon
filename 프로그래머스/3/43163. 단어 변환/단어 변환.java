class Solution {
    static boolean[] visited;
    static int answer = 51;

    public static boolean check(String s1, String s2) {
        int count = 0;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
            }
            if (count > 1) {
                return false;
            }
        }
        if (count == 0) {
            return false;
        }
        return true;
     }
     public static void dfs(String begin, String target, String[] words, int num) {
        if (begin.equals(target)) {
            answer = Math.min(answer, num);
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if (visited[i]) {
                continue;
            }

            if (check(begin, words[i])) {
                visited[i] = true;
                dfs(words[i], target, words, num + 1);
                visited[i] = false;
            }
        }
    }
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];

        dfs(begin, target, words, 0);
        
        if (answer == 51) {
            answer = 0;
        }
        
        return answer;
    }
}