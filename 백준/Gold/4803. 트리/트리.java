import java.io.*;
import java.util.*;

class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder ans = new StringBuilder();
    static int N, M;
    static List<Integer>[] adjList;
    
    public static void main(String[] args) throws IOException {
        int testCase = 0;
        
        while(true) {
            String s = br.readLine();
            if(s.equals("0 0")) {
                break;
            }
            StringTokenizer st = new StringTokenizer(s);
            N = Integer.parseInt(st.nextToken());            
            M = Integer.parseInt(st.nextToken());
            testCase++;

            init();
            int treeCnt = solve();
            print(testCase, treeCnt);
        }

        System.out.print(ans);        
    }

    static void init() throws IOException {
        adjList = new List[N + 1];
        
        for(int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            adjList[from].add(to);
            adjList[to].add(from);
        }
    }

    static int solve() {
        boolean[] isVisited = new boolean[N + 1];
        Queue<Integer> queue = new ArrayDeque<>();
        int cnt = 0;

        for(int i = 1; i <= N; i++) {
            if(isVisited[i]) {
               continue; 
            }

            int edge = 0;
            int vertex = 1;
            
            isVisited[i] = true;
            queue.add(i);
            
            while(!queue.isEmpty()) {
                int cur = queue.poll();

                for(int next : adjList[cur]) {
                    edge++;
                    
                    if(isVisited[next]) {
                        continue;
                    }
                    
                    queue.add(next);
                    isVisited[next] = true;
                    vertex++;
                }
            }

            if(edge / 2 == vertex - 1) {
                cnt++;
            }
        }

        return cnt;
    }

    static void print(int testCase, int treeCnt) {
        switch (treeCnt) {
            case 0:
                ans.append("Case ").append(testCase).append(": No trees.\n");
                break;
            case 1:
                ans.append("Case ").append(testCase).append(": There is one tree.\n");
                break;
            default:
                ans.append("Case ").append(testCase).append(": A forest of ").append(treeCnt).append(" trees.\n");
                break;
        }
    }
}
