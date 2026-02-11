import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Integer[][] xCoordinates = new Integer[2][2];
        Integer[][] yCoordinates = new Integer[2][2];
        int x = 0, y = 0;

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                xCoordinates[i][j] = 0;
                yCoordinates[i][j] = 0;
            }
        }

        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int xTemp = Integer.parseInt(st.nextToken());
            int yTemp = Integer.parseInt(st.nextToken());


            if (xCoordinates[0][0] == xTemp || xCoordinates[0][0] == 0) {
                xCoordinates[0][0] = xTemp;
                xCoordinates[0][1]++;
            } else {
                xCoordinates[1][0] = xTemp;
                xCoordinates[1][1]++;
            }
            if (yCoordinates[0][0] == yTemp || yCoordinates[0][0] == 0) {
                yCoordinates[0][0] = yTemp;
                yCoordinates[0][1]++;
            } else {
                yCoordinates[1][0] = yTemp;
                yCoordinates[1][1]++;
            }

        }

        if (xCoordinates[0][1] != 2) {
            x = xCoordinates[0][0];
        } else {
            x = xCoordinates[1][0];
        }
        if (yCoordinates[0][1] != 2) {
            y = yCoordinates[0][0];
        } else {
            y = yCoordinates[1][0];
        }

        System.out.println(x + " " + y);
    }
}