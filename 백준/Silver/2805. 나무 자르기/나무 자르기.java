import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static long max;
    static int[] arr;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void solve(){
        Arrays.sort(arr);
        findMax(1, Math.min(arr[N-1], 1_000_000_000));
    }

    static void findMax(long start, long end){
        if(start > end) return;

        long mid = (start + end) / 2;
        long sum = 0L;

        for(int i = 0; i < arr.length; i++){
            if(arr[i] > mid){
                sum += arr[i] - mid;
            }
        }

        if(sum >= M){
            if(mid > max){
                max = mid;
                findMax(mid + 1, end);
            }
        } else {
            findMax(start, mid - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
        System.out.println(max);
    }
}
