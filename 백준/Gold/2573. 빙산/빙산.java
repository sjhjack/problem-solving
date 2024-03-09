import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final int[] dr = {-1,1,0,0};     // 상하좌우
    private static final int[] dc = {0,0,-1,1};
    private static int N, M;
    private static int[][] map;
    private static Queue<Pos> queue = new ArrayDeque<>();
    private static int[][] afterOneYear;
    private static int ans;

    public static class Pos {
        int row;
        int col;

        public Pos(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] > 0){
                    queue.add(new Pos(i, j));
                }
            }
        }
    }

    private static void solve() {
        while(!queue.isEmpty()){
            afterOneYear = new int[N][M];
            ans++;

            meltingIce();
            sumResults();
            if(findGroups()){
                System.out.print(ans);
                return;
            }
        }

        System.out.print(0);
    }

    private static void meltingIce(){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] == 0){
                    for(int d = 0; d < 4; d++){
                        int nr = i + dr[d];
                        int nc = j + dc[d];

                        if(nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] == 0) continue;

                        afterOneYear[nr][nc]--;
                    }
                }
            }
        }
    }

    private static void sumResults(){
        for(int i = queue.size(); i > 0; i--){
            Pos cur = queue.poll();
            int row = cur.row;
            int col = cur.col;
            int result = map[row][col] + afterOneYear[row][col];

            if(result <= 0){
                map[row][col] = 0;
            } else {
                map[row][col] = result;
                queue.add(cur);
            }
        }
    }

    private static boolean findGroups(){
        boolean[][] isVisited = new boolean[N][M];
        boolean isFound = false;

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] > 0 && !isVisited[i][j]){
                    if(!isFound){
                        isFound = true;
                    } else {
                        return true;
                    }

                    Queue<Pos> q = new ArrayDeque<>();
                    q.add(new Pos(i, j));
                    isVisited[i][j] = true;

                    while(!q.isEmpty()){
                        Pos cur = q.poll();

                        for(int d = 0; d < 4; d++){
                            int nr = cur.row + dr[d];
                            int nc = cur.col + dc[d];

                            if(nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] == 0 || isVisited[nr][nc]) continue;

                            isVisited[nr][nc] = true;
                            q.add(new Pos(nr, nc));
                        }
                    }
                }
            }
        }

        return false;
    }
}
