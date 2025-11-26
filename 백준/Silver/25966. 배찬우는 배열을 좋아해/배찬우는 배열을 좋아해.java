import java.io.*;
import java.util.*;

class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N, M, Q;
    static int[][] arr;
    static int[] rownum;
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    static void init() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        rownum = new int[N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++) {
            rownum[i] = i;
        }
    }

    static void solve() throws IOException {
        for(int q = 0; q < Q; q++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            if(command == 0) {
                arr[rownum[i]][j] = Integer.parseInt(st.nextToken());
            } else {
                int tmp = rownum[i];
                rownum[i] = rownum[j];
                rownum[j] = tmp;
            }
        }
    }

    static void print() {
        StringBuilder ans = new StringBuilder();

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                ans.append(arr[rownum[i]][j]).append(" ");
            }
            ans.append("\n");
        }

        System.out.print(ans);
    }
}
