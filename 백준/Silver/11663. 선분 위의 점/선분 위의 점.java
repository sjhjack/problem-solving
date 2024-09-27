import java.io.*;
import java.util.*;

class Main {
    static int N, M;
    static int[] dots;
    static Line[] lines;
    
    static class Line {
        int start;
        int end;

        public Line(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dots = new int[N];
        lines = new Line[M];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            dots[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            lines[i] = new Line(start, end);
        }
    }

    static void solve() {
        StringBuilder ans = new StringBuilder();

        Arrays.sort(dots);

        for(Line line : lines) {
            int start = Arrays.binarySearch(dots, line.start);
            int end = Arrays.binarySearch(dots, line.end);

            start = start < 0 ? ~start : start;
            end = end < 0 ? ~end - 1: end;

            ans.append(end - start + 1).append("\n");
        }

        System.out.print(ans);
    }
}
