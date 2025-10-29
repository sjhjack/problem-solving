import java.io.*;
import java.util.*;

class Main {
    static final int[] dr = {-1,1,0,0};   // 상하좌우
    static final int[] dc = {0,0,-1,1};
    static final Map<Character, Integer> indexMap = Map.of(
        'N', 0,
        'S', 1,
        'W', 2,
        'E', 3
    );

    static int N, M;
    static char[][] arr;
    static int[][] group;
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new char[N][M];
        group = new int[N][M];

        for(int i = 0; i < N; i++) {
            char[] tmp = br.readLine().toCharArray();

            for(int j = 0; j < M; j++) {
                arr[i][j] = tmp[j];
            }
        }
    }

    static void solve() {
        int groupNumber = 1;
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(group[i][j] > 0) {
                    continue;
                }

                int cycleGroup = dfs(i, j, groupNumber);

                if(cycleGroup == groupNumber) {
                    groupNumber++;
                }
            }
        }

        System.out.print(groupNumber - 1);
    }

    static int dfs(int row, int col, int groupNumber) {
        if(group[row][col] > 0) {
            return group[row][col];
        }

        group[row][col] = groupNumber;

        int nr = row + dr[indexMap.get(arr[row][col])];
        int nc = col + dc[indexMap.get(arr[row][col])];
        int cycleGroup = dfs(nr, nc, groupNumber);

        if(groupNumber != cycleGroup) {
            group[row][col] = cycleGroup;
            return cycleGroup;
        } else {
            return groupNumber;
        }
    }
}
