import java.io.*;
import java.util.*;

class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    static int N, M;
    static int[] parent;
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        
        parent = new int[N + 1];

        for(int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        for(int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            for(int j = 1; j <= N; j++) {
                int now = Integer.parseInt(st.nextToken());

                if(now == 1) {
                    union(i, j);
                }
            }
        }
    }

    static void solve() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = find(Integer.parseInt(st.nextToken()));
        boolean yesFlag = true;

        for(int i = 0; i < M - 1; i++) {
            int now = Integer.parseInt(st.nextToken());
            
            if(find(now) != start) {
                yesFlag = false;
                break;
            }
        }

        System.out.print(yesFlag ? "YES" : "NO");
    }

    static int find(int x) {
        if(parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x != y) {
            parent[x] = y;
        }
    }
}
