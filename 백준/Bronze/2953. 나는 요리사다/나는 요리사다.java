import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[] arr = new int[5];

        for(int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            
            while(st.hasMoreTokens()) {
                arr[i] += Integer.parseInt(st.nextToken());
            }
        }

        int num = 0;
        int max = 0;

        for(int i = 0; i < 5; i++) {
            if(arr[i] > max) {
                num = i + 1;
                max = arr[i];
            }
        }

        System.out.print(num + " " + max);
    }
}