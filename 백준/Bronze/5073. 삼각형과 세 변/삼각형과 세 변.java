import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();

        while(true) {
            String s = br.readLine();

            if(s.equals("0 0 0")) {
                break;
            }

            StringTokenizer st = new StringTokenizer(s);
            int[] arr = new int[3];

            for(int i = 0; i < 3; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            if(arr[2] >= arr[0] + arr[1]) {
                ans.append("Invalid\n");
                continue;
            }

            if(arr[0] == arr[1] && arr[1] == arr[2]) {
                ans.append("Equilateral\n");
            } else if(arr[0] == arr[1] || arr[1] == arr[2] || arr[2] == arr[0]) {
                ans.append("Isosceles\n");
            } else {
                ans.append("Scalene\n");
            }
        }

        System.out.print(ans);
    }
}