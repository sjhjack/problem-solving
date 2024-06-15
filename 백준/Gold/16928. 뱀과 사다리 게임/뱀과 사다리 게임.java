import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int[] map;
    private static int[] shortcut;

    private static class Pos {
        int num;
        int count;

        public Pos(int num, int count) {
            this.num = num;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        input();
        solve();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            shortcut[from] = to;
        }
    }

    private static void init() {
        map = new int[101];
        shortcut = new int[101];

        Arrays.fill(map, Integer.MAX_VALUE);
    }

    private static void solve() {
        Queue<Pos> queue = new ArrayDeque<>();

        queue.add(new Pos(1, 0));

        while(!queue.isEmpty()) {
            Pos cur = queue.poll();

            for(int i = 1; i <= 6; i++) {
                int next = cur.num + i;

                if(next > 100) {
                    break;
                } else if(next == 100) {
                    System.out.print(cur.count + 1);
                    return;
                }

                if(shortcut[next] > 0) {
                    next = shortcut[next];
                }

                if(map[next] > cur.count + 1) {
                    map[next] = cur.count + 1;
                    queue.add(new Pos(next, cur.count + 1));
                }
            }
        }
    }
}
