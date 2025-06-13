import java.io.*;
import java.util.*;

class Main {
    static int N;
    static int[] arr;
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
    }

    static void solve() {
        long sumAlice = 0;
        long sumBob = 0;
        int indexAlice = N - 1;
        int indexBob = 0;

        while(N > 0) {
            if(N % 2 == 0) {
                sumAlice += arr[indexAlice--];
            } else {
                sumBob += arr[indexBob++];
            }

            if(sumAlice < sumBob) {
                System.out.print("Bob");
                return;
            }

            N--;
        }

        System.out.print("Alice");
    }
}
