import java.io.*;
import java.util.*;

class Main {
    static final int[] dr = {-1,1,0,0};   // 상하좌우
    static final int[] dc = {0,0,-1,1};

    static int M, N, K;
    static boolean[][] isVisited;

    static class Pos {
        int row;
        int col;

        public Pos(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        isVisited = new boolean[M][N];

        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for(int j = y1; j < y2; j++) {
                for(int k = x1; k < x2; k++) {
                    isVisited[j][k] = true;
                }
            }
        }
    }

    static void solve() {
        List<Integer> areaSize = new ArrayList<>();
        StringBuilder ans = new StringBuilder();

        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                if(!isVisited[i][j]) {
                    int count = bfs(i, j);
                    areaSize.add(count);
                }
            }
        }

        Collections.sort(areaSize);
        
        ans.append(areaSize.size()).append("\n");

        for(int size : areaSize) {
            ans.append(size).append(" ");
        }

        System.out.print(ans);
    }

    static int bfs(int row, int col) {
        Queue<Pos> queue = new ArrayDeque<>();
        int count = 1;

        queue.add(new Pos(row, col));
        isVisited[row][col] = true;

        while(!queue.isEmpty()) {
            Pos cur = queue.poll();

            for(int d = 0; d < 4; d++) {
                int nr = cur.row + dr[d];
                int nc = cur.col + dc[d];

                if(nr < 0 || nr >= M || nc < 0 || nc >= N || isVisited[nr][nc]) {
                    continue;
                }

                queue.add(new Pos(nr, nc));
                isVisited[nr][nc] = true;
                count++;
            }
        }

        return count;
    }
}
