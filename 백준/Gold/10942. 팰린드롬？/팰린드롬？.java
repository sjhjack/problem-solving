import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int[] arr;
    static boolean[][] dp;

    public static void main(String[] args) throws IOException {
        init();
        findPalindrome();
        print();
    }

    static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        arr = new int[N];
        dp = new boolean[N][N];

        for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
    }

    static void findPalindrome(){
        for(int i = 0; i < N; i++) {
            dp[i][i] = true;
        }

        for(int i = 0; i < N-1; i++) {
            if(arr[i] == arr[i+1]){
                dp[i][i+1] = true;
            }
        }

        for(int gap = 2; gap < N; gap++){
            for(int idx = 0; idx+gap < N; idx++){
                if(arr[idx] == arr[idx+gap] && dp[idx+1][idx+gap-1]){
                    dp[idx][idx+gap] = true;
                }
            }
        }
    }

    static void print() throws IOException {
        StringBuilder ans = new StringBuilder();
        int M = Integer.parseInt(br.readLine());

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            if(dp[a][b]) ans.append("1\n");
            else ans.append("0\n");
        }

        System.out.print(ans);
    }
}
