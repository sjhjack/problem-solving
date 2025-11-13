import java.io.*;
import java.util.*;

class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    static int N;
    static Queue<String>[] parrots;
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        parrots = new Queue[N];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            parrots[i] = new ArrayDeque<>();

            while(st.hasMoreTokens()) {
                parrots[i].add(st.nextToken());
            }
        }
    }

    static void solve() throws IOException {
        String[] arr = br.readLine().split(" ");

        for(int i = 0; i < arr.length; i++) {
            boolean missing = true;

            for(Queue<String> parrot : parrots) {
                if(parrot.isEmpty()) {
                    continue;
                }

                if(parrot.peek().equals(arr[i])) {
                    parrot.poll();
                    missing = false;
                }
            }

            if(missing) {
                System.out.print("Impossible");
                return;
            }
        }

        for(Queue<String> parrot : parrots) {
            if(!parrot.isEmpty()) {
                System.out.print("Impossible");
                return;
            }
        }

        System.out.print("Possible");
    }
}
