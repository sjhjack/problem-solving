import java.io.*;
import java.util.*;

class Main {
    static int N;
    static int[] arr;
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void solve() {
        Set<Integer> set = new HashSet<>();
        long ans = 0;
        int left = 0;
        int right = 0;

        while(right < N) {
            if(!set.contains(arr[right])) {
                set.add(arr[right]);
                right++;
                continue;
            } else {
                ans += right - left;
                set.remove(arr[left]);
                left++;
            }
        }

        for(int i = 1; i <= right - left; i++) {
            ans += i;
        }

        System.out.print(ans);
    }
}
