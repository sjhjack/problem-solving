import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] alpha = new int[26];
            char[] target = st.nextToken().toCharArray();
            char[] arr = st.nextToken().toCharArray();

            for(int i = 0; i < target.length; i++) {
                alpha[target[i] - 'a']++;
            }

            for(int i = 0; i < arr.length; i++) {
                alpha[arr[i] - 'a']--;
            }

            boolean possible = true;
            
            for(int i = 0; i < 26; i++) {
                if(alpha[i] != 0) {
                    possible = false;
                    break;
                }
            }

            ans.append(possible ? "Possible" : "Impossible").append("\n");
        }

        System.out.print(ans);
    }
}
