import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = 0;
        
        for(int i = 1; i <= N; i++) {
            int avg = Integer.parseInt(st.nextToken());
            int A = avg * i - sum;
            
            sum += A;
            ans.append(A).append(" ");
        }

        System.out.print(ans);
    }
}