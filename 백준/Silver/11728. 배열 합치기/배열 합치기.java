import java.io.*;
import java.util.*;

class Main {
    static int N, M;
    static int[] arrA, arrB;
    
    public static void main(String[] args) throws IOException {
        init();
        solve();        
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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
        StringBuilder ans = new StringBuilder();
        int indexA = 0;
        int indexB = 0;

        while(indexA < N && indexB < M) {
            if(arrA[indexA] <= arrB[indexB]) {
                ans.append(arrA[indexA++]).append(" ");
            } else {
                ans.append(arrB[indexB++]).append(" ");
            }
        }

        while(indexA < N) {
            ans.append(arrA[indexA++]).append(" ");
        }

        while(indexB < M) {
            ans.append(arrB[indexB++]).append(" ");
        }

        System.out.print(ans);
    }
}