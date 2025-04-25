import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int testcase = 1;

        while(true) {
            String s = br.readLine();

            if(s.equals("0 0 0")) {
                break;
            }

            StringTokenizer st = new StringTokenizer(s);
            int L = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            int count = (V / P) * L + Math.min(V % P, L);

            ans.append("Case ").append(testcase).append(": ").append(count).append("\n");
            testcase++;
        }

        System.out.print(ans);
    }
}
