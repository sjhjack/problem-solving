import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++) {
            int y = 0;
            int k = 0;

            for(int i = 0; i < 9; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                y += Integer.parseInt(st.nextToken());
                k += Integer.parseInt(st.nextToken());
            }

            ans.append(y > k ? "Yonsei" : (y < k ? "Korea" : "Draw")).append("\n");
        }

        System.out.print(ans);
    }
}