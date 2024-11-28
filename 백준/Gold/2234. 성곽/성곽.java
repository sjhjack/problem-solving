import java.io.*;
import java.util.*;

class Main {
    static final int[] dr = {0,-1,0,1};   // 좌상우하
    static final int[] dc = {-1,0,1,0};
    
    static int N, M;
    static int max;
    static int[][] arr;
    static int[][] roomArr;
    static Map<Integer, Integer> map;

    static class Pos {
        int row;
        int col;

        public Pos(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        arr = new int[M][N];
        roomArr = new int[M][N];
        map = new HashMap<>();

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void solve() {
        countRoom();
        deleteWall();        
    }

    static void countRoom() {
        Queue<Pos> queue = new ArrayDeque<>();
        boolean[][] isVisited = new boolean[M][N];
        int roomNumber = 0;

        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                if(!isVisited[i][j]) {
                    int cnt = 1;
                    queue.add(new Pos(i, j));
                    isVisited[i][j] = true;
                    roomArr[i][j] = ++roomNumber;

                    while(!queue.isEmpty()) {
                        Pos cur = queue.poll();

                        for(int d = 0; d < 4; d++) {
                            if((arr[cur.row][cur.col] & (1 << d)) > 0) {
                                continue;
                            }

                            int nr = cur.row + dr[d];
                            int nc = cur.col + dc[d];

                            if(isVisited[nr][nc]) {
                                continue;
                            }

                            isVisited[nr][nc] = true;
                            roomArr[nr][nc] = roomNumber;
                            cnt++;
                            queue.add(new Pos(nr, nc));
                        }
                    }

                    map.put(roomNumber, cnt);
                }
            }
        }
    }

    static void deleteWall() {
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                int curRoom = roomArr[i][j];
                int curRoomSize = map.get(curRoom);
                
                for(int d = 2; d <= 3; d++) {
                    if((arr[i][j] & (1 << d)) > 0) {
                        int nr = i + dr[d];
                        int nc = j + dc[d];

                        if(nr >= M || nc >= N) {
                            continue;
                        }

                        int nextRoom = roomArr[nr][nc];

                        if(curRoom == nextRoom) {
                            continue;
                        }

                        max = Math.max(max, curRoomSize + map.get(nextRoom));
                    }
                }
            }
        }        
    }

    static void print() {
        StringBuilder ans = new StringBuilder();

        int maxSize = 0;
        for(int room : map.keySet()) {
            maxSize = Math.max(maxSize, map.get(room));
        }

        ans.append(map.size()).append("\n");
        ans.append(maxSize).append("\n");
        ans.append(max);

        System.out.print(ans);
    }
}
