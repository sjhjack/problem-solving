import java.io.*;
import java.util.*;

class Main {
    static int[][] arr;
    static int N;

    static class Node implements Comparable<Node> {
        int number;
        int cost;

        public Node(int number, int cost) {
            this.number = number;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return cost - o.cost;
        }
    }
    
    public static void main(String[] args) throws IOException {
        init();
        prim();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void prim() {
        boolean[] isVisited = new boolean[N];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        long totalCost = 0;

        pq.add(new Node(0, 0));

        while(!pq.isEmpty()) {
            Node cur = pq.poll();

            if(isVisited[cur.number]) {
                continue;
            }
            isVisited[cur.number] = true;
            totalCost += cur.cost;

            for(int i = 0; i < N; i++) {
                if(!isVisited[i] && i != cur.number) {
                    pq.add(new Node(i, arr[cur.number][i]));
                }
            }
        }

        System.out.print(totalCost);
    }
}
