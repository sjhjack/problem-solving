import java.io.*;
import java.util.*;

class Main {
    static int N;
    static int[] arr;
    static Snowman[] snowman;

    static class Snowman implements Comparable<Snowman> {
        int height;
        int ball1;
        int ball2;

        public Snowman(int ball1, int ball2) {
            this.height = arr[ball1] + arr[ball2];
            this.ball1 = ball1;
            this.ball2 = ball2;
        }

        public boolean isDifferent(Snowman o) {
            return ball1 != o.ball1 && ball1 != o.ball2 &&
                   ball2 != o.ball1 && ball2 != o.ball2;
        }

        @Override
        public int compareTo(Snowman o) {
            return height - o.height;
        }

        @Override
        public String toString() {
            return "" + height;
        }
    }
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        snowman = new Snowman[(N-1)*N/2];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int index = 0;
        for(int i = 0; i < N - 1; i++) {
            for(int j = i + 1; j < N; j++) {
                if(i == j) {
                    continue;
                }

                snowman[index] = new Snowman(i, j);
                index++;
            }
        }

        Arrays.sort(snowman);
    }

    static void solve() {
        int ans = Integer.MAX_VALUE;

        for(int i = 0; i < snowman.length - 1; i++) {
            Snowman snow1 = snowman[i];
            Snowman snow2 = snowman[i + 1];

            if(snow1.isDifferent(snow2)) {
                ans = Math.min(ans, Math.abs(snow1.height - snow2.height));
            }
        }

        System.out.print(ans);
    }
}
