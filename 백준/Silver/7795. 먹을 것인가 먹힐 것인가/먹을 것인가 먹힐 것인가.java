import java.io.*;
import java.util.*;

class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder ans = new StringBuilder();
    
    static int N, M;
    static int[] arrA, arrB;
    
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++) {
            init();
            solve();
        }

        System.out.print(ans);
    }

    static void init() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arrA = new int[N];
        arrB = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arrA[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            arrB[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void solve() {
        int count = 0;
        
        Arrays.sort(arrB);

        for(int i = 0; i < N; i++) {
            count += binarySearch(arrA[i]);
        }

        ans.append(count).append("\n");
    }

    static int binarySearch(int target) {
        int left = 0;
        int right = arrB.length - 1;

        while(left <= right) {
            int mid = (left + right) / 2;

            if(target <= arrB[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
