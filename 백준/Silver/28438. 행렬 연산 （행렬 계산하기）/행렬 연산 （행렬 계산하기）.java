import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        int[] row = new int[N + 1];
        int[] col = new int[M + 1];

        for(int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int q = Integer.parseInt(st.nextToken());
            int rc = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            if(q == 1) {
                row[rc] += v;
            } else {
                col[rc] += v;
            }
        }

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= M; j++) {
                ans.append(row[i] + col[j]).append(" ");
            }

            ans.append("\n");
        }

        System.out.print(ans);
    }
}