import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[][] arr = new int[10][10];
    private static int[] paper = {0, 5, 5, 5, 5, 5};
    private static int totalArea;
    private static int ans;

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void input() throws IOException {
        for(int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 10; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                if(arr[i][j] == 1) {
                    totalArea++;
                }
            }
        }
    }

    private static void solve() {
        ans = Integer.MAX_VALUE;
        dfs(0, 0, 0, 0);

        if(ans == Integer.MAX_VALUE) {
            System.out.print(-1);
        } else {
            System.out.print(ans);
        }
    }

    private static void dfs(int row, int col, int cnt, int attatchedArea) {
        // 완탐 종료
        if(attatchedArea == totalArea || (row >= 9 && col > 9)) {
            ans = Math.min(ans, cnt);
            return;
        }

        // 백트래킹
        if(cnt >= ans) {
            return;
        }

        // 다음 줄
        if(col > 9) {
            dfs(row + 1, 0, cnt, attatchedArea);
            return;
        }

        if(arr[row][col] == 1) {
            for(int len = 5; len >= 1; len--) {
                if(paper[len] > 0 && canAttatch(row, col, len)) {
                    changeState(row, col, len, 0);
                    paper[len]--;

                    dfs(row, col + 1, cnt + 1, attatchedArea + len * len);

                    changeState(row, col, len, 1);
                    paper[len]++;
                }
            }
        } else {
            dfs(row, col + 1, cnt, attatchedArea);
        }
    }

    private static boolean canAttatch(int row, int col, int len) {
        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len; j++) {
                if(row + i > 9 || col + j > 9 || arr[row + i][col + j] == 0) {
                    return false;
                }
            }
        }

        return true;
    }

    // state : 0 = 붙이기, 1 = 떼기
    private static void changeState(int row, int col, int len, int state) {
        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len; j++) {
                arr[row + i][col + j] = state;
            }
        }
    }

}
