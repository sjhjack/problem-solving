import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int count = 0;
        
        for(int i = 1; i <= N; i++) {
            if(N % i == 0 && ++count == K) {
                System.out.print(i);
                return;
            }
        }

        System.out.print(0);
    }
}
