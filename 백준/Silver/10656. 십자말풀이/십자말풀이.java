import java.io.*;
import java.util.*;

class Main {
    static int N, M;
    static char[][] arr;
    
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

        for(int i = 0; i < N; i++) {
            arr[i] = br.readLine().toCharArray();
        }
    }

    static void solve() {
        StringBuilder ans = new StringBuilder();
        int count = 0;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(arr[i][j] == '#') {
                    continue;
                }

                if(isPossible(i, j)) {
                    count++;
                    ans.append(i + 1).append(" ").append(j + 1).append("\n");
                }
            }
        }

        System.out.print(count + "\n" + ans);
    }

    static boolean isPossible(int row, int col) {
        return isRowPossible(row, col) || isColPossible(row, col);
    }

    static boolean isRowPossible(int row, int col) {
        return (row - 1 < 0 || arr[row - 1][col] == '#')
            && row + 2 < N && arr[row + 1][col] == '.' && arr[row + 2][col] == '.';
    }

    static boolean isColPossible(int row, int col) {
        return (col - 1 < 0 || arr[row][col - 1] == '#')
            && col + 2 < M && arr[row][col + 1] == '.' && arr[row][col + 2] == '.';
    }
}
