import java.io.*;
import java.util.*;

class Main {
    static int N, M;
    static List<Integer>[] arr;
    static Map<String, Integer> universeMap;
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new List[M];
        universeMap = new HashMap<>();

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = new ArrayList<>();
            
            for(int j = 0; j < N; j++) {
                arr[i].add(Integer.parseInt(st.nextToken()));
            }
        }
    }

    static void solve() {
        int ans = 0;
        
        for(int i = 0; i < M; i++) {
            List<Integer> list = new ArrayList<>(arr[i]);
            Map<Integer, Integer> map = new HashMap<>();
            StringBuilder sb = new StringBuilder();
            
            Collections.sort(list);

            for(int j = 0; j < N; j++) {
                map.put(list.get(j), j);
            }

            for(int j = 0; j < N; j++) {
                sb.append(map.get(arr[i].get(j)));
            }

            universeMap.put(sb.toString(), universeMap.getOrDefault(sb.toString(), 0) + 1);
        }

        for(int value : universeMap.values()) {
            ans += (value - 1) * value / 2;
        }

        System.out.print(ans);
    }
}
