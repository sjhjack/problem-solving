import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] numA = getArr(st.nextToken());
        int[] numB = getArr(st.nextToken());
        long ans = 0;

        for(int i = 0; i < numA.length; i++) {
            for(int j = 0; j < numB.length; j++) {
                ans += numA[i] * numB[j];
            }
        }

        System.out.print(ans);
    }

    static int[] getArr(String s) {
        int[] arr = new int[s.length()];

        for(int i = 0; i < arr.length; i++) {
            arr[i] = s.charAt(i) - '0';
        }

        return arr;
    }
}