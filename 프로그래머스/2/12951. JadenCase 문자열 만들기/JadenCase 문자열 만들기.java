import java.util.Arrays;

class Solution {
    public String solution(String s) {
        String answer = "";
        
       String[] temp = s.split("");
        System.out.println(Arrays.toString(temp));

        if (s.length() == 1 && Character.isLowerCase(s.charAt(0))) {
            temp[0] = temp[0].toUpperCase();
        } else {
            for (int i = 0; i < s.length() - 1; i++) {
                if (i == 0 && Character.isLowerCase(temp[i].charAt(0))) {
                    temp[i] = Character.toString(temp[i].charAt(0)).toUpperCase();
                }
                if (s.charAt(i) == ' ' && s.charAt(i + 1) != ' ' && Character.isLowerCase(s.charAt(i + 1))) {
                    temp[i+1] = Character.toString(temp[i + 1].charAt(0)).toUpperCase();
                }
                if (s.charAt(i) != ' ' && s.charAt(i + 1) != ' ' && Character.isUpperCase(s.charAt(i + 1))) {
                    temp[i+1] = Character.toString(temp[i + 1].charAt(0)).toLowerCase();
                }
            }
        }

        answer = String.join("", temp);
        
        return answer;
    }
}