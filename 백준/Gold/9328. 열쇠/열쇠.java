import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static final int[] dr = {-1,1,0,0};		// 상하좌우
	static final int[] dc = {0,0,-1,1};

	static StringBuilder ans = new StringBuilder();
	static int H, W;
	static int totalDocCount, key, count;
	static char[][] map;
	static boolean[][] isVisited;
	static List<Pos> startList = new ArrayList<>();
	static List<Pos> startDoorList = new ArrayList<>();
	static Queue<Pos> queue = new ArrayDeque<>();

	static class Pos {
		int row;
		int col;

		public Pos(int row, int col){
			this.row = row;
			this.col = col;
		}
	}

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());

		for(int t = 0; t < T; t++){
			input();
			solve();
		}

		System.out.print(ans);
	}

	static void input() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());

		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());

		init();

		for(int i = 0; i < H; i++){
			map[i] = br.readLine().toCharArray();
			for(int j = 0; j < W; j++){
				if(map[i][j] == '$'){
					totalDocCount++;
				}

				// 가장자리 시작점, 문, 열쇠, 서류 탐색 및 저장
				if(i == 0 || i == H-1 || j == 0 || j == W-1){
					if(map[i][j] == '$'){
						count++;
						map[i][j] = '.';
						startList.add(new Pos(i, j));
					} else if(map[i][j] == '.'){
						startList.add(new Pos(i, j));
					} else if('a' <= map[i][j] && map[i][j] <= 'z'){
						key = key | (1 << (map[i][j] - 'a'));
						map[i][j] = '.';
						startList.add(new Pos(i, j));
					} else if('A' <= map[i][j] && map[i][j] <= 'Z'){
						startDoorList.add(new Pos(i, j));
					}
				}
			}
		}

		char[] alphas = br.readLine().toCharArray();

		if(alphas[0] == '0') return;

		for(char alpha : alphas){
			key = key | (1 << (alpha - 'a'));
		}
	}

	static void init(){
		map = new char[H][W];
		isVisited = new boolean[H][W];

		startList.clear();
		startDoorList.clear();
		queue.clear();

		totalDocCount = 0;
		key = 0;
		count = 0;
	}

	static void solve() {
		startAgain();

		while(!queue.isEmpty() && count < totalDocCount){
			Pos cur = queue.poll();

			for(int d = 0; d < 4; d++){
				int nr = cur.row + dr[d];
				int nc = cur.col + dc[d];

				if(nr < 0 || nr >= H || nc < 0 || nc >= W || isVisited[nr][nc] || map[nr][nc] == '*') continue;

				char now = map[nr][nc];

				if(now == '$'){
					count++;
					map[nr][nc] = '.';
				} else if('a' <= now && now <= 'z'){
					key = key | (1 << (now - 'a'));
					map[nr][nc] = '.';

					isVisited = new boolean[H][W];
					queue.clear();

					startAgain();
					continue;
				} else if('A' <= now && now <= 'Z'){
					if((key & (1 << (now - 'A'))) == 0){
						continue;
					}
				}

				queue.add(new Pos(nr, nc));
				isVisited[nr][nc] = true;
			}
		}

		ans.append(count).append("\n");
	}

	static void startAgain(){
		// 가장자리 '.'
		for(Pos start : startList){
			queue.add(start);
			isVisited[start.row][start.col] = true;
		}

		// 가장자리 문
		for(Pos startDoor : startDoorList){
			char door = map[startDoor.row][startDoor.col];
			if((key & (1 << (door - 'A'))) > 0) {
				queue.add(startDoor);
				isVisited[startDoor.row][startDoor.col] = true;
			}
		}
	}
}
