class Solution {
    public String solution(String s) {
        String answer = "";
        
       if (s.length() == 1 && Character.isLowerCase(s.charAt(0))) {
            s = s.toUpperCase();
        } else {
            for (int i = 0; i < s.length() - 1; i++) {
                if (i == 0 && Character.isLowerCase(s.charAt(i))) {
                    s = s.substring(0, i) + Character.toString(s.charAt(i)).toUpperCase() + s.substring(i + 1);
                }
                if (s.charAt(i) == ' ' && s.charAt(i + 1) != ' ' && Character.isLowerCase(s.charAt(i + 1))) {
                    s = s.substring(0, i + 1) + Character.toString(s.charAt(i + 1)).toUpperCase() + s.substring(i + 2);
                }
                if (s.charAt(i) != ' ' && s.charAt(i + 1) != ' ' && Character.isUpperCase(s.charAt(i + 1))) {
                    s = s.substring(0, i + 1) + Character.toString(s.charAt(i + 1)).toLowerCase() + s.substring(i + 2);
                }
            }
        }

        answer = s;
        
        return answer;
    }
}