import java.io.*;
import java.util.*;

class Main {
    static Stack<Integer> stack;
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        stack = new Stack<>();

        for(int i = 0; i < N; i++) {
            stack.add(Integer.parseInt(br.readLine()));
        }
    }

    static void solve() {
        int max = 0;
        int ans = 0;

        while(!stack.isEmpty()) {
            int height = stack.pop();

            if(height > max) {
                max = height;
                ans++;
            }
        }

        System.out.print(ans);
    }
}