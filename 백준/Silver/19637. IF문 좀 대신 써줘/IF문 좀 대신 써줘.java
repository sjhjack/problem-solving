import java.io.*;
import java.util.*;

class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
    
    static Map<Integer, String> map;
    static int N, M;
    static int[] arr;
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        map = new HashMap<>();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        
        int index = 0;
        
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int score = Integer.parseInt(st.nextToken());

            if(map.containsKey(score)) {
                continue;
            }

            map.put(score, name);
            arr[index++] = score;
        }

        while(index < N) {
            arr[index++] = Integer.MAX_VALUE;
        }
    }

    static void solve() throws IOException {
        StringBuilder ans = new StringBuilder();
        
        for(int i = 0; i < M; i++) {
            int score = Integer.parseInt(br.readLine());
            int index = Arrays.binarySearch(arr, score);

            if(index < 0) {
                index = -1 * (index + 1);
            }

            ans.append(map.get(arr[index])).append("\n");
        }

        System.out.print(ans);
    }
}
