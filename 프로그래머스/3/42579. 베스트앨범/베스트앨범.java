import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        
        ArrayList<Integer> answerTemp = new ArrayList<>();

        HashMap<String, Integer> genresList = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            if (genresList.containsKey(genres[i])) {
                genresList.replace(genres[i], genresList.get(genres[i]) + plays[i]);
            } else {
                genresList.put(genres[i], plays[i]);
            }
        }

        HashMap<String, HashMap<Integer, Integer>> list = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            if (list.containsKey(genres[i])) {
                list.get(genres[i]).put(i, plays[i]);

            } else {
                HashMap<Integer, Integer> temp = new HashMap<>();
                temp.put(i, plays[i]);
                list.put(genres[i], temp);
            }
        }

        ArrayList<String> keySet = new ArrayList<>(genresList.keySet());
        Collections.sort(keySet, (s1, s2) -> genresList.get(s2) - (genresList.get(s1)));

        for (int i = 0; i < genresList.size(); i++) {
            HashMap<Integer, Integer> temp = list.get(keySet.get(i));
            ArrayList<Integer> musicTemp = new ArrayList<>(temp.keySet());
            Collections.sort(musicTemp, (s1, s2) -> temp.get(s2) - (temp.get(s1)));

            if (musicTemp.size() >= 2) {
                answerTemp.add(musicTemp.get(0));
                answerTemp.add(musicTemp.get(1));
            } else {
                answerTemp.add(musicTemp.get(0));
            }
        }

        answer = answerTemp.stream().mapToInt(i -> i).toArray();
        
        return answer;
    }
}