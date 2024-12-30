import java.io.*;
import java.util.*;

class Main {    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);

            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < M; j++) {
                if(c == 'C') {
                    ans.append(st.nextToken().charAt(0) - 'A' + 1).append(" ");
                } else {
                    int num = Integer.parseInt(st.nextToken()) - 1;
                    ans.append((char)('A' + num)).append(" ");
                }
            }

            ans.append("\n");
        }

        System.out.print(ans);
    }
}
