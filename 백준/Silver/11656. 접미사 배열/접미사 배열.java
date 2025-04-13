import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        
        String S = br.readLine();
        int N = S.length();
        String[] arr = new String[N];

        for(int i = 0; i < N; i++) {
            arr[i] = S.substring(i);
        }

        Arrays.sort(arr);

        for(int i = 0; i < N; i++) {
            ans.append(arr[i]).append("\n");
        }

        System.out.print(ans);
    }
}