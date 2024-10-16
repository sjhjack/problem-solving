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
        arr = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void solve() {
        StringBuilder ans = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int[] memo = new int[N + 1];

        for(int i = N; i >= 1; i--) {
            while(!stack.isEmpty() && arr[i] >= arr[stack.peek()]) {
                memo[stack.pop()] = i;
            }
            
            stack.add(i);
        }

        for(int i = 1; i <= N; i++) {
            ans.append(memo[i]).append(" ");
        }

        System.out.print(ans);
    }
}
