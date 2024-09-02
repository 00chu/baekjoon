import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];

        int first = 0;
        int length = gems.length + 1;

        int num = new HashSet<>(Arrays.asList(gems)).size();

        HashMap<String, Integer> map = new HashMap<>();

        for (int last = 0; last < gems.length; last++) {
            map.put(gems[last], map.getOrDefault(gems[last], 0) + 1);

            while (map.get(gems[first]) > 1) {
                map.replace(gems[first], map.get(gems[first]) - 1);
                first++;
            }
            if (map.size() == num && length > (last - first)) {
                length = last - first;
                answer[0] = first + 1;
                answer[1] = last + 1;
            }
        }
        
        return answer;
    }
}