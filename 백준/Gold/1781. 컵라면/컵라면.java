import java.io.*;
import java.util.*;

class Main {
    static int N;
    static Work[] workList;

    static class Work implements Comparable<Work> {
        int deadline;
        int value;

        public Work(int deadline, int value) {
            this.deadline = deadline;
            this.value = value;
        }

        @Override
        public int compareTo(Work o) {
            return deadline - o.deadline;
        }
    }
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        workList = new Work[N];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int deadline = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            workList[i] = new Work(deadline, value);
        }

        Arrays.sort(workList);
    }

    static void solve() {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        int today = workList[N - 1].deadline;
        int index = workList.length - 1;
        int ans = 0;

        while(today > 0) {
            while(index >= 0 && workList[index].deadline >= today) {
                pq.add(workList[index].value);
                index--;
            }

            if(!pq.isEmpty()) {
                ans += pq.poll();                
            }
            
            today--;            
        }

        System.out.print(ans);
    }
}
