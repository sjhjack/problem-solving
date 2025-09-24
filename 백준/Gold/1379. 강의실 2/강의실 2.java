import java.io.*;
import java.util.*;

class Main {
    static int N, maxSize;
    static Lecture[] arr;
    static int[] classroom;

    static class Lecture implements Comparable<Lecture> {
        int number;
        int start;
        int end;

        public Lecture(int number, int start, int end) {
            this.number = number;
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Lecture o) {
            return end - o.end;
        }
    }
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        maxSize = 0;
        arr = new Lecture[N];
        classroom = new int[N + 1];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            
            arr[i] = new Lecture(number, start, end);
        }

        Arrays.sort(arr, (o1, o2) -> o1.start - o2.start);
    }

    static void solve() {
        PriorityQueue<Lecture> pq = new PriorityQueue<>();
        Queue<Integer> queueStart = new ArrayDeque<>();
        int now = arr[0].start;
        int index = 0;

        while(!pq.isEmpty() || index < N) {
            while(!pq.isEmpty() && pq.peek().end <= now) {
                Lecture cur = pq.poll();
                queueStart.add(classroom[cur.number]);
            }
            
            while(index < N && arr[index].start <= now) {
                pq.add(arr[index]);

                if(maxSize < pq.size()) {
                    queueStart.add(pq.size());
                    maxSize = pq.size();
                }

                int classroomNumber = queueStart.poll();
                classroom[arr[index].number] = classroomNumber;
                index++;
            }

            now++;
        }
    }

    static void print() {
        StringBuilder ans = new StringBuilder();

        ans.append(maxSize).append("\n");

        for(int i = 1; i <= N; i++) {
            ans.append(classroom[i]).append("\n");
        }

        System.out.print(ans);
    }
}
