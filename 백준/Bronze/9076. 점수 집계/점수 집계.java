import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[5];

            for(int j = 0; j < 5; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            if(arr[3] - arr[1] >= 4) {
                ans.append("KIN\n");
            } else {
                ans.append(arr[1] + arr[2] + arr[3]).append("\n");
            }
        }

        System.out.print(ans);
    }
}