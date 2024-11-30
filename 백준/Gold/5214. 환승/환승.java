import java.io.*;
import java.util.*;

class Main {
    static int N, K, M;
    static List<Integer>[] stations;
    static List<Integer>[] tubes;

    static class Station {
        int number;
        int count;

        public Station(int number, int count) {
            this.number = number;
            this.count = count;
        }
    }
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        stations = new List[N + 1];
        tubes = new List[M];

        for(int i = 1; i <= N; i++) {
            stations[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            tubes[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < K; j++) {
                int num = Integer.parseInt(st.nextToken());

                stations[num].add(i);
                tubes[i].add(num);
            }
        }
    }

    static void solve() {
        Queue<Station> queue = new ArrayDeque<>();
        boolean[] visitedStation = new boolean[N + 1];
        boolean[] visitedTube = new boolean[M];

        queue.add(new Station(1, 1));
        visitedStation[1] = true;

        while(!queue.isEmpty()) {
            Station cur = queue.poll();

            if(cur.number == N) {
                System.out.print(cur.count);
                return;
            }

            for(int nextTube : stations[cur.number]) {
                if(visitedTube[nextTube]) {
                    continue;
                }
                visitedTube[nextTube] = true;
                
                for(int nextStation : tubes[nextTube]) {
                    if(visitedStation[nextStation]) {
                        continue;
                    }

                    queue.add(new Station(nextStation, cur.count + 1));
                    visitedStation[nextStation] = true;
                }
            }
        }

        System.out.print(-1);
    }
}
