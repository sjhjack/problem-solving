import java.io.*;
import java.util.*;

class Main {
    static final int INF = 100_000_000;
    static int V, E;
    static int[][] arr;
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        arr = new int[V + 1][V + 1];

        for(int i = 1; i <= V; i++) {
            for(int j = 1; j <= V; j++) {
                if(i == j) {
                    arr[i][j] = 0;
                } else {
                    arr[i][j] = INF;
                }
            }
        }

        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());

            arr[from][to] = length;
        }
    }

    static void solve() {
        for(int k = 1; k <= V; k++) {
            for(int i = 1; i <= V; i++) {
                for(int j = 1; j <= V; j++) {
                    if(i == j) {
                        continue;
                    }
                    
                    arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                }
            }
        }

        int min = INF;

        for(int i = 1; i <= V; i++) {
            for(int j = 1; j <= V; j++) {
                if(i != j && arr[i][j] != INF && arr[j][i] != INF) {
                    // i -> j , j -> i 가능한 경우 (사이클)
                    min = Math.min(min, arr[i][j] + arr[j][i]);
                }
            }
        }

        System.out.print(min == INF ? -1 : min);
    }
}
