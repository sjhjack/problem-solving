import java.io.*;
import java.util.*;

class Main {
    static int N, M;
    static List<Stuff>[] stuffList;
    static int[] stuffCount;
    static int[] inDegree;

    static class Stuff {
        int number;
        int count;

        public Stuff(int number, int count) {
            this.number = number;
            this.count = count;
        }
    }
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        stuffList = new List[N + 1];
        stuffCount = new int[N + 1];
        inDegree = new int[N + 1];

        for(int i = 1; i <= N; i++) {
            stuffList[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            stuffList[X].add(new Stuff(Y, K));
            inDegree[Y]++;
        }
    }

    static void solve() {
        Queue<Integer> queue = new ArrayDeque<>();

        queue.add(N);
        stuffCount[N] = 1;

        while(!queue.isEmpty()) {
            int cur = queue.poll();
            
            for(Stuff next : stuffList[cur]) {
                stuffCount[next.number] += stuffCount[cur] * next.count;
                
                if(--inDegree[next.number] == 0) {
                    queue.add(next.number);
                }
            }
        }
    }

    static void print() {
        StringBuilder ans = new StringBuilder();

        for(int i = 1; i <= N; i++) {
            if(stuffList[i].isEmpty()) {
                ans.append(i).append(" ").append(stuffCount[i]).append("\n");
            }
        }

        System.out.print(ans);
    }
}
