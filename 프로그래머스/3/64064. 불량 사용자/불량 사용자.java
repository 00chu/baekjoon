import java.util.*;

class Solution {
    static HashSet<HashSet<String>> result = new HashSet<>();

    public static boolean check(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != '*'
                    && s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void dfs(HashSet<String> hash, ArrayList<ArrayList<String>> list, int num, int size) {
        if (hash.size() == size) {
            result.add(new HashSet<>(hash));
        }
        if (num < size) {
            ArrayList<String> temp = list.get(num);
            for (int i = 0; i < temp.size(); i++) {
                if (!hash.contains(temp.get(i))) {
                    hash.add(temp.get(i));
                    dfs(hash, list, num + 1, size);
                    hash.remove(temp.get(i));
                }
            }
        }
    }
    
    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        
        ArrayList<ArrayList<String>> list = new ArrayList<>();

        for (int i = 0; i < banned_id.length; i++) {
            ArrayList<String> temp = new ArrayList<>();
            for (int j = 0; j < user_id.length; j++) {
                if (check(banned_id[i], user_id[j])) {
                    temp.add(user_id[j]);
                }
            }
            list.add(temp);
        }

        dfs(new LinkedHashSet<>(), list, 0, banned_id.length);
        
        answer = result.size();
        
        return answer;
    }
}