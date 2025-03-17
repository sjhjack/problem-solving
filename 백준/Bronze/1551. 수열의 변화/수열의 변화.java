import java.io.*;
import java.util.*;

class Main {
    static int N, K;
    static Queue<Integer> queue;
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        queue = new ArrayDeque<>();

        String[] tmp = br.readLine().split(",");
        for(int i = 0; i < N; i++) {
            queue.add(Integer.parseInt(tmp[i]));
        }
    }

    static void solve() {
        for(int i = 0; i < K; i++) {
            int cur = queue.poll();

            for(int j = queue.size(); j > 0; j--) {
                queue.add(queue.peek() - cur);
                cur = queue.poll();
            }
        }
    }

    static void print() {
        StringBuilder ans = new StringBuilder();
        
        for(int i = queue.size() - 1; i > 0; i--) {
            ans.append(queue.poll()).append(",");
        }
        ans.append(queue.poll());

        System.out.print(ans);
    }
}