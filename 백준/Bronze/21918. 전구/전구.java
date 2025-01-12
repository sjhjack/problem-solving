import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static boolean[] arr;
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();        
    }

    static void init() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new boolean[N + 1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken()) == 1;
        }
    }

    static void solve() throws IOException {
        for(int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            if(command == 1) {
                arr[left] = right == 1;
            } else if(command == 2) {
                for(int j = left; j <= right; j++) {
                    arr[j] = !arr[j];
                }
            } else if(command == 3) {
                for(int j = left; j <= right; j++) {
                    arr[j] = false;
                }
            } else {
                for(int j = left; j <= right; j++) {
                    arr[j] = true;
                }
            }
        }
    }

    static void print() {
        StringBuilder ans = new StringBuilder();
        
        for(int i = 1; i <= N; i++) {
            ans.append(arr[i] ? 1 : 0).append(" ");
        }

        System.out.print(ans);
    }
}