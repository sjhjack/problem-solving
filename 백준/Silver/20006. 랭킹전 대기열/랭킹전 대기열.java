import java.io.*;
import java.util.*;

class Main {
    static int P, M;
    static Player[] arr;

    static class Player implements Comparable<Player> {
        int level;
        String name;

        public Player(int level, String name) {
            this.level = level;
            this.name = name;
        }

        @Override
        public int compareTo(Player o) {
            return name.compareTo(o.name);
        }

        @Override
        public String toString() {
            return level + " " + name + "\n";
        }
    }
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        P = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new Player[P];

        for(int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());
            int level = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            arr[i] = new Player(level, name);
        }
    }

    static void solve() {
        StringBuilder ans = new StringBuilder();
        boolean[] isVisited = new boolean[P];

        for(int i = 0; i < P; i++) {
            if(isVisited[i]) {
                continue;
            }

            List<Player> room = new ArrayList<>();
            int level = arr[i].level;
            
            room.add(arr[i]);
            isVisited[i] = true;

            for(int j = 0; j < P; j++) {
                if(!isVisited[j] && room.size() < M && Math.abs(arr[j].level - level) <= 10) {
                    room.add(arr[j]);
                    isVisited[j] = true;
                }
            }

            Collections.sort(room);

            ans.append(room.size() == M ? "Started!" : "Waiting!").append("\n");

            for(Player player : room) {
                ans.append(player.toString());
            }
        }

        System.out.print(ans);
    }
}
