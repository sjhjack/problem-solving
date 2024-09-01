import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] position = new int[3][2];

        for(int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            position[i][0] = Integer.parseInt(st.nextToken());
            position[i][1] = Integer.parseInt(st.nextToken());
        }

        int x = position[0][0] ^ position[1][0] ^ position[2][0];
        int y = position[0][1] ^ position[1][1] ^ position[2][1];

        System.out.print(x + " " + y);
    }
}