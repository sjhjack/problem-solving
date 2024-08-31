import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            while(st.hasMoreTokens()) {
                char[] tmp = st.nextToken().toCharArray();

                for(int j = tmp.length-1; j >= 0; j--) {
                    ans.append(tmp[j]);
                }
                ans.append(" ");
            }
            
            ans.append("\n");
        }

        System.out.print(ans);
    }
}