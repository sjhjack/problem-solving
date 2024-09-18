import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        Deque<Integer> deque = new ArrayDeque<>();
        
        int N = Integer.parseInt(br.readLine());

        for(int i = 1; i <= N; i++) {
            deque.add(i);
        }

        while(deque.size() > 1) {
            ans.append(deque.poll()).append(" ");
            deque.add(deque.poll());
        }

        ans.append(deque.poll());

        System.out.print(ans);
    }
}
