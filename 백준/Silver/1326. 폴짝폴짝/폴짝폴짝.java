import java.io.*;
import java.util.*;

class Main {
    static int N, A, B;
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

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
    }

    static void solve() {
        Queue<Node> queue = new ArrayDeque<>();
        boolean[] isVisited = new boolean[N + 1];
        int ans = -1;

        queue.add(new Node(A, 0));
        isVisited[A] = true;

        while(!queue.isEmpty()) {
            Node cur = queue.poll();
            int number = cur.number + arr[cur.number];

            if(cur.number == B) {
                ans = cur.count;
                break;
            }

            for(int i = cur.number + arr[cur.number]; i <= N; i += arr[cur.number]) {
                if(isVisited[i]) {
                    continue;
                }

                isVisited[i] = true;
                queue.add(new Node(i, cur.count + 1));
            }

            for(int i = cur.number - arr[cur.number]; i > 0; i -= arr[cur.number]) {
                if(isVisited[i]) {
                    continue;
                }

                isVisited[i] = true;
                queue.add(new Node(i, cur.count + 1));
            }
        }

        System.out.print(ans);
    }
}
