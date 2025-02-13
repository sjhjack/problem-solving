import java.io.*;
import java.util.*;

class Main {
    static int N, M;
    static int[][] arr;
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][2];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (a, b) -> {
            if(a[1] == b[1]) {
                return b[0] - a[0];
            }
            return a[1] - b[1];
        });
    }

    static void solve() {
        int sumBeforeMeat = 0;
        int sumCurPriceMeat = 0;
        int curPrice = -1;
        int curCnt = 1;
        long ans = Integer.MAX_VALUE + 1L;

        for(int i = 0; i < N; i++) {
            if(curPrice != arr[i][1]) {
                sumBeforeMeat += sumCurPriceMeat;
                sumCurPriceMeat = 0;
                curPrice = arr[i][1];
                curCnt = 0;
            }

            curCnt++;
            
            if(sumBeforeMeat + arr[i][0] + sumCurPriceMeat >= M) {
                ans = Math.min(ans, arr[i][1] * curCnt);
            }

            sumCurPriceMeat += arr[i][0];
        }

        System.out.print(ans > Integer.MAX_VALUE ? -1 : ans);
    }
}
