import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int testcase = Integer.parseInt(st.nextToken());
            int[] arr = new int[20];
            int count = 0;

            ans.append(testcase).append(" ");

            for(int i = 0; i < 20; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for(int i = 0; i < 20; i++) {
                for(int j = 0; j < i; j++) {
                    if(arr[j] > arr[i]) {
                        count++;
                    }
                }
            }

            ans.append(count).append("\n");
        }

        System.out.print(ans);
    }
}