import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[6];
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st2.nextToken());
        int P = Integer.parseInt(st2.nextToken());
        int t = 0;
        
        for(int i = 0; i < 6; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            t += arr[i] / T + (arr[i] % T == 0 ? 0 : 1);
        }

        StringBuilder ans = new StringBuilder();
        ans.append(t).append("\n");
        ans.append(N / P).append(" ").append(N % P);
        
        System.out.print(ans);
    }
}