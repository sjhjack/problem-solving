import java.io.*;
import java.util.*;

class Main {
    static class Medal implements Comparable<Medal> {
        int gold;
        int silver;
        int bronze;

        public Medal(int gold, int silver, int bronze) {
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }

        @Override
        public int compareTo(Medal o) {
            if(this.gold == o.gold) {
                if(this.silver == o.silver) {
                    return o.bronze - this.bronze;
                }
                return o.silver - this.silver;
            }
            return o.gold - this.gold;
        }

        public boolean isTarget(Medal o) {
            return this.gold == o.gold && this.silver == o.silver && this.bronze == o.bronze;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Medal[] arr = new Medal[N];
        Medal target = null;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int country = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());

            arr[i] = new Medal(gold, silver, bronze);

            if(country == K) {
                target = new Medal(gold, silver, bronze);
            }
        }

        Arrays.sort(arr);

        int ans = 1;
        int idx = 0;

        while(idx < N && !target.isTarget(arr[idx])) {
            ans++;
            idx++;
        }

        System.out.print(ans);
    }
}
