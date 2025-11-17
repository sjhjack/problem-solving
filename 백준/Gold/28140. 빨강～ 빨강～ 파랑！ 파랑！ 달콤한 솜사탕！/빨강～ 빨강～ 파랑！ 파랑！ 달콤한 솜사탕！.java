import java.io.*;
import java.util.*;

class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N, Q;
    static int[] arrR, arrB;
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        char[] arr = br.readLine().toCharArray();
        List<Integer> listR = new ArrayList<>();
        List<Integer> listB = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            if(arr[i] == 'R') {
                listR.add(i);
            } else if(arr[i] == 'B') {
                listB.add(i);
            }
        }

        arrR = listR.stream()
               .mapToInt(i -> i)
               .toArray();
        arrB = listB.stream()
               .mapToInt(i -> i)
               .toArray();
    }

    static void solve() throws IOException {
        StringBuilder ans = new StringBuilder();

        for(int i = 0; i < Q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int indexR = getLowerBound(arrR, l);

            if(indexR >= arrR.length - 1 || arrR[indexR + 1] > r) {
                ans.append("-1\n");
                continue;
            }
            
            int indexB = getLowerBound(arrB, arrR[indexR + 1] + 1);

            if(indexB >= arrB.length - 1 || arrB[indexB + 1] > r) {
                ans.append("-1\n");
                continue;
            }

            ans.append(arrR[indexR] + " " + arrR[indexR + 1])
               .append(" " + arrB[indexB] + " " + arrB[indexB + 1] + "\n");
        }

        System.out.print(ans);
    }

    static int getLowerBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while(left <= right) {
            int mid = (left + right) / 2;

            if(arr[mid] >= target) {
                right = mid - 1;
            } else if(arr[mid] < target) {
                left = mid + 1;
            }
        }

        return right + 1;
    }
}
