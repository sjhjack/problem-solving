import java.io.*;
import java.util.*;

class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N, M;
    static int[] arr;
    
    public static void main(String[] args) throws IOException {
        StringBuilder ans = new StringBuilder();
        
        init();
        Arrays.sort(arr);

        for(int i = 0; i < M; i++) {
            int index = getLowerBound(Integer.parseInt(br.readLine()));
            ans.append(index).append("\n");
        }

        System.out.print(ans);
    }

    static void init() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
    }

    static int getLowerBound(int target) {
        int left = 0;
        int right = arr.length - 1;

        while(left <= right) {
            int mid = (left + right) / 2;

            if(arr[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return right + 1 < arr.length && arr[right + 1] == target ? right + 1 : -1;
    }
}
