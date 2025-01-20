import java.io.*;
import java.util.*;

class Main {
    static int N;
    static Line[] arr;

    static class Line implements Comparable<Line> {
        int A;
        int B;

        public Line(int A, int B) {
            this.A = A;
            this.B = B;
        }

        @Override
        public int compareTo(Line o) {
            return A - o.A;
        }
    }
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new Line[N];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            arr[i] = new Line(A, B);
        }
    }

    static void solve() {
        int[] lis = new int[N];
        int maxIdx = -1;

        Arrays.sort(arr);
        Arrays.fill(lis, 5000);

        for(int i = 0; i < N; i++) {
            int index = Arrays.binarySearch(lis, arr[i].B);

            if(index < 0) {
                index = -1 * index - 1;
            }

            lis[index] = arr[i].B;
            maxIdx = Math.max(maxIdx, index);
        }

        System.out.println(N - maxIdx - 1);
    }
}
