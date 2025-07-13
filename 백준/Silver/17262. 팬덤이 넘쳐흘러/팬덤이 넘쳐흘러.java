import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int minEnd = 100000;
        int maxStart = 1;

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            minEnd = Math.min(minEnd, end);
            maxStart = Math.max(maxStart, start);
        }

        System.out.print(maxStart <= minEnd ? 0 : maxStart - minEnd);
    }
}
