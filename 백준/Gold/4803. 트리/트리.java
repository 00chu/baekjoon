import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = 0;

        while (true) {
            count++;

            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int result = 0;

            if (n == 0 && m == 0) {
                break;
            } else if (m == 0) {
                result = n;
            } else {
                boolean[] used = new boolean[n + 1];

                ArrayList<ArrayList<Integer>> arr = new ArrayList<>();

                for (int i = 0; i < m; i++) {
                    st = new StringTokenizer(br.readLine());

                    int num1 = Integer.parseInt(st.nextToken());
                    int num2 = Integer.parseInt(st.nextToken());

                    if (i == 0) {
                        ArrayList<Integer> temp = new ArrayList<>();
                        temp.add(num1);
                        temp.add(num2);

                        used[num1] = true;
                        used[num2] = true;

                        arr.add(temp);
                    } else {
                        if (used[num1] && used[num2]) {
                            int num1Index = 1000;
                            int num2Index = 1000;

                            for (int j = 0; j < arr.size(); j++) {
                                ArrayList<Integer> temp = arr.get(j);
                                if (temp.contains(num1)) {
                                    num1Index = j;
                                }
                                if (temp.contains(num2)) {
                                    num2Index = j;
                                }
                            }
                            if (num1Index != 1000 && num2Index != 1000) {
                                if (num1Index != num2Index) {
                                    arr.get(num1Index).addAll(arr.get(num2Index));
                                    arr.remove(num2Index);
                                } else {
                                    arr.remove(num1Index);
                                }
                            } else if (num1Index != 1000) {
                                arr.remove(num1Index);
                            }
                            else if (num2Index != 1000) {
                                arr.remove(num2Index);
                            }
                        } else if (!used[num1] && !used[num2]) {
                            ArrayList<Integer> temp = new ArrayList<>();
                            temp.add(num1);
                            temp.add(num2);

                            used[num1] = true;
                            used[num2] = true;

                            arr.add(temp);
                        } else if (used[num1] && !used[num2]) {
                            used[num2] = true;
                            for (int j = 0; j < arr.size(); j++) {
                                if (arr.get(j).contains(num1)) {
                                    arr.get(j).add(num2);
                                    break;
                                }
                            }
                        } else if (!used[num1] && used[num2]) {
                            used[num1] = true;
                            for (int j = 0; j < arr.size(); j++) {
                                if (arr.get(j).contains(num2)) {
                                    arr.get(j).add(num1);
                                    break;
                                }
                            }
                        } else {
                            for (int j = 0; j < arr.size(); j++) {
                                if (arr.get(j).contains(num1)) {
                                    arr.get(j).add(num2);
                                    used[num2] = true;
                                    break;
                                }
                                if (arr.get(j).contains(num2)) {
                                    arr.get(j).add(num1);
                                    used[num1] = true;
                                    break;
                                }
                            }
                        }
                    }
                }

                for (int i = 1; i <= n; i++) {
                    if (!used[i]) {
                        result++;
                    }
                }

                result += arr.size();
            }

            if (result == 0) {
                System.out.println("Case " + count + ": No trees.");
            } else if (result == 1) {
                System.out.println("Case " + count + ": There is one tree.");
            } else {
                System.out.println("Case " + count + ": A forest of " + result + " trees.");
            }
        }
    }
}