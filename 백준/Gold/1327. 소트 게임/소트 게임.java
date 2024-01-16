import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int K, N;
    static String first;
    static Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        char[] arr = new char[N];

        String s = br.readLine();
        for(int i = 0; i < 2*N; i+=2){
            arr[i/2] = s.charAt(i);
        }

        first = new String(arr);
    }

    static void solve(){
        Queue<String> q = new ArrayDeque<>();
        q.add(new String(first));
        map.put(first, 0);
        int ans = Integer.MAX_VALUE;

        while(!q.isEmpty()){
            String cur = q.poll();
            int cnt = map.get(cur);

            char[] tmp = cur.toCharArray();
            boolean flag = true;

            for(int i = 0; i < N-1; i++){
                if(tmp[i] > tmp[i+1]){
                    flag = false;
                    break;
                }
            }

            // 오름차순인 경우
            if(flag) {
                ans = Math.min(ans, cnt);
                continue;
            }

            for(int i = 0; i <= N - K; i++){
                String next = swap(cur, i);

                if(map.containsKey(next)){
                    if(map.get(next) > cnt + 1){
                        map.put(next, cnt + 1);
                        q.add(next);
                    }
                } else {
                    map.put(next, cnt + 1);
                    q.add(next);
                }
            }
        }

        if(ans == Integer.MAX_VALUE) System.out.print(-1);
        else System.out.print(ans);
    }

    static String swap(String s, int idx){
        char[] arr = s.toCharArray();
        int left = idx;
        int right = idx + K - 1;
        char tmp;

        while(left < right) {
            tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;

            left++;
            right--;
        }

        return new String(arr);
    }
}
