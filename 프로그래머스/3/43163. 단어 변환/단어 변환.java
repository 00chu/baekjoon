class Solution {
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
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        boolean flag1 = false;

        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(target)) {
                flag1 = true;
            }
        }

        if (flag1) {
            for (int i = 0; i < words.length; i++) {
                if (check(begin, words[i])) {
                    begin = words[i];
                    answer++;
                }
                if (check(words[i], target)) {
                    answer++;
                    break;
                }

                if (begin.equals(target)) {
                    break;
                } else if (i == words.length - 1) {
                    if (!begin.equals(target)) {
                        answer = 0;
                        break;
                    }
                }
            }
        } else {
            answer = 0;
        }
        
        return answer;
    }
}