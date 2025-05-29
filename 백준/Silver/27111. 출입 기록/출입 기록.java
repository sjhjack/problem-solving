import java.io.*;
import java.util.*;

class Main {
    static final int MAX = 200_001;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inArmy = new int[MAX];
        int N = Integer.parseInt(br.readLine());
        int ans = 0;

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(inArmy[a] != b) {
                inArmy[a] = b;
            } else {
                ans++;
            }
        }

        for(int i = 1; i < MAX; i++) {
            if(inArmy[i] > 0) {
                ans++;
            }
        }

        System.out.print(ans);
    }
}