import java.io.*;
import java.util.*;

class Main {
    static int N;
    static int Jimin, Hansu;
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        Jimin = Integer.parseInt(st.nextToken());
        Hansu = Integer.parseInt(st.nextToken());
    }

    static void solve() {
        int round = 1;

        while(N > 0) {
            Jimin = (Jimin - 1) / 2 + 1;
            Hansu = (Hansu - 1) / 2 + 1;
            
            if(Jimin == Hansu) {
                System.out.print(round);
                return;
            }

            round++;
        }

        System.out.print(-1);
    }
}