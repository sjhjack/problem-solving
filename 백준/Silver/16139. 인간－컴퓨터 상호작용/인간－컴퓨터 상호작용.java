import java.io.*;
import java.util.*;

class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int[][] prefSum;
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        char[] text = br.readLine().toCharArray();
        int N = text.length;
        
        prefSum = new int['z'-'a'+1][N + 1];

        for(int i = 1; i <= N; i++) {
            prefSum[text[i - 1]-'a'][i]++;

            for(int j = 0; j < 'z'-'a'+1; j++) {
                prefSum[j][i] += prefSum[j][i - 1];
            }
        }
    }

    static void solve() throws IOException {
        StringBuilder ans = new StringBuilder();
        int Q = Integer.parseInt(br.readLine());

        for(int i = 0; i < Q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int alpha = st.nextToken().charAt(0) - 'a';
            int left = Integer.parseInt(st.nextToken()) + 1;
            int right = Integer.parseInt(st.nextToken()) + 1;

            ans.append(prefSum[alpha][right] - prefSum[alpha][left - 1]).append("\n");
        }

        System.out.print(ans);
    }
}
