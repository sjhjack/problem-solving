import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
X 먼저 시작

- X 승리
xCnt = oCnt + 1
x 1줄, o 0줄

- O 승리
xCnt = oCnt
x 0줄, o 1줄

- 무승부
xCnt = oCnt + 1, 총 9개
x 0줄, o 0줄

*/

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder ans = new StringBuilder();
    private static char[][] map;
    private static int xCnt, oCnt;

    public static void main(String[] args) throws IOException {

        while(true) {
            String s = br.readLine();

            if(s.equals("end")) {
                break;
            }

            init(s);
            solve();
        }

        System.out.print(ans);
    }

    private static void init(String s) {
        char[] tmp = s.toCharArray();
        map = new char[3][3];
        xCnt = 0;
        oCnt = 0;

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                map[i][j] = tmp[i*3 + j];

                if(map[i][j] == 'X') {
                    xCnt++;
                } else if(map[i][j] == 'O') {
                    oCnt++;
                }
            }
        }
    }

    private static void solve() {
        if(xCnt == oCnt + 1) {
            // X 승리 또는 무승부
            if(xCnt + oCnt == 9 && (!isWin('X') && !isWin('O'))) {
                ans.append("valid\n");
            } else if(isWin('X') && !isWin('O')) {
                ans.append("valid\n");
            } else {
                ans.append("invalid\n");
            }
        } else if(xCnt == oCnt) {
            // O 승리
            if(!isWin('X') && isWin('O')) {
                ans.append("valid\n");
            } else {
                ans.append("invalid\n");
            }
        } else {
            // 나머지는 불가능
            ans.append("invalid\n");
        }
    }

    private static boolean isWin(char c) {
        int cnt = 0;

        // 가로
        for(int i = 0; i < 3; i++) {
            if(map[i][0] == c && map[i][1] == c && map[i][2] == c) {
                cnt++;
            }
        }

        // 세로
        for(int i = 0; i < 3; i++) {
            if(map[0][i] == c && map[1][i] == c && map[2][i] == c) {
                cnt++;
            }
        }

        // 우하향 대각선
        if(map[0][0] == c && map[1][1] == c && map[2][2] == c) {
            cnt++;
        }

        // 우상향 대각선
        if(map[0][2] == c && map[1][1] == c && map[2][0] == c) {
            cnt++;
        }

        if(cnt == 1) {
            return true;
        } else {
            return false;
        }
    }
}
