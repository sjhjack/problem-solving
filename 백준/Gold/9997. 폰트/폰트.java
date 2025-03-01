import java.io.*;
import java.util.*;

class Main {
    static final int TARGET = Integer.parseInt("11111111111111111111111111", 2);

    static int N;
    static int ans;
    static int[] arr;
    
    public static void main(String[] args) throws IOException {
        init();
        solve(0, 0);
        System.out.print(ans);
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        for(int i = 0; i < N; i++) {
            char[] tmp = br.readLine().toCharArray();
            int number = 0;

            for(int j = 0; j < tmp.length; j++) {
                number |= 1 << (tmp[j] - 'a');
            }

            arr[i] = number;
        }
    }

    static void solve(int index, int number) {
        if(index >= N) {
            if(number == TARGET) {
                ans++;
            }
            return;
        }

        solve(index + 1, number | arr[index]);
        solve(index + 1, number);
    }
}
