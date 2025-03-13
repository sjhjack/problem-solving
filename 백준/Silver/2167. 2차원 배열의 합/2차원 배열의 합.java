import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static int[][] prefSum;
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        prefSum = new int[N + 1][M + 1];

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int sum = 0;

            for(int j = 1; j <= M; j++) {
                sum += Integer.parseInt(st.nextToken());
                prefSum[i][j] = prefSum[i - 1][j] + sum;
            }
        }
    }

    static void solve() throws IOException {
        StringBuilder ans = new StringBuilder();
        int K = Integer.parseInt(br.readLine());

        for(int k = 0; k < K; k++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            ans.append(prefSum[x][y] - prefSum[x][j-1] - prefSum[i-1][y] + prefSum[i-1][j-1]).append("\n");
        }

        System.out.print(ans);
    }
}
