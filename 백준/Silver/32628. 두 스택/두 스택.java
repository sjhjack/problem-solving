import java.io.*;
import java.util.*;

class Main {
    static int N, K;
    static Stack<Integer> bag1, bag2;
    static long sum1, sum2;
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        bag1 = new Stack<>();
        bag2 = new Stack<>();
        sum1 = 0L;
        sum2 = 0L;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            bag1.add(Integer.parseInt(st.nextToken()));
            sum1 += bag1.peek();
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            bag2.add(Integer.parseInt(st.nextToken()));
            sum2 += bag2.peek();
        }
    }

    static void solve() {
        while(K > 0 && bag1.size() + bag2.size() > 0) {
            if(bag1.isEmpty()) {
                sum2 -= bag2.pop();
            } else if(bag2.isEmpty()) {
                sum1 -= bag1.pop();
            } else {
                if(sum1 >= sum2) {
                    sum1 -= bag1.pop();
                } else {
                    sum2 -= bag2.pop();
                }
            }

            K--;
        }

        System.out.print(Math.max(sum1, sum2));
    }
}
