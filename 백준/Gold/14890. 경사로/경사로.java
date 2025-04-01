import java.io.*;
import java.util.*;

class Main {
    static int N, L;
    static int[][] arr;
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        arr = new int[N + N][N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < N; j++) {
                int height = Integer.parseInt(st.nextToken());
                
                arr[i][j] = height;
                arr[j + N][i] = height;
            }
        }
    }

    static void solve() {
        int ans = 0;

        for(int i = 0; i < N + N; i++) {
            boolean success = true;
            int left = 0;
            int right = 1;

            while(right < N) {
                while(right < N && arr[i][left] == arr[i][right]) {
                    right++;
                }
        
                if(right == N) {
                    break;
                }
    
                if(Math.abs(arr[i][left] - arr[i][right]) > 1) {
                    success = false;
                    break;
                }

                if(arr[i][left] < arr[i][right]) {
                    if(right - left < L) {
                        success = false;
                        break;
                    }
                } else {
                    int height = arr[i][right];

                    for(int j = 0; j < L; j++) {
                        // 내려가지 못하는 경우
                        if(right + j >= N || arr[i][right + j] != height) {
                            success = false;
                            break;
                        }
                    }

                    if(!success) {
                        break;
                    }

                    right = right + L;

                    // 내려간 직후에 높이가 변하는 경우
                    if(right < N) {
                        if(height > arr[i][right]) {
                            right--;
                        } else if(height < arr[i][right]) {
                            // 내려간 직후에 올라갈 수 없다
                            success = false;
                            break;
                        }
                    }
                }

                left = right;
                right++;
            }

            if(success) {
                ans++;
            }
        }

        System.out.print(ans);
    }
}
