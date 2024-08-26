import java.util.*;
import java.io.*;

class Main {
    static final int[] dr = {-1,1,0,0};   // 상하좌우
    static final int[] dc = {0,0,-1,1};

    static int N;
    static int[][] arr;

    static class Pos {
        int row;
        int col;

        public Pos(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for(int i = 0; i < N; i++) {
            char[] tmp = br.readLine().toCharArray();
            
            for(int j = 0; j < N; j++) {
                arr[i][j] = tmp[j] - '0';
            }
        }
    }

    static void solve() {
        Queue<Pos> queue = new ArrayDeque<>();
        ArrayList<Integer> groups = new ArrayList<>();
        StringBuilder ans = new StringBuilder();

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(arr[i][j] == 1) {
                    int cnt = 1;
                    queue.add(new Pos(i, j));
                    arr[i][j] = 0;

                    while(!queue.isEmpty()) {
                        Pos cur = queue.poll();

                        for(int d = 0; d < 4; d++) {
                            int nr = cur.row + dr[d];
                            int nc = cur.col + dc[d];

                            if(nr < 0 || nr >= N || nc < 0 || nc >= N || arr[nr][nc] == 0) {
                                continue;
                            }

                            queue.add(new Pos(nr, nc));
                            cnt++;
                            arr[nr][nc] = 0;
                        }
                    }

                    groups.add(cnt);
                }
            }
        }

        Collections.sort(groups);
        
        ans.append(groups.size()).append("\n");
        for(int cnt : groups) {
            ans.append(cnt).append("\n");
        }

        System.out.print(ans);
    }
}
