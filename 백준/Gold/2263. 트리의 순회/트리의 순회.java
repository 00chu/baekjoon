import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static int[] inorder;
    public static int[] postorder;
    public static int[] preorder;
    public static int index = 0;

    public static void tree(int il, int ir, int pl, int pr) {
        if (il <= ir && pl <= pr) {
            preorder[index++] = postorder[pr];

            int num = il;
            for (int i = il; i <= ir; i++) {
                if (inorder[i] == postorder[pr]) {
                    num = i;
                    break;
                }
            }

            tree(il, num - 1, pl, pl + num -il - 1);
            tree(num + 1, ir, pl + num - il, pr - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        inorder = new int[n];
        postorder = new int[n];
        preorder = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            inorder[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            postorder[i] = Integer.parseInt(st.nextToken());
        }

        tree(0, n - 1, 0, n - 1);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < n; i++) {
            bw.write(preorder[i] + " ");
        }

        bw.flush();
    }
}