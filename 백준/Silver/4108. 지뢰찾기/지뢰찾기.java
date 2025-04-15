import java.io.*;
import java.util.*;

class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder ans = new StringBuilder();
    static final int[] dr = {-1,1,0,0,-1,-1,1,1};    // 상하좌우 좌상 우상 좌하 우하
    static final int[] dc = {0,0,-1,1,-1,1,-1,1};

    static int R, C;
    static char[][] arr;
    static int[][] count;
    
    public static void main(String[] args) throws IOException {
        while(true) {
            String s = br.readLine();

            if(s.equals("0 0")) {
                break;
            }
            
            init(s);
            solve();
            print();
        }

        System.out.print(ans);
    }

    static void init(String s) throws IOException {
        StringTokenizer st = new StringTokenizer(s);

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[R][C];
        count = new int[R][C];

        for(int i = 0; i < R; i++) {
            arr[i] = br.readLine().toCharArray();
        }
    }

    static void solve() {
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(arr[i][j] == '.') {
                    for(int d = 0; d < 8; d++) {
                        int nr = i + dr[d];
                        int nc = j + dc[d];

                        if(nr < 0 || nr >= R || nc < 0 || nc >= C || arr[nr][nc] == '.') {
                            continue;
                        }

                        count[i][j]++;
                    }
                }
            }
        }
    }

    static void print() {
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(arr[i][j] == '.') {
                    ans.append(count[i][j]);
                } else {
                    ans.append('*');
                }
            }
            ans.append("\n");
        }
    }
}
