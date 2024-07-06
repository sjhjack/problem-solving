import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++) {
            boolean[] alpha = new boolean['z' - 'a' + 1];
            char[] arr = br.readLine().toCharArray();

            for(int i = 0; i < arr.length; i++) {
                alpha[arr[i] - 'A'] = true;
            }

            int sum = 0;
            for(int i = 0; i < alpha.length; i++) {
                if(!alpha[i]) {
                    sum += i + 65;
                }
            }

            ans.append(sum).append("\n");
        }

        System.out.print(ans);
    }
}