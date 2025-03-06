import java.io.*;
import java.util.*;

class Main {
    static int N;
    static long[] AplusB, CplusD;
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        AplusB = new long[N * N];
        CplusD = new long[N * N];
        
        long[] arrA = new long[N];
        long[] arrB = new long[N];
        long[] arrC = new long[N];
        long[] arrD = new long[N];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arrA[i] = Integer.parseInt(st.nextToken());
            arrB[i] = Integer.parseInt(st.nextToken());
            arrC[i] = Integer.parseInt(st.nextToken());
            arrD[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                AplusB[N*i + j] = arrA[i] + arrB[j];
                CplusD[N*i + j] = arrC[i] + arrD[j];
            }
        }

        Arrays.sort(AplusB);
        Arrays.sort(CplusD);
    }

    static void solve() {
        long ans = 0;

        for(int i = 0; i < AplusB.length; i++) {
            long target = 0 - AplusB[i];
            ans += getUpperBound(target) - getLowerBound(target) + 1;
        }

        System.out.print(ans);
    }

    static int getLowerBound(long target) {
        int left = 0;
        int right = CplusD.length - 1;
        int index = -1;

        while(left <= right) {
            int mid = (left + right) / 2;
            long number = CplusD[mid];

            if(number == target) {
                index = mid;
                right = mid - 1;
            } else if(number < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return index;
    }

    static int getUpperBound(long target) {
        int left = 0;
        int right = CplusD.length - 1;
        int index = -2;

        while(left <= right) {
            int mid = (left + right) / 2;
            long number = CplusD[mid];

            if(number == target) {
                index = mid;
                left = mid + 1;
            } else if(number < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return index;
    }
}
