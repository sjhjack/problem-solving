import java.io.*;
import java.util.*;

class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder ans = new StringBuilder();
    
    static int V, E;
    static List<Integer>[] adjList;

    static class Node {
        int from;
        int number;

        public Node(int from, int number) {
            this.from = from;
            this.number = number;
        }
    }
    
    public static void main(String[] args) throws IOException {
        int K = Integer.parseInt(br.readLine());

        for(int k = 0; k < K; k++) {
            init();
            solve();            
        }

        System.out.print(ans);
    }

    static void init() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        adjList = new List[V + 1];
        
        for(int i = 1; i <= V; i++) {
            adjList[i] = new ArrayList<>();
        }

        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            adjList[from].add(to);
            adjList[to].add(from);
        }
    }

    static void solve() {
        int[] mark = new int[V + 1];
        boolean isOk = true;

        for(int i = 1; i <= V; i++) {
            if(mark[i] > 0) {
                continue;
            }

            Queue<Node> queue = new ArrayDeque<>();
            queue.add(new Node(0, i));
            mark[i] = 1;

            while(!queue.isEmpty()) {
                Node cur = queue.poll();

                for(int next : adjList[cur.number]) {
                    if(mark[cur.number] == mark[next]) {
                        isOk = false;
                        break;
                    }
                    
                    if(next == cur.from || mark[next] > 0) {
                        continue;
                    }

                    queue.add(new Node(cur.number, next));
                    mark[next] = mark[cur.number] == 1 ? 2 : 1;
                }

                if(!isOk) {
                    break;
                }
            }

            if(!isOk) {
                break;
            }
        }

        ans.append(isOk ? "YES" : "NO").append("\n");
    }
}
