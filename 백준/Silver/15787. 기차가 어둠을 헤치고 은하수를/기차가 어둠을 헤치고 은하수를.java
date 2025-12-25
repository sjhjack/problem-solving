import java.io.*;
import java.util.*;

class Main {
    static final int MAX = Integer.parseInt("11111111111111111111", 2);
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Set<Integer> set = new HashSet<>();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] trains = new int[N + 1];
        int ans = 0;

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int train = Integer.parseInt(st.nextToken());

            if(command == 1) {
                int seat = Integer.parseInt(st.nextToken()) - 1;
                trains[train] |= (1 << seat);
            } else if(command == 2) {
                int seat = Integer.parseInt(st.nextToken()) - 1;
                trains[train] &= MAX ^ (1 << seat);
            } else if(command == 3) {
                trains[train] <<= 1;
                trains[train] &= MAX;    // 20번째 이후엔 하차
            } else {
                trains[train] >>= 1;
            }
        }

        for(int i = 1; i <= N; i++) {
            if(set.contains(trains[i])) {
                continue;
            }

            set.add(trains[i]);
            ans++;
        }

        System.out.print(ans);
    }
}
