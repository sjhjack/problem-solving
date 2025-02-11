import java.io.*;
import java.util.*;

class Main {    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[3];

        for(int i = 0; i < 3; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        String s = br.readLine();
        StringBuilder ans = new StringBuilder();

        for(int i = 0; i < 3; i++) {
            ans.append(arr[s.charAt(i) - 'A']).append(" ");
        }

        System.out.print(ans);
    }
}