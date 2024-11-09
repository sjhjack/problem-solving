import java.io.*;
import java.util.*;

class Main {
    static class Work implements Comparable<Work> {
        int time;
        int end;

        public Work(int time, int end) {
            this.time = time;
            this.end = end;
        }

        @Override
        public int compareTo(Work o) {
            return o.end - end;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Work[] arr = new Work[N];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            arr[i] = new Work(time, end);
        }

        Arrays.sort(arr);

        int ans = arr[0].end;

        for(int i = 0; i < N; i++) {
            ans = Math.min(ans, arr[i].end);
            ans -= arr[i].time;
        }

        System.out.print(ans >= 0 ? ans : -1);
    }
}
