import java.io.*;
import java.util.*;

class Main {
    static final int INF = 100;
    
    static int N, minDist;
    static int[][] dist;
    static List<Integer> list;
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        dist = new int[N + 1][N + 1];

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                if(i == j) {
                    dist[i][j] = 0;
                } else {
                    dist[i][j] = INF;
                }
            }
        }

        while(true) {
            String s = br.readLine();

            if(s.equals("-1 -1")) {
                break;
            }

            StringTokenizer st = new StringTokenizer(s);
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            dist[from][to] = 1;
            dist[to][from] = 1;
        }
    }

    static void solve() {
        calcScore();
        findCandidates();        
    }

    static void calcScore() {
        for(int k = 1; k <= N; k++) {
            for(int i = 1; i <= N; i++) {
                for(int j = 1; j <= N; j++) {
                    if(i == j) {
                        continue;
                    }

                    if(dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
    }

    static void findCandidates() {
        list = new ArrayList<>();
        minDist = INF;

        for(int i = 1; i <= N; i++) {
            int max = 0;
            for(int j = 1; j <= N; j++) {
                max = Math.max(max, dist[i][j]);
            }

            if(max < minDist) {
                minDist = max;
                list = new ArrayList<>();
                list.add(i);
            } else if(max == minDist) {
                list.add(i);
            }
        }
    }

    static void print() {
        StringBuilder ans = new StringBuilder();
        ans.append(minDist).append(" ").append(list.size()).append("\n");

        for(int number : list) {
            ans.append(number).append(" ");
        }

        System.out.print(ans);
    }
}
