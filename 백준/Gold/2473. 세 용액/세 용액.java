import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N;
    private static long[] arr;

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void input() throws IOException {
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new long[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Long.parseLong(st.nextToken());
        }
    }

    private static void solve() {
        long sum = Long.MAX_VALUE;
        long[] ans = new long[3];

        Arrays.sort(arr);

        for(int i = 0; i < N-2; i++){
            int left = i + 1;
            int right = N - 1;

            while(left < right){
                long curSum = arr[i] + arr[left] + arr[right];

                if(Math.abs(curSum) < sum){
                    sum = Math.abs(curSum);
                    ans[0] = arr[i];
                    ans[1] = arr[left];
                    ans[2] = arr[right];
                }

                if(curSum < 0){
                    left++;
                } else {
                    right--;
                }
            }
        }

        System.out.print(ans[0] + " " + ans[1] + " " + ans[2]);
    }
}
