import java.io.*;
import java.util.*;

class Main {
    static int N;
    static int L, P;
    static Station[] stations;

    static class Station implements Comparable<Station> {
        int location;
        int fuel;

        public Station(int location, int fuel) {
            this.location = location;
            this.fuel = fuel;
        }

        @Override
        public int compareTo(Station o) {
            return location - o.location;
        }
    }
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        stations = new Station[N];
        
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int location = Integer.parseInt(st.nextToken());
            int fuel = Integer.parseInt(st.nextToken());
            
            stations[i] = new Station(location, fuel);
        }

        st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
    }

    static void solve() {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int index = 0;
        int ans = 0;

        Arrays.sort(stations);

        while(P < L) {
            // 현재 위치에서 도달 가능한 모든 주유소의 연료를 PQ에 넣기
            while(index < N && stations[index].location <= P) {
                pq.add(stations[index++].fuel);
            }

            if(!pq.isEmpty()) {
                // 가장 많은 양의 연료부터 주유
                P += pq.poll();
                ans++;
            } else {
                // 더 이상 주유할 수 없고 다음 주유소에 갈 수 없음
                ans = -1;
                break;
            }
        }

        System.out.print(ans);
    }
}
