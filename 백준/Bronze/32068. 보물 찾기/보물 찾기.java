import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder ans = new StringBuilder();

        for(int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());
            int count = 0;

            if(S - L < R - S) {
                count = (S - L) * 2 + 1;
            } else {
                count = (R - S) * 2;
            }

            ans.append(count).append("\n");
        }

        System.out.print(ans);
    }
}