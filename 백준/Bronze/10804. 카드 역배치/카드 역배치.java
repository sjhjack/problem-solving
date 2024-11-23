import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();

        int[] arr = new int[21];
        
        for(int i = 1; i <= 20; i++) {
            arr[i] = i;
        }

        for(int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            for(int j = 0; j < (to-from+1) / 2; j++) {
                int tmp = arr[from + j];
                arr[from + j] = arr[to - j];
                arr[to - j] = tmp;
            }
        }

        for(int i = 1; i <= 20; i++) {
            ans.append(arr[i]).append(" ");
        }

        System.out.print(ans);
    }
}
