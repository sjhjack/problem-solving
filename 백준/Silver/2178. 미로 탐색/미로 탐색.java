import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static final int[] dr = {-1,1,0,0};
	private static final int[] dc = {0,0,-1,1};
	private static int N;
	private static int M;
	private static int[][] map;

	private static class Pos {
		int row;
		int col;
		int cnt;

		public Pos(int row, int col, int cnt) {
			this.row = row;
			this.col = col;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws IOException {
		input();
		solve();
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		for(int i = 0; i < N; i++) {
			char[] tmp = br.readLine().toCharArray();
			for(int j = 0; j < M; j++) {
				map[i][j] = tmp[j] - '0';
			}
		}
	}

	private static void solve() {
		boolean[][] isVisited = new boolean[N][M];
		Queue<Pos> q = new ArrayDeque<>();

		q.add(new Pos(0, 0, 1));
		isVisited[0][0] = true;

		while(!q.isEmpty()) {
			Pos cur = q.poll();

			for(int d = 0; d < 4; d++) {
				int nr = cur.row + dr[d];
				int nc = cur.col + dc[d];

				if(nr < 0 || nr >= N || nc < 0 || nc >= M || isVisited[nr][nc] || map[nr][nc] == 0) continue;
				if(nr == N-1 && nc == M-1) {
					System.out.print(cur.cnt + 1);
					return;
				}

				q.add(new Pos(nr, nc, cur.cnt + 1));
                isVisited[nr][nc] = true;
			}
		}
	}
}
