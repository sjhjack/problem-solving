import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static int N;
    private static int[] dist;
    private static Node[] xLen, yLen, zLen;

    private static class Node implements Comparable<Node> {
        int num;
        int len;

        public Node(int num, int len){
            this.num = num;
            this.len = len;
        }

        @Override
        public int compareTo(Node n){
            return len - n.len;
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());

        dist = new int[N + 1];
        xLen = new Node[N];
        yLen = new Node[N];
        zLen = new Node[N];

        for(int i = 0; i < N; i++){
            st =  new StringTokenizer(br.readLine());

            xLen[i] = new Node(i+1, Integer.parseInt(st.nextToken()));
            yLen[i] = new Node(i+1, Integer.parseInt(st.nextToken()));
            zLen[i] = new Node(i+1, Integer.parseInt(st.nextToken()));
        }
    }

    private static void solve() {
        sort();
        prim();
    }

    private static void sort(){
        Arrays.sort(xLen);
        Arrays.sort(yLen);
        Arrays.sort(zLen);
    }

    private static void prim() {
        int[] xIdx = new int[N + 1];
        int[] yIdx = new int[N + 1];
        int[] zIdx = new int[N + 1];

        boolean[] isVisited = new boolean[N + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>();

        int cnt = 0;
        long ans = 0;

        Arrays.fill(dist, Integer.MAX_VALUE);

        for(int i = 0; i < N; i++) xIdx[xLen[i].num] = i;
        for(int i = 0; i < N; i++) yIdx[yLen[i].num] = i;
        for(int i = 0; i < N; i++) zIdx[zLen[i].num] = i;

        pq.add(new Node(1, 0));

        while(!pq.isEmpty()){
            Node cur = pq.poll();

            if(isVisited[cur.num]) continue;

            isVisited[cur.num] = true;
            cnt++;
            ans += cur.len;

            if(xIdx[cur.num]-1 >= 0) {
                pq.add(new Node(xLen[xIdx[cur.num]-1].num, Math.abs(xLen[xIdx[cur.num]].len - xLen[xIdx[cur.num]-1].len)));
            }
            if(xIdx[cur.num]+1 < N) {
                pq.add(new Node(xLen[xIdx[cur.num]+1].num, Math.abs(xLen[xIdx[cur.num]].len - xLen[xIdx[cur.num]+1].len)));
            }

            if(yIdx[cur.num]-1 >= 0) {
                pq.add(new Node(yLen[yIdx[cur.num]-1].num, Math.abs(yLen[yIdx[cur.num]].len - yLen[yIdx[cur.num]-1].len)));
            }
            if(yIdx[cur.num]+1 < N) {
                pq.add(new Node(yLen[yIdx[cur.num]+1].num, Math.abs(yLen[yIdx[cur.num]].len - yLen[yIdx[cur.num]+1].len)));
            }

            if(zIdx[cur.num]-1 >= 0) {
                pq.add(new Node(zLen[zIdx[cur.num]-1].num, Math.abs(zLen[zIdx[cur.num]].len - zLen[zIdx[cur.num]-1].len)));
            }
            if(zIdx[cur.num]+1 < N) {
                pq.add(new Node(zLen[zIdx[cur.num]+1].num, Math.abs(zLen[zIdx[cur.num]].len - zLen[zIdx[cur.num]+1].len)));
            }
        }

        System.out.print(ans);
    }
}
