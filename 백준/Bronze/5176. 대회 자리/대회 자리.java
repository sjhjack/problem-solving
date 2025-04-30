import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            boolean[] isVisited = new boolean[M + 1];
            int count = 0;

            for(int i = 0; i < P; i++) {
                int seat = Integer.parseInt(br.readLine());
                
                if(isVisited[seat]) {
                    count++;
                } else {
                    isVisited[seat] = true;
                }
            }

            ans.append(count).append("\n");
        }

        System.out.print(ans);
    }
}