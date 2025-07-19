import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();

        while(true) {
            int N = Integer.parseInt(br.readLine());

            if(N == 0) {
                break;
            }

            int[] arr = new int[N];
            boolean isPossible = true;

            for(int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }

            if(N < 8) {
                ans.append("IMPOSSIBLE\n");
                continue;
            }

            Arrays.sort(arr);

            for(int i = 1; i < N; i++) {
                if(arr[i] - arr[i - 1] > 200) {
                    isPossible = false;
                    break;
                }
            }

            if(arr[N - 1] < 1422 && (1422 - arr[N - 1] > 100)) {
                isPossible = false;
            }

            ans.append(isPossible ? "POSSIBLE\n" : "IMPOSSIBLE\n");
        }

        System.out.print(ans);
    }
}
