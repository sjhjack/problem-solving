import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int min = Integer.MAX_VALUE;
            int sum = 0;

            for(int i = 0; i < 7; i++) {
                int number = Integer.parseInt(st.nextToken());

                if(number % 2 == 0) {
                    sum += number;
                    min = Math.min(min, number);
                }
            }

            ans.append(sum).append(" ").append(min).append("\n");
        }

        System.out.print(ans);
    }
}