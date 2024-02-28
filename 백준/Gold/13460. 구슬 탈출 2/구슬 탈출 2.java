import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final int[] dr = {-1,1,0,0};     // 상하좌우
	private static final int[] dc = {0,0,-1,1};
	private static int N;
	private static int M;
	private static PriorityQueue<Board> queue = new PriorityQueue<>();
	private static Map<String, Integer> map = new HashMap<>();


	private static class Board implements Comparable<Board> {
		char[][] board;
		Pos red;
		Pos blue;
		int count;

		public Board(char[][] board, Pos red, Pos blue, int count){
			this.board = board;
			this.red = red;
			this.blue = blue;
			this.count = count;
		}

		@Override
		public int compareTo(Board b){
			return count - b.count;
		}
	}

	private static class Pos {
		int row;
		int col;

		public Pos(int row, int col){
			this.row = row;
			this.col = col;
		}
	}

	public static void main(String[] args) throws IOException {
		input();
		solve();
	}

	private static void input() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		char[][] arr = new char[N][M];

		Pos red = null;
		Pos blue = null;

		for(int i = 0; i < N; i++){
			arr[i] = br.readLine().toCharArray();
			for(int j = 0; j < M; j++){
				if(arr[i][j] == 'R'){
					red = new Pos(i, j);
				}else if(arr[i][j] == 'B'){
					blue = new Pos(i, j);
				}
			}
		}

		queue.add(new Board(arr, red, blue, 0));
		map.put(toString(arr), 0);
	}

	private static void solve() {
		int ans = -1;

		while(!queue.isEmpty()){
			Board cur = queue.poll();
			Pos red = cur.red;
			Pos blue = cur.blue;

			for(int d = 0; d < 4; d++){
				boolean isBlocked = false;
				boolean isHoleRed = false;
				boolean isHoleBlue = false;
				Pos nRed = null;
				Pos nBlue = null;
				int nr = red.row + dr[d];
				int nc = red.col + dc[d];
				char[][] nBoard = new char[N][M];

				// 딥카피
				for(int i = 0; i < N; i++){
					nBoard[i] = Arrays.copyOf(cur.board[i], M);
				}

				// 빨간공 먼저 굴리기
				while(nBoard[nr][nc] != '#'){
					// 중간에 구멍 만난 경우
					if(nBoard[nr][nc] == 'O'){
						isHoleRed = true;
						nBoard[red.row][red.col] = '.';
						break;
					}

					// 중간에 파란공 만난 경우
					if(nr == blue.row && nc == blue.col){
						isBlocked = true;
						nRed = new Pos(nr - dr[d], nc - dc[d]);
						break;
					}

					nr += dr[d];
					nc += dc[d];
				}

				if(!isHoleRed){
					// 벽까지 도달한 경우
					if(nRed == null){
						nRed = new Pos(nr - dr[d], nc - dc[d]);
					}

					nBoard[red.row][red.col] = '.';
					nBoard[nRed.row][nRed.col] = 'R';
				}

				// 파란공 굴리기
				nr = blue.row + dr[d];
				nc = blue.col + dc[d];

				while(nBoard[nr][nc] != '#' && nBoard[nr][nc] != 'R'){
					// 중간에 구멍 만난 경우
					if(nBoard[nr][nc] == 'O'){
						isHoleBlue = true;
						break;
					}

					nr += dr[d];
					nc += dc[d];
				}

				// 파란공 빠지면 끝
				if(isHoleBlue) continue;
				// 빨간공만 빠지면 성공
				if(isHoleRed) {
					ans = cur.count + 1 <= 10 ? cur.count + 1 : -1;
					break;
				}

				nr = nr - dr[d];
				nc = nc - dc[d];
				nBlue = new Pos(nr, nc);

				// 파란공 옮긴 위치 저장
				nBoard[blue.row][blue.col] = '.';
				nBoard[nr][nc] = 'B';

				// 구멍에 안 빠졌고, 빨간공 추가로 움직이는 경우
				if(isBlocked){
					nr = nRed.row;
					nc = nRed.col;

					while(nBoard[nr][nc] != '#' && nBoard[nr][nc] != 'B'){
						nr += dr[d];
						nc += dc[d];
					}

					nBoard[nRed.row][nRed.col] = '.';
					nRed = new Pos(nr - dr[d], nc - dc[d]);
					nBoard[nRed.row][nRed.col] = 'R';
				}

				if(cur.count + 1 > 10) continue;

				String nextMap = toString(nBoard);

				// 큐에 추가
				if(map.containsKey(nextMap)){
					if(map.get(nextMap) > cur.count + 1){
						map.put(nextMap, cur.count + 1);
						queue.add(new Board(nBoard, nRed, nBlue, cur.count + 1));
					}
				} else {
					map.put(nextMap, cur.count + 1);
					queue.add(new Board(nBoard, nRed, nBlue, cur.count + 1));
				}
			}

			if(ans >= 0) {
				break;
			}
		}

		System.out.print(ans);
	}

	private static String toString(char[][] chars){
		StringBuilder string = new StringBuilder();

		for(int i = 0; i < N; i++){
			for(int j = 0; j < M; j++){
				string.append(chars[i][j]);
			}
		}

		return new String(string);
	}
}
