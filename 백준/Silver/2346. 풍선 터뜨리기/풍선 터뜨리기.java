import java.io.*;
import java.util.*;

class Main {
    static int N;
    static Deque<Balloon> dq;
    
    static class Balloon {
        int num;
        int memo;

        public Balloon(int num, int memo) {
            this.num = num;
            this.memo = memo;
        }
    }
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dq = new ArrayDeque<>();
        
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            int memo = Integer.parseInt(st.nextToken());
            dq.add(new Balloon(i, memo));
        }
    }

    static void solve() {
        StringBuilder ans = new StringBuilder();

        while(!dq.isEmpty()) {
            Balloon cur = dq.poll();

            ans.append(cur.num).append(" ");

            if(dq.isEmpty()) {
                break;
            }
            
            for(int i = cur.memo - 1; i > 0; i--) {
                dq.add(dq.poll());
            }

            for(int i = cur.memo; i < 0; i++) {
                dq.addFirst(dq.pollLast());
            }
        }

        System.out.print(ans);
    }
}
