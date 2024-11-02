import java.io.*;
import java.util.*;

class Main {
    static StringBuilder ans = new StringBuilder();
    static int N, M;
    static int[] arr;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];

        solve(0, 0);

        System.out.print(ans);
    }

    static void solve(int index, int count) {
        if(count >= M) {
            for(int num : arr) {
                ans.append(num).append(" ");
            }
            ans.append("\n");
            
            return;
        }

        for(int i = 1; i <= N; i++) {
            arr[index] = i;
            solve(index + 1, count + 1);
        }
    }
}
