import java.io.*;
import java.util.*;

class Main {

    static int N, M;
    static int[] arr;
    static int ans;
    
    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];

        int min = 10000;
        int max = 0;
        st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }

        ans = max - min;
    }

    static void solve() {
        int start = 0;
        int end = ans;

        while(start <= end) {
            int mid = (start + end) / 2;

            if(canMakeGroups(mid)) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        System.out.print(ans);
    }

    static boolean canMakeGroups(int gap) {
        int cnt = 0;
        int min = arr[0];
        int max = arr[0];

        for(int i = 1; i < N; i++) {
            max = Math.max(max, arr[i]);
            
            if(arr[i] < min) {
                min = arr[i];

                if(max - min > gap) {
                    cnt++;
                    max = arr[i];
                }
            } else {
                if(arr[i] - min > gap) {
                    cnt++;
                    min = arr[i];
                    max = arr[i];
                    
                    if(cnt > M) {
                        return false;
                    }
                }
            }
        }

        cnt++;

        if(cnt <= M) {
            return true;
        } else {
            return false;
        }
    }
}
