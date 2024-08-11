import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int sum = 0;
        int stat = 0;
        int idx = N - 1;
        int cnt = 0;

        Arrays.sort(arr);

        while(cnt < 42 && idx >= 0) {
            int level = arr[idx--];
            cnt++;
            sum += level;

            if(60 <= level && level < 100) {
                stat += 1;
            } else if(100 <= level && level < 140) {
                stat += 2;
            } else if(140 <= level && level < 200) {
                stat += 3;
            } else if(200 <= level && level < 250) {
                stat += 4;
            } else if(250 <= level) {
                stat += 5;
            }
        }

        System.out.print(sum + " " + stat);
    }
}