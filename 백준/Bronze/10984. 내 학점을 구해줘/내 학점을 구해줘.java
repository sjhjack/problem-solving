import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int C = 0;
            float G = 0;

            for(int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int c = Integer.parseInt(st.nextToken());
                float g = Float.parseFloat(st.nextToken());
                
                C += c;
                G += c * g;
            }

            ans.append(C).append(" ").append(String.format("%.1f", G / C)).append("\n");
        }

        System.out.print(ans);
    }
}