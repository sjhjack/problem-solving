import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            float number = Float.parseFloat(st.nextToken());

            while(st.hasMoreTokens()) {
                switch(st.nextToken()) {
                    case "@" : number *= 3;
                        break;
                    case "%" : number += 5;
                        break;
                    case "#" : number -= 7;
                        break;
                    default :
                        continue;
                }
            }

            ans.append(String.format("%.2f", number)).append("\n");
        }

        System.out.print(ans);
    }
}