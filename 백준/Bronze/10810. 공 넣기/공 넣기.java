import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N + 1];

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int number = Integer.parseInt(st.nextToken());

            for(int j = from; j <= to; j++) {
                arr[j] = number;
            }
        }

        StringBuilder ans = new StringBuilder();
        for(int i = 1; i <= N; i++) {
            ans.append(arr[i]).append(" ");
        }

        System.out.print(ans);
    }
}