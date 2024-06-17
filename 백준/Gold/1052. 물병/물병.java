import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int N, K;

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
    }

    private static void solve() {
        long sum = 0;
        int bit = Integer.lowestOneBit(N);

        while(Integer.bitCount(N) > K) {
            if((N & bit) > 0) {
                N += bit;
                sum += bit;
            }
            bit <<= 1;
        }

        System.out.print(sum);
    }
}
