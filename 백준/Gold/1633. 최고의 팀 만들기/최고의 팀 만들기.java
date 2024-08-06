import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static Player[] players = new Player[1001];
    private static int[][][] dp = new int[1001][16][16];
    private static int length;

    private static class Player {
        int white;
        int black;

        public Player(int white, int black) {
            this.white = white;
            this.black = black;
        }
    }
    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void input() throws IOException {
        String s = "";
        length = 0;

        // while(!(s = br.readLine()).equals("")) {
        while((s = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(s);
            int white = Integer.parseInt(st.nextToken());
            int black = Integer.parseInt(st.nextToken());

            players[length++] = new Player(white, black);
        }
    }

    private static void solve() {
        System.out.print(makeTeam(0, 0, 0));
    }

    private static int makeTeam(int idx, int whiteCnt, int blackCnt) {
        if(idx >= length || (whiteCnt == 15 && blackCnt == 15)) {
            return 0;
        }

        // 현재 백팀에 whiteCnt, 흑팀에 blackCnt 명 씩 있는 경우, idx번째 선수로 만들 수 있는 팀의 최대 팀 능력치 값
        int max = dp[idx][whiteCnt][blackCnt];

        // 이미 확인한 경우
        if(max != 0) {
            return max;
        }

        // 선택 X
        max = Math.max(max, makeTeam(idx + 1, whiteCnt, blackCnt));

        // 백팀
        if(whiteCnt < 15) {
            max = Math.max(max, makeTeam(idx + 1, whiteCnt + 1, blackCnt) + players[idx].white);
        }

        // 흑팀
        if(blackCnt < 15) {
            max = Math.max(max, makeTeam(idx + 1, whiteCnt, blackCnt + 1) + players[idx].black);
        }

        dp[idx][whiteCnt][blackCnt] = max;

        return max;
    }
}

/*

i 번쨰 플레이어

1. x
2. 백
3. 흑

각 팀이 15명이 된 경우 -> 능력치 합 max 값 확인

*/
