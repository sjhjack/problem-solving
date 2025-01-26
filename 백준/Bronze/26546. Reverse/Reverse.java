import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans =  new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char[] arr = st.nextToken().toCharArray();
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken()) - 1;

            for(int j = 0; j < arr.length; j++) {
                if(start <= j && j <= end) {
                    continue;
                }

                ans.append(arr[j]);
            }

            ans.append("\n");
        }

        System.out.print(ans);
    }
}