import java.io.*;
import java.util.*;

class Main {
    static int N, X;
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

        X = Integer.parseInt(br.readLine());
    }

    static void solve() {
        int left = 0;
        int right = N - 1;
        int ans = 0;

        Arrays.sort(arr);

        while(left < right) {
            int sum = arr[left] + arr[right];
            
            if(sum == X) {
                if(arr[left] == arr[right]) {
                    int len = right - left + 1;
                    ans += len * (len - 1) / 2;
                    break;
                } else {
                    int leftCnt = 1;
                    int rightCnt = 1;
    
                    while(arr[left] == arr[left + 1] && left + 1 < right) {
                        leftCnt++;
                        left++;
                    }
                    while(arr[right - 1] == arr[right] && left < right - 1) {
                        rightCnt++;
                        right--;
                    }
    
                    ans += leftCnt * rightCnt;
                    left++;
                    right--;
                }
            } else if(sum < X) {
                left++;
            } else {
                right--;
            }
        }

        System.out.print(ans);
    }
}
