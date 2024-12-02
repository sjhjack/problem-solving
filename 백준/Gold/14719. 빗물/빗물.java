import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        Deque<Integer> deque = new ArrayDeque<>();
        int ans = 0;
        
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < W; i++) {
            int height = Integer.parseInt(st.nextToken());

            if(!deque.isEmpty() && deque.peek() <= height) {
                int max = deque.poll();
                
                while(!deque.isEmpty()) {
                    ans += max - deque.poll();
                }
            }

            deque.add(height);
        }

        if(deque.size() >= 2) {
            int max = deque.pollLast();

            while(!deque.isEmpty()) {
                if(deque.peekLast() < max) {
                    ans += max - deque.pollLast();
                } else {
                    max = deque.pollLast();
                }
            }
        }

        System.out.print(ans);
    }
}
