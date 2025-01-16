import java.io.*;
import java.util.*;

class Main {
    static Map<String, Integer> map;
    static int N;
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new HashMap<>();
        N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            String title = br.readLine();
            map.put(title, map.getOrDefault(title, 0) + 1);
        }
    }

    static void solve() {
        String ans = "";
        int max = 0;

        for(String key : map.keySet()) {
            int count = map.get(key);

            if(max < count) {
                max = count;
                ans = key;
            } else if(max == count && key.compareTo(ans) < 0) {
                ans = key;
            }
        }

        System.out.print(ans);
    }
}