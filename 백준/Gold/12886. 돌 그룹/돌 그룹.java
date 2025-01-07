import java.io.*;
import java.util.*;

class Main {
    static Queue<Stone> queue;
    static boolean[][] isVisited;

    static class Stone {
        int A;
        int B;
        int C;

        public Stone(int A, int B, int C) {
            this.A = A;
            this.B = B;
            this.C = C;
        }

        public boolean isEqual() {
            return A == B && B == C;
        }
    }
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        queue = new ArrayDeque<>();
        isVisited = new boolean[1001][1001];
        
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int max = Math.max(A, Math.max(B, C));
        int min = Math.min(A, Math.min(B, C));
        int mid = A + B + C - max - min;

        queue.add(new Stone(min, mid, max));
        isVisited[min][mid] = true;
    }

    static void solve() {
        while(!queue.isEmpty()) {
            Stone cur = queue.poll();

            if(cur.isEqual()) {
                System.out.print(1);
                return;
            }

            if(cur.A != cur.B) {
                Stone newStone = moveStone(cur.A, cur.B, cur.C);

                if(!isVisited[newStone.A][newStone.B]) {
                    isVisited[newStone.A][newStone.B] = true;
                    queue.add(newStone);
                }
            }

            if(cur.A != cur.C) {
                Stone newStone = moveStone(cur.A, cur.C, cur.B);

                if(!isVisited[newStone.A][newStone.B]) {
                    isVisited[newStone.A][newStone.B] = true;
                    queue.add(newStone);
                }
            }

            if(cur.B != cur.C) {
                Stone newStone = moveStone(cur.B, cur.C, cur.A);

                if(!isVisited[newStone.A][newStone.B]) {
                    isVisited[newStone.A][newStone.B] = true;
                    queue.add(newStone);
                }
            }
        }

        System.out.print(0);
    }

    static Stone moveStone(int small, int big, int another) {
        int tmpSmall = small + small;
        int tmpBig = big - small;

        int max = Math.max(tmpSmall, Math.max(tmpBig, another));
        int min = Math.min(tmpSmall, Math.min(tmpBig, another));
        int mid = tmpSmall + tmpBig + another - max - min;

        return new Stone(min, mid, max);
    }
}
