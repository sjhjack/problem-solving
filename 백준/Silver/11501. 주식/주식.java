import java.io.*;
import java.util.*;

class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder ans = new StringBuilder();

    static int N;
    static int[] arr;
    
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        
        for(int t = 0; t < T; t++) {
            init();
            solve();
        }

        System.out.print(ans);
    }

    static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void solve() {
        Queue<Integer> queue = new ArrayDeque<>();
        int max = 0;
        long sum = 0L;

        for(int i = N-1; i >= 0; i--) {
            if(arr[i] > max) {
                while(!queue.isEmpty()) {
                    sum += max - queue.poll();
                }

                max = arr[i];
            } else if(arr[i] < max) {
                queue.add(arr[i]);
            }
        }

        while(!queue.isEmpty()) {
            sum += max - queue.poll();
        }

        ans.append(sum).append("\n");
    }
}
