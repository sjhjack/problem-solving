import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++) {
            int number = Integer.parseInt(br.readLine());
            int count = 0;

            while(number != 6174) {
                count++;
                char[] arr = String.format("%04d", number).toCharArray();
                
                Arrays.sort(arr);
                String min = new String(arr);
                String max = new StringBuilder(min).reverse().toString();

                number = Integer.parseInt(max) - Integer.parseInt(min);
            }

            ans.append(count).append("\n");
        }

        System.out.print(ans);
    }
}