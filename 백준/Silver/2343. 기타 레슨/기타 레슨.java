import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int N, M;
    private static int max;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }
    }

    private static void solve() {
        int left = max;             // 최소 길이 = 가장 긴 강의
        int right = getSum();
        int min = 0;

        while(left <= right) {
            int mid = (left + right) / 2;

            if(makeBlueray(mid)) {
                min = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.print(min);
    }

    private static int getSum() {
        int sum = 0;
        for(int i = 0; i < N; i++) {
            sum += arr[i];
        }

        return sum;
    }

    private static boolean makeBlueray(int size) {
        int count = 1;
        int sum = 0;

        for(int i = 0; i < N; i++) {
            sum += arr[i];

            if(sum > size) {
                count++;
                sum = arr[i];

                if(count > M) {
                    return false;
                }
            }
        }

        return true;
    }
}
