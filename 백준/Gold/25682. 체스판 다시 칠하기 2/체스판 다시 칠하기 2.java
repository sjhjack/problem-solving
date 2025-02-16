import java.io.*;
import java.util.*;

class Main {
    static int N, M, K;
    static char[][] board;
    static int[][] boardB, boardW;
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        board = new char[N + 1][M + 1];
        boardB = new int[N + 1][M + 1];
        boardW = new int[N + 1][M + 1];

        for(int i = 1; i <= N; i++) {
            char[] tmp = br.readLine().toCharArray();

            for(int j = 0; j < M; j++) {
                board[i][j + 1] = tmp[j];
            }
        }

        getPreSum(boardB, 'B');
        getPreSum(boardW, 'W');
    }

    static void getPreSum(int[][] targetBoard, char target) {
        for(int i = 1; i <= N; i++) {
            int count = 0;
            
            for(int j = 1; j <= M; j++) {
                if(i % 2 != 0) {
                    if(j % 2 != 0) {
                        count += board[i][j] == target ? 0 : 1;
                    } else {
                        count += board[i][j] != target ? 0 : 1;
                    }
                } else {
                    if(j % 2 == 0) {
                        count += board[i][j] == target ? 0 : 1;
                    } else {
                        count += board[i][j] != target ? 0 : 1;
                    }
                }

                targetBoard[i][j] = targetBoard[i - 1][j] + count;
            }
        }
    }

    static void solve() {
        int countB = 0;
        int countW = 0;
        int ans = Integer.MAX_VALUE;

        for(int i = K; i <= N; i++) {
            for(int j = K; j <= M; j++) {
                countB = boardB[i][j] - boardB[i][j - K] - boardB[i - K][j] + boardB[i - K][j - K];
                countW = boardW[i][j] - boardW[i][j - K] - boardW[i - K][j] + boardW[i - K][j - K];

                ans = Math.min(ans, Math.min(countB, countW));
            }
        }

        System.out.print(ans);
    }
}
