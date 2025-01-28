import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        
        while(true) {
            String s = br.readLine();

            if(s.equals("0 0 0 0")) {
                break;
            }

            StringTokenizer st = new StringTokenizer(s);

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            ans.append(c - b).append(" ").append(d - a).append("\n");
        }

        System.out.print(ans);
    }
}