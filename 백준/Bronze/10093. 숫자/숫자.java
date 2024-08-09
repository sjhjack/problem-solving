import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder ans = new StringBuilder();
        
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        if(a > b) {
            long tmp = a;
            a = b;
            b = tmp;
        }
        
        long x = b - a - 1 >= 0 ? b - a - 1 : 0;

        ans.append(x).append("\n");

        while(++a < b) {
            ans.append(a).append(" ");
        }

        System.out.print(ans);
    }
}