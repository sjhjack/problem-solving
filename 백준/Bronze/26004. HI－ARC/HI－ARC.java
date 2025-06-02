import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] arr = br.readLine().toCharArray();

        int[] count = new int[5];

        for(int i = 0; i < N; i++) {
            if(arr[i] == 'H') {
                count[0]++;
            } else if(arr[i] == 'I') {
                count[1]++;
            } else if(arr[i] == 'A') {
                count[2]++;
            } else if(arr[i] == 'R') {
                count[3]++;
            } else if(arr[i] == 'C') {
                count[4]++;
            }
        }

        Arrays.sort(count);

        System.out.print(count[0]);
    }
}