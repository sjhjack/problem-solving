import java.io.*;
import java.util.*;

class Main {
    static int N;
    static int[] arr;

    static class Node {
        int number;
        int count;

        public Node(int number, int count) {
            this.number = number;
            this.count = count;
        }
    }
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];

        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
    }

    static void solve() {
        int ans = 0;
        int maxCount = 0;
        
        for(int i = 1; i <= N; i++) {
            Queue<Node> queue = new ArrayDeque<>();
            boolean[] isVisited = new boolean[N + 1];
            int count = 0;

            queue.add(new Node(i, 1));
            isVisited[i] = true;

            while(!queue.isEmpty()) {
                Node cur = queue.poll();
                int next = arr[cur.number];

                count = Math.max(count, cur.count);

                if(!isVisited[next]) {
                    queue.add(new Node(next, cur.count + 1));
                    isVisited[next] = true;
                }
            }

            if(maxCount < count) {
                ans = i;
                maxCount = count;
            }
        }

        System.out.print(ans);
    }
}
