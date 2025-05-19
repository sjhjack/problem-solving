import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int T = 1;
        int B = 5000;

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T = Math.max(T, Integer.parseInt(st.nextToken()));
            B = Math.min(B, Integer.parseInt(st.nextToken()));
        }

        System.out.print((T * B) % 7 + 1);
    }
}