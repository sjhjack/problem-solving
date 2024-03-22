import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static final int[] dr = {-1,1,0,0};
	static final int[] dc = {0,0,-1,1};

	static int N, M;
	static Pos[] posA = new Pos[2];
	static Pos[] posB = new Pos[2];
	static boolean[][] isVisited;
	static Pos[][] dir;

	static class Pos {
		int row;
		int col;
		int len;

		public Pos(int row, int col, int len){
			this.row = row;
			this.col = col;
			this.len = len;
		}
	}

	public static void main(String[] args) throws IOException {
		input();
		solve();
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		for(int i = 0; i < 2; i++){
			st = new StringTokenizer(br.readLine());
			int row = Integer.parseInt(st.nextToken());
			int col = Integer.parseInt(st.nextToken());

			posA[i] = new Pos(row, col, 0);
		}

		for(int i = 0; i < 2; i++){
			st = new StringTokenizer(br.readLine());
			int row = Integer.parseInt(st.nextToken());
			int col = Integer.parseInt(st.nextToken());

			posB[i] = new Pos(row, col, 0);
		}
	}

	static void solve(){
		isVisited = new boolean[N + 1][M + 1];
		dir = new Pos[N + 1][M + 1];
		int ans = Integer.MAX_VALUE;

		// A -> B
		isVisited[posB[0].row][posB[0].col] = true;
		isVisited[posB[1].row][posB[1].col] = true;
		int len = -1;
		int len2 = -1;

		len = BFS(posA[0], posA[1]);
		if(len >= 0){
			len2 = BFS(posB[0], posB[1]);

			if(len2 >= 0){
				ans = Math.min(ans, len + len2);
			}
		}


		// B -> A
		isVisited = new boolean[N + 1][M + 1];
		dir = new Pos[N + 1][M + 1];

		isVisited[posA[0].row][posA[0].col] = true;
		isVisited[posA[1].row][posA[1].col] = true;
		len = -1;
		len2 = -1;

		len = BFS(posB[0], posB[1]);
		if(len >= 0){
			len2 = BFS(posA[0], posA[1]);

			if(len2 >= 0){
				ans = Math.min(ans, len + len2);
			}
		}

		if(ans == Integer.MAX_VALUE) System.out.println("IMPOSSIBLE");
		else System.out.print(ans);
	}

	static int BFS(Pos start, Pos end){
		Queue<Pos> queue = new ArrayDeque<>();

		queue.add(start);
		isVisited[start.row][start.col] = true;

		while(!queue.isEmpty()){
			Pos cur = queue.poll();

			for(int d = 0; d < 4; d++){
				int nr = cur.row + dr[d];
				int nc = cur.col + dc[d];

				if(nr < 0 || nr > N || nc < 0 || nc > M || isVisited[nr][nc]) continue;

				if(nr == end.row && nc == end.col){
					isVisited = new boolean[N + 1][M + 1];

					isVisited[nr][nc] = true;
					dir[nr][nc] = cur;

					while(true){
						Pos trace = dir[nr][nc];
						isVisited[trace.row][trace.col] = true;

						if(trace.row == start.row && trace.col == start.col) break;

						nr = trace.row;
						nc = trace.col;
					}

					return cur.len + 1;
				} else {
					isVisited[nr][nc] = true;
					dir[nr][nc] = cur;
					queue.add(new Pos(nr, nc, cur.len + 1));
				}
			}
		}

		return -1;
	}
}
