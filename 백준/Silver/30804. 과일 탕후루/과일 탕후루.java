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
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int maxLength = 1;

        for(int right = 0; right < N; right++) {
            map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);

            while(map.size() > 2) {
                int cnt = map.get(arr[left]);

                if(cnt == 1) {
                    map.remove(arr[left]);
                } else {
                    map.put(arr[left], cnt - 1);
                }

                left++;
            }
            
            maxLength = Math.max(maxLength, right - left + 1);
        }

        System.out.print(maxLength);
    }
}
