import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());

        for(int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            char[] S = st.nextToken().toCharArray();
            char[] T = st.nextToken().toCharArray();

            for(int i = 0; i < S.length; i++) {
                if(S[i] == 'x' || S[i] == 'X') {
                    ans.append(T[i] >= 'a' && T[i] <= 'z' ? (char)(T[i]^32) : T[i]);
                }
            }
        }

        System.out.print(ans);
    }
}