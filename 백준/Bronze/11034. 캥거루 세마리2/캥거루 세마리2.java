import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        String s = "";

        while((s = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(s);
            int[] arr = new int[3];

            for(int i = 0; i < 3; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            ans.append(Math.max(arr[2]-arr[1], arr[1]-arr[0]) - 1).append("\n");
        }

        System.out.print(ans);
    }
}