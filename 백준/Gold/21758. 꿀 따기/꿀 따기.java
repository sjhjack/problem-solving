import java.io.*;
import java.util.*;

class Main {
    static int N;
    static int[] arr;
    static int[] prefSum;
    static int ans;
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        prefSum = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            prefSum[i] = prefSum[i - 1] + arr[i];
        }
    }

    static void solve() {
        left();
        mid();
        right();

        System.out.print(ans);
    }

    // 벌 벌 꿀
    static void left() {
        // 왼쪽 시작 지점 제외
        int sum = prefSum[N] - prefSum[1];

        // 꿀벌 한 마리 탐색
        for(int i = 2; i < N; i++) {
            ans = Math.max(ans, sum - arr[i] + prefSum[N] - prefSum[i]);
        }
    }

    // 벌 꿀 벌
    static void mid() {
        // 양쪽 시작 지점 제외
        int sum = prefSum[N - 1] - prefSum[1];

        // 꿀통 위치 탐색
        for(int i = 2; i < N; i++) {
            ans = Math.max(ans, sum + arr[i]);
        }
    }


    // 꿀 벌 벌
    static void right() {
        // 오른쪽 시작 지점 제외
        int sum = prefSum[N - 1];

        // 꿀벌 한 마리 탐색
        for(int i = N - 1; i > 1; i--) {
            ans = Math.max(ans, sum - arr[i] + prefSum[i - 1]);
        }
    }
}
