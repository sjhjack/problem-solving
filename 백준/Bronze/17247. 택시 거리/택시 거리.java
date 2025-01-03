import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] pos1 = null;
        int[] pos2 = null;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < M; j++) {
                if(Integer.parseInt(st.nextToken()) == 1) {
                    if(pos1 == null) {
                        pos1 = new int[]{i, j};
                    } else {
                        pos2 = new int[]{i, j};
                    }
                }
            }
        }

        System.out.print(Math.abs(pos1[0] - pos2[0]) + Math.abs(pos1[1] - pos2[1]));
    }
}