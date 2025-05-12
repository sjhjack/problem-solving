import java.io.*;
import java.util.*;

class Main {
    static int N;
    static List<Integer>[] adjList;
    static boolean[] isVisited;
    static boolean hasCycle;
    
    public static void main(String[] args) throws IOException {
        init();
        solve(1);
        System.out.print(hasCycle ? "CYCLE" : "NO CYCLE");
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        adjList = new List[N + 1];
        isVisited = new boolean[N + 1];

        for(int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        for(int i = 1; i < N; i++) {
            int M = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j = 0; j < M; j++) {
                adjList[i].add(Integer.parseInt(st.nextToken()));
            }
        }
    }

    static void solve(int number) {
        if(hasCycle || number == N) {
            return;
        }

        isVisited[number] = true;

        for(int next : adjList[number]) {
            if(isVisited[next]) {
                hasCycle = true;
                return;
            }

            solve(next);
        }

        // 현재 경로에서의 사이클 탐색은 종료됨
        // 다른 경로에서의 탐색을 위해 다시 false로 되돌림
        isVisited[number] = false;
    }
}
