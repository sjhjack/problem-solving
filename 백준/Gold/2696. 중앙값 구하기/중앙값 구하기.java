import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder ans = new StringBuilder();
    private static int N, M;
    private static int mid;
    private static int[] arr;
    private static PriorityQueue<Integer> lowerPQ;
    private static PriorityQueue<Integer> upperPQ;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++) {
            input();
            solve();
        }

        System.out.print(ans);
    }

    private static void input() throws IOException {
        // 최대값 return
        lowerPQ = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
        // 최소값 return
        upperPQ = new PriorityQueue<>();

        M = Integer.parseInt(br.readLine());
        N = M / 10 + 1;

        arr = new int[M];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; i * 10 + j < M && st.hasMoreTokens(); j++) {
                arr[i * 10 + j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void solve() {
        int count = 1;

        if(M % 2 == 0) {
            ans.append(M / 2).append("\n");
        } else {
            ans.append(M / 2 + 1).append("\n");
        }

        mid = arr[0];
        ans.append(mid).append(" ");

        for(int i = 1; i < M; i++) {
            insert(arr[i]);

            if(i % 2 == 0) {
                sort();
                ans.append(mid);

                if(++count == 10) {
                    ans.append("\n");
                    count = 0;
                } else {
                    ans.append(" ");
                }
            }
        }

        ans.append("\n");
    }

    private static void sort() {
        // 아무것도 안 들어있거나, 이미 정렬되어 있는 경우
        if(lowerPQ.size() == upperPQ.size()) {
            return;
        }

        // lowerPQ -> upperPQ로 이동시킴
        while(lowerPQ.size() > upperPQ.size()) {
            upperPQ.add(mid);
            mid = lowerPQ.poll();
        }

        // upperPQ -> lowerPQ로 이동시킴
        while(lowerPQ.size() < upperPQ.size()) {
            lowerPQ.add(mid);
            mid = upperPQ.poll();
        }
    }

    private static void insert(int number) {
        if(number <= mid) {
            lowerPQ.add(number);
        } else {
            upperPQ.add(number);
        }
    }
}
