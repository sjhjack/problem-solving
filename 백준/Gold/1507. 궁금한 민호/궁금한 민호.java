import java.io.*;
import java.util.*;

class Main {
    static final int INF = 1_000_000_000;
    static int N;
    static int[][] arr;
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void solve() {
        int[][] dist = new int[N][N];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(i == j) dist[i][j] = 0;
                else dist[i][j] = INF;
            }
        }

        for(int k = 0; k < N; k++) {
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(i == j) continue;
                    dist[i][j] = Math.min(dist[i][j], arr[i][k] + arr[k][j]);
                }
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(arr[i][j] != dist[i][j]) {
                    System.out.print(-1);
                    return;
                }
            }
        }
        
        for(int k = 0; k < N; k++) {
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(i == j || i == k || j == k) continue;

                    if(arr[i][j] == arr[i][k] + arr[k][j]) {
                        dist[i][j] = 0;
                    }
                }
            }
        }

        int ans = 0;
        for(int i = 0; i < N; i++) {
            for(int j = i + 1; j < N; j++) {
                ans += dist[i][j];
            }
        }

        System.out.print(ans);
    }
}
