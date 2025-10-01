import java.io.*;
import java.util.*;

class Main {
    static int N;
    static Number[] dp;

    static class Number {
        int number;
        int count;
        int from;

        public Number(int number, int count, int from) {
            this.number = number;
            this.count = count;
            this.from = from;
        }
    }
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new Number[N + 1];

        for(int i = 1; i <= N; i++) {
            dp[i] = new Number(i, Integer.MAX_VALUE, i);
        }
    }

    static void solve() {
        Queue<Number> queue = new ArrayDeque<>();

        dp[N].count = 0;
        queue.add(dp[N]);

        while(!queue.isEmpty()) {
            Number cur = queue.poll();

            if(cur.number == 1) {
                break;
            }

            if(cur.number % 3 == 0 && dp[cur.number / 3].count > cur.count + 1) {
                dp[cur.number / 3].count = cur.count + 1;
                dp[cur.number / 3].from = cur.number;
                queue.add(dp[cur.number / 3]);
            }
            if(cur.number % 2 == 0 && dp[cur.number / 2].count > cur.count + 1) {
                dp[cur.number / 2].count = cur.count + 1;
                dp[cur.number / 2].from = cur.number;
                queue.add(dp[cur.number / 2]);
            }
            if(dp[cur.number - 1].count > cur.count + 1) {
                dp[cur.number - 1].count = cur.count + 1;
                dp[cur.number - 1].from = cur.number;
                queue.add(dp[cur.number - 1]);
            }
        }
    }

    static void print() {
        StringBuilder ans = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int index = 1;

        while(dp[index].from != index) {
            stack.add(index);
            index = dp[index].from;
        }

        stack.add(N);

        ans.append(dp[1].count).append("\n");

        while(!stack.isEmpty()) {
            ans.append(stack.pop()).append(" ");
        }

        System.out.print(ans);
    }
}
