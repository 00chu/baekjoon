import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static class Node {
        int row;
        int column;

        public Node(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }

    public static boolean[][] visited;
    public static int date = 0;

    public static void bfs(ArrayList<Node>[][] list, Integer[][] box, int M, int N) {
        Queue<Node> queue = new LinkedList<>();

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < M + 1; j++) {
                if (box[i][j] == 1) {
                    queue.offer(new Node(i, j));
                    visited[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            boolean check = false;
            int size = queue.size();
            Queue<Node> tempQueue = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                Node num = queue.poll();
                ArrayList<Node> temp = list[num.row][num.column];
                for (int j = 0; j < temp.size(); j++) {
                    if (!visited[temp.get(j).row][temp.get(j).column] && box[temp.get(j).row][temp.get(j).column] != -1) {
                        tempQueue.offer(new Node(temp.get(j).row, temp.get(j).column));
                        visited[temp.get(j).row][temp.get(j).column] = true;
                        box[temp.get(j).row][temp.get(j).column] = 1;
                        check = true;
                    }
                }
            }
            if (check) {
                date++;
            }
            queue.addAll(tempQueue);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        Integer[][] box = new Integer[N + 1][M + 1];
        ArrayList<Node>[][] list = new ArrayList[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];

        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < M + 1; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < M + 1; j++) {
                list[i][j] = new ArrayList<>();
            }
        }

        boolean flag1 = false;
        boolean flag2 = false;

        boolean flag3 = false;
        boolean flag4 = false;
        int count = 0;


        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < M + 1; j++) {
                flag1 = false;
                flag2 = false;
                if (box[i][j] == 1) {
                    count++;
                }

                if (i == 1) {
                    list[i][j].add(new Node(i + 1, j));
                    if (box[i][j] == 0 && box[i + 1][j] == -1) {
                        flag1 = true;
                    } else if (box[i][j] == 1 && box[i + 1][j] == -1) {
                        flag3 = true;
                    }
                } else if (i == N) {
                    list[i][j].add(new Node(i - 1, j));
                    if (box[i][j] == 0 && box[i - 1][j] == -1) {
                        flag1 = true;
                    } else if (box[i][j] == 1 && box[i - 1][j] == -1) {
                        flag3 = true;
                    }
                } else {
                    list[i][j].add(new Node(i + 1, j));
                    list[i][j].add(new Node(i - 1, j));
                    if (box[i][j] == 0 && box[i + 1][j] == -1 && box[i - 1][j] == -1) {
                        flag1 = true;
                    } else if (box[i][j] == 1 && box[i + 1][j] == -1 && box[i - 1][j] == -1) {
                        flag3 = true;
                    }
                }

                if (j == 1) {
                    list[i][j].add(new Node(i, j + 1));
                    if (flag1 && box[i][j + 1] == -1) {
                        flag2 = true;
                    } else if (box[i][j] == 1 && box[i][j + 1] == -1) {
                        flag4 = true;
                    }
                } else if (j == M) {
                    list[i][j].add(new Node(i, j - 1));
                    if (flag1 && box[i][j - 1] == -1) {
                        flag2 = true;
                    } else if (box[i][j] == 1 && box[i][j - 1] == -1) {
                        flag4 = true;
                    }
                } else {
                    list[i][j].add(new Node(i, j + 1));
                    list[i][j].add(new Node(i, j - 1));
                    if (flag1 && box[i][j + 1] == -1 && box[i][j - 1] == -1) {
                        flag2 = true;
                    } else if (box[i][j] == 1 && box[i][j + 1] == -1 && box[i][j - 1] == -1) {
                        flag4 = true;
                    }
                }

                if (flag1 && flag2) {
                    break;
                }
                if (flag3 && flag4) {
                    count--;
                }
            }
            if (flag1 && flag2) {
                break;
            }
        }

        boolean flag = false;

        if (flag1 && flag2 || count == 0) {
            date = -1;
        } else {
            bfs(list, box, M, N);
            for (int i = 1; i < N + 1; i++) {
                for (int j = 1; j < M + 1; j++) {
                    if (box[i][j] == 0) {
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    break;
                }
            }
        }

        if (flag) {
            date = -1;
        }

        System.out.println(date);
    }
}