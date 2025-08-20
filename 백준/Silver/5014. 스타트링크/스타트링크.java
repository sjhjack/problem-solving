import java.io.*;
import java.util.*;

class Main {
    static int F, S, G, U, D;

    static class Floor {
        int number;
        int count;

        public Floor(int number, int count) {
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
        StringTokenizer st = new StringTokenizer(br.readLine());

        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
    }

    static void solve() {
        Queue<Floor> queue = new ArrayDeque<>();
        boolean[] isVisited = new boolean[F + 1];

        queue.add(new Floor(S, 0));
        isVisited[S] = true;

        while(!queue.isEmpty()) {
            Floor cur = queue.poll();
            int up = cur.number + U;
            int down = cur.number - D;

            if(cur.number == G) {
                System.out.print(cur.count);
                return;
            }

            if(up <= F && !isVisited[up]) {
                queue.add(new Floor(up, cur.count + 1));
                isVisited[up] = true;
            }

            if(down > 0 && !isVisited[down]) {
                queue.add(new Floor(down, cur.count + 1));
                isVisited[down] = true;
            }
        }

        System.out.print("use the stairs");
    }
}
