import java.util.*;
import java.io.*;

class Main {
    static int N;
    static List<Lecture> list;

    static class Lecture implements Comparable<Lecture> {
        int num;
        int start;
        int end;

        public Lecture(int num, int start, int end) {
            this.num = num;
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Lecture o) {
            if(start == o.start) {
                return end - o.end;
            }

            return start - o.start;
        }
    }
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            list.add(new Lecture(num, start, end));
        }
    }

    static void solve() {
        // pq.size() : 현재 사용중인 강의실 개수
        // 동시에 진행중인 강의들의 종료시간이 들어있음
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int ans = 1;

        Collections.sort(list);

        for(int i = 0; i < N; i++) {
            while(!pq.isEmpty() && pq.peek() <= list.get(i).start) {
                // 수업 끝난 강의실 제거
                pq.poll();
            }

            // 새로운 강의 시작
            pq.add(list.get(i).end);
            ans = Math.max(ans, pq.size());
        }

        System.out.print(ans);
    }
}
