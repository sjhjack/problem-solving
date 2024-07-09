import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
    }

    private static void solve() {
        int ans = 0;

        for(int i = 0; i < N; i++) {
            int cur = arr[i];
            int left = 0;
            int right = N - 1;

            while(left < right) {
                if(left ==  i) {
                    left ++;
                    continue;
                } else if(right == i) {
                    right--;
                    continue;
                }

                if(arr[left] + arr[right] == cur) {
                    ans++;
                    break;
                } else if(arr[left] + arr[right] > cur) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        System.out.print(ans);
    }
}
