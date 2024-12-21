import java.util.Arrays;
import java.util.Objects;

class Solution {
    public int[] solution(String s) {
        int[] answer = {0, 0};

        while (true) {
            int c = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1') {
                    c++;
                }
            }
            answer[0]++;
            answer[1] += s.length() - c;
            if (c == 1) {
                break;
            }
            StringBuilder temp = new StringBuilder();
            boolean flag = true;

            while (flag) {
                temp.append(c % 2);
                c = c / 2;
                if (c == 0 || c == 1) {
                    temp.append(c);
                    flag = false;
                }
            }
            s = String.valueOf(temp.reverse());
        }
        return answer;
    }
}