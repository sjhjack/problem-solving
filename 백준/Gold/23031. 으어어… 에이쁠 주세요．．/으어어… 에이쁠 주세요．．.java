import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    static final int[] dr = {-1,0,1,0 ,-1,1,1,-1};   // 상우하좌 우상 우하 좌하 좌상
    static final int[] dc = {0,1,0,-1 ,1,1,-1,-1};

    static int N;
    static int direction;
    
    static char[] command;
    static char[][] map;
    
    static boolean[][] flash;
    static boolean[][] isZombie;
    static boolean[][] isTurnOn;
    
    static List<Pos> zombies = new ArrayList<>();
    static Pos ahri = new Pos(0, 0, 2);

    static class Pos{
        int row;
        int col;
        int dir;

        public Pos(int row, int col, int dir){
            this.row = row;
            this.col = col;
            this.dir = dir;
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        command = br.readLine().toCharArray();

        map = new char[N][N];
        flash = new boolean[N][N];
        isZombie = new boolean[N][N];
        isTurnOn = new boolean[N][N];

        for(int i = 0; i < N; i++){
            map[i] = br.readLine().toCharArray();
            for(int j = 0; j < N; j++){
                if(map[i][j] == 'S'){
                    flash[i][j] = true;
                } else if(map[i][j] == 'Z'){
                    zombies.add(new Pos(i, j, 2));
                    isZombie[i][j] = true;
                }
            }
        }
    }

    static void solve() {
        boolean isEnd = false;
        // 시작은 아래 방향
        direction = 2;

        for(char cmd : command){
            moveAhri(cmd);

            int row = ahri.row;
            int col = ahri.col;

            // 형광등 켜기
            if(map[row][col] == 'S' && !isTurnOn[row][col]){
                turnOnFlash();
            }

            if(isZombie[row][col] && !flash[row][col]){
                isEnd = true;
                break;
            }

            moveZombie();

            if(isZombie[row][col] && !flash[row][col]){
                isEnd = true;
                break;
            }
        }

        if(!isEnd) System.out.print("Phew...");
        else System.out.print("Aaaaaah!");
    }

    static void moveAhri(char cmd){
        if(cmd == 'F'){
            int nr = ahri.row + dr[direction];
            int nc = ahri.col + dc[direction];

            // 전진 가능한 경우
            if (nr >= 0 && nr < N && nc >= 0 && nc < N){
                ahri.row = nr;
                ahri.col = nc;
            }
        } else if(cmd == 'R'){
            direction = (direction + 1) % 4;
        } else {
            direction = (direction + 3) % 4;
        }
    }

    static void turnOnFlash(){
        int row = ahri.row;
        int col = ahri.col;

        isTurnOn[row][col] = true;

        for(int d = 0; d < 8; d++){
            int nr = row + dr[d];
            int nc = col + dc[d];

            if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;

            flash[nr][nc] = true;
        }
    }

    static void moveZombie(){
        boolean[][] zombieCopy = new boolean[N][N];

        for(Pos zombie : zombies){
            int row = zombie.row + dr[zombie.dir];
            int col = zombie.col + dc[zombie.dir];

            if(row < 0 || row >= N || col < 0 || col >= N){
                zombie.dir = (zombie.dir + 2) % 4;
            } else {
                zombieCopy[row][col] = true;

                zombie.row = row;
                zombie.col = col;
            }
        }

        for(int i = 0; i < N; i++){
            isZombie[i] = Arrays.copyOf(zombieCopy[i], N);
        }
    }
}
