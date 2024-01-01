import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N, M, B;
    static int maxHeight, timeSpent;
    static List<Sand> list = new ArrayList<>();

    static class Sand {
        int height;
        int cnt;

        public Sand(int height, int cnt) {
            this.height = height;
            this.cnt = cnt;
        }
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        int[] arr = new int[N * M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                arr[i * M + j] = Integer.parseInt(st.nextToken());
            }
        }

        Arrays.sort(arr);

        int idx = 0;
        while(idx < arr.length){
            int cur = arr[idx];
            int cnt = 1;

            while(idx + 1 < arr.length && arr[idx+1] == cur){
                cnt++;
                idx++;
            }

            list.add(new Sand(cur, cnt));
            idx++;
        }
    }

    static void solve(){
        timeSpent = Integer.MAX_VALUE;

        for(int i = Math.min(list.get(list.size()-1).height, 256); i >= 0; i--){
            int blockRemainder = B;
            int time = 0;

            for(Sand cur : list){
                int blocks;
                
                if(cur.height < i){
                    blocks = (i - cur.height) * cur.cnt;
                    blockRemainder -= blocks;
                    time += blocks;
                } else if(cur.height > i){
                    blocks = (cur.height - i) * cur.cnt;
                    blockRemainder += blocks;
                    time += blocks * 2;
                }
            }

            if(blockRemainder >= 0 && timeSpent > time){
                timeSpent = time;
                maxHeight = i;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
        System.out.print(timeSpent + " " + maxHeight);
    }
}
