import java.io.*;
import java.util.*;

class Main {
    static final int[] dr = {-1,1,0,0,-1,-1,1,1};   // 상하좌우 좌상 우상 좌하 우하
    static final int[] dc = {0,0,-1,1,-1,1,-1,1};

    static char[] target;
    static int N, M;
    static char[][] arr;
    static boolean canFind;
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
        System.out.print(canFind ? 1 : 0);
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        target = br.readLine().toCharArray();

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new char[N][M];

        for(int i = 0; i < N; i++) {
            arr[i] = br.readLine().toCharArray();
        }
    }

    static void solve() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                for(int d = 0; d < 8; d++) {
                    findWord(0, i, j, d);

                    if(canFind) {
                        break;
                    }
                }

                if(canFind) {
                    break;
                }
            }

            if(canFind) {
                break;
            }
        }
    }

    static void findWord(int index, int row, int col, int dir) {
        if(row < 0 || row >= N || col < 0 || col >= M || (index < target.length && target[index] != arr[row][col])) {
            return;
        }
        
        if(index == target.length) {
            canFind = true;
            return;
        }

        findWord(index + 1, row + dr[dir], col + dc[dir], dir);
    }
}
