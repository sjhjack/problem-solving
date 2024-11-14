import java.io.*;
import java.util.*;

class Main {
    static int N, M;
    static int[][] arr;
    static int ans;
    
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
            char[] tmp = br.readLine().toCharArray();

            for(int j = 0; j < M; j++) {
                arr[i][j] = tmp[j] - '0';
            }
        }
    }

    static void solve() {
        ans = 0;
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                findMaxLength(i, j);
            }
        }

        ans++;
        System.out.print(ans * ans);
    }

    static void findMaxLength(int row, int col) {
        for(int i = ans + 1; row+i < N && col+i < M; i++) {
            if(arr[row][col] == arr[row][col + i] && arr[row][col] == arr[row + i][col] && arr[row][col] == arr[row + i][col + i]) {
                ans = i;
            }
        }
    }
}
