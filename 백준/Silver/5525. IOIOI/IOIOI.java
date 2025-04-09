import java.io.*;

class Main {
    static int N, M;
    static String S, P;
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        S = br.readLine();
        P = "I";
        
        for(int i = 0; i < N; i++) {
            P += "OI";
        }
    }

    static void solve() {
        int ans = 0;
        int index = 0;

        while((index = S.indexOf(P)) >= 0) {
            ans++;
            S = S.substring(index + 1);
        }

        System.out.print(ans);
    }
}
