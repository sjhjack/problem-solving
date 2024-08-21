import java.util.*;
import java.io.*;

class Main {
    static int M, N;
    static int[] arr;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];

        for(int i = 1; i <= N; i++) {
            arr[i] = i;
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            reverse(from, to);
        }

        for(int i = 1; i <= N; i++) {
            ans.append(arr[i]).append(" ");
        }

        System.out.print(ans);
    }

    static void reverse(int from, int to) {
        int tmp = 0;
        
        for(int i = 0; i < (to - from + 1) / 2; i++) {
            tmp = arr[from + i];
            arr[from + i] = arr[to - i];
            arr[to - i] = tmp;
        }
    }
}