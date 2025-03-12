import java.io.*;
import java.util.*;

class Main {
    static int N, L;
    static Pool[] arr;

    static class Pool implements Comparable<Pool> {
        int start;
        int end;

        public Pool(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Pool o) {
            if(start == o.start) {
                return end - o.end;
            }
            return start - o.start;
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
        L = Integer.parseInt(st.nextToken());
        arr = new Pool[N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            
            arr[i] = new Pool(start, end);
        }

        Arrays.sort(arr);
    }

    static void solve() {
        int last = -1;
        int ans = 0;

        for(int i = 0; i < N; i++) {
            if(last >= arr[i].end) {
                // 이미 다 덮은 경우
                continue;
            }

            if(last >= arr[i].start) {
                // 걸쳐있는 경우
                int cnt = (arr[i].end - last) / L;
                int newPaperCnt = cnt + (last + cnt * L < arr[i].end ? 1 : 0);
                
                last = last + L * newPaperCnt;
                ans += newPaperCnt;
            } else {
                // 처음부터 새로 덮어야 하는 경우
                int cnt = (arr[i].end - arr[i].start) / L;
                int newPaperCnt = cnt + (arr[i].start + cnt * L < arr[i].end ? 1 : 0);
                
                last = arr[i].start + L * newPaperCnt;
                ans += newPaperCnt;
            }
        }

        System.out.print(ans);
    }
}
