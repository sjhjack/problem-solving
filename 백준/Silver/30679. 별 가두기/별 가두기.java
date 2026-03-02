import java.io.*;
import java.util.*;

class Main {
    static final int[] dr = {0,1,0,-1};   // 우하좌상
    static final int[] dc = {1,0,-1,0};
    
    static int N, M;
    static int[][] arr;
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void solve() {
        StringBuilder ans = new StringBuilder();
        List<Integer> ansList = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            boolean[][][] isVisited = new boolean[N][M][4];
            int row = i;
            int col = 0;
            int dir = 0;   // 오른쪽

            while(true) {
                int distance = arr[row][col];
                row += dr[dir] * distance;
                col += dc[dir] * distance;

                if(outOfBound(row, col)) {
                    break;
                }

                if(isVisited[row][col][dir]) {
                    ansList.add(i + 1);
                    break;
                }

                isVisited[row][col][dir] = true;
                dir = (dir + 1) % 4;
            }
        }

        ans.append(ansList.size()).append("\n");

        for(int ansRow : ansList) {
            ans.append(ansRow).append(" ");
        }

        System.out.print(ans);
    }

    static boolean outOfBound(int row, int col) {
        return row < 0 || row >= N || col < 0 || col >= M;
    }
}
