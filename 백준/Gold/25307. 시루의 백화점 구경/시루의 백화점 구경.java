import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final int[] dr = {-1, 1, 0, 0};     // 상하좌우
	private static final int[] dc = {0, 0, -1, 1};
	private static int N, M, K, ans;
	private static int[][] arr;
	private static boolean[][] mannequinAreas;
	private static Pos start, end;
	private static Queue<Pos> mannequins = new ArrayDeque<>();

	private static class Pos {
		int row;
		int col;
		int count;

		public Pos(int row, int col, int count) {
			this.row = row;
			this.col = col;
			this.count = count;
		}
	}

	public static void main(String[] args) throws IOException {
		input();
		solve();
		System.out.print(ans);
	}

	private static void input() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		arr = new int[N][M];
		mannequinAreas = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());

				if (arr[i][j] == 2) {
					end = new Pos(i, j, 0);
				} else if (arr[i][j] == 4) {
					start = new Pos(i, j, 0);
				} else if (arr[i][j] == 3) {
					mannequins.add(new Pos(i, j, 0));
					mannequinAreas[i][j] = true;
				}
			}
		}
	}

	private static void solve() {
		Queue<Pos> queue = new ArrayDeque<>();
		boolean[][] isVisited = new boolean[N][M];
		ans = -1;
		boolean isFound = false;

		if (end == null)
			return;

		setMannequinAreas();

		queue.add(start);
		isVisited[start.row][start.col] = true;

		while (!queue.isEmpty()) {
			Pos cur = queue.poll();

			for (int d = 0; d < 4; d++) {
				int nr = cur.row + dr[d];
				int nc = cur.col + dc[d];

				if (nr < 0 || nr >= N || nc < 0 || nc >= M || arr[nr][nc] == 1 || isVisited[nr][nc])
					continue;
				// 마네킹 거리 체크
				if (mannequinAreas[nr][nc]) {
					continue;
				}

				if (arr[nr][nc] == 2) {
					ans = cur.count + 1;
					isFound = true;
					break;
				}

				queue.add(new Pos(nr, nc, cur.count + 1));
				isVisited[nr][nc] = true;
			}

			if (isFound)
				break;
		}
	}

	private static void setMannequinAreas(){
		while(!mannequins.isEmpty()){
			Pos cur = mannequins.poll();

			for(int d = 0; d < 4; d++){
				int nr = cur.row + dr[d];
				int nc = cur.col + dc[d];

				if(nr < 0 || nr >= N || nc < 0 || nc >= M || mannequinAreas[nr][nc] || cur.count + 1 > K) continue;

				mannequinAreas[nr][nc] = true;
				mannequins.add(new Pos(nr, nc, cur.count + 1));
			}
		}
	}
}
