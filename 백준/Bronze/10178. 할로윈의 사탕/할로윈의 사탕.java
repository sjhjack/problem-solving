import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int candy = Integer.parseInt(st.nextToken());
            int man = Integer.parseInt(st.nextToken());

            ans.append("You get ").append(candy / man).append(" piece(s) and your dad gets ")
                .append(candy % man).append(" piece(s).\n");
        }

        System.out.print(ans);
    }
}