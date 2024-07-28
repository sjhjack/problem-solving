import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int D, N;
    private static int ans;
    private static int[] oven;
    private static int[] minSize;
    private static Queue<Integer> pizzaList = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        D = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        oven = new int[D];
        minSize = new int[D];
        ans = D;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < D; i++) {
            oven[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            pizzaList.add(Integer.parseInt(st.nextToken()));
        }
    }

    private static void solve() {
        findMinSize();

        while(!pizzaList.isEmpty()) {
            int pizza = pizzaList.poll();

            if(!putPizza(pizza)) {
                System.out.print(0);
                return;
            }
        }

        System.out.print(ans + 1);
    }

    private static void findMinSize() {
        minSize[0] = oven[0];

        for(int i = 1; i < D; i++) {
            minSize[i] = Math.min(minSize[i - 1], oven[i]);
        }
    }

    private static boolean putPizza(int pizza) {
        int start = 0;
        int end = ans;
        int depth = -1;

        while(start < end) {
            int mid = (start + end) / 2;

            if(minSize[mid] < pizza) {
                end = mid;
                continue;
            }

            depth = mid;
            start = mid + 1;
        }

        if(depth < 0) {
            return false;
        } else {
            ans = depth;
            return true;
        }
    }
}
