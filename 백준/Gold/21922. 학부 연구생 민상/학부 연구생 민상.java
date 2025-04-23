import java.io.*;
import java.util.*;

class Main {
    static final int[] dr = {-1,0,1,0};    // 상우하좌
    static final int[] dc = {0,1,0,-1};
    
    static int N, M;
    static int[][] arr;
    static boolean[][] isVisited;
    static List<Pos> startList;

    static class Pos {
        int row;
        int col;
        int dir;

        public Pos(int row, int col, int dir) {
            this.row = row;
            this.col = col;
            this.dir = dir;
        }
    }
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        isVisited = new boolean[N][M];
        startList = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                
                if(arr[i][j] == 9) {
                    startList.add(new Pos(i, j, 0));
                }
            }
        }
    }

    static void solve() {
        for(Pos start : startList) {
            for(int d = 0; d < 4; d++) {
                bfs(start, d);
            }
            // bfs(start, 3);
        }
    }

    // dir : 에어컨에서 바람이 나오는 방향
    static void bfs(Pos start, int startDirection) {
        Queue<Pos> queue = new ArrayDeque<>();
        isVisited[start.row][start.col] = true;
        queue.add(new Pos(start.row, start.col, startDirection));

        while(!queue.isEmpty()) {
            Pos cur = queue.poll();
            int nr = cur.row + dr[cur.dir];
            int nc = cur.col + dc[cur.dir];

            // System.out.println("cur : " + cur.row + ", " + cur.col + ", dir : " + cur.dir);

            if(nr < 0 || nr >= N || nc < 0 || nc >= M || arr[nr][nc] == 9) {
                continue;
            }

            isVisited[nr][nc] = true;
            int nextDir = cur.dir;
            
            if(arr[nr][nc] == 1 && (cur.dir == 1 || cur.dir == 3)) {
                nextDir = (cur.dir + 2) % 4;
            } else if(arr[nr][nc] == 2 && (cur.dir == 0 || cur.dir == 2)) {
                nextDir = (cur.dir + 2) % 4;
            } else if(arr[nr][nc] == 3) {
                if(cur.dir % 2 == 0) {
                    nextDir = cur.dir + 1;
                } else {
                    nextDir = cur.dir - 1;
                }
            } else if(arr[nr][nc] == 4) {
                if(cur.dir == 0) nextDir = 3;
                else if(cur.dir == 3) nextDir = 0;
                else if(cur.dir == 1) nextDir = 2;
                else nextDir = 1;
            }

            queue.add(new Pos(nr, nc, nextDir));
        }
    }

    static void print() {
        int ans = 0;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                // if(isVisited[i][j][0] || isVisited[i][j][1] || isVisited[i][j][2] || isVisited[i][j][3]) {
                //     ans++;
                // }
                if(isVisited[i][j]) {
                    ans++;
                }
            }
        }

        System.out.print(ans);
    }
}
