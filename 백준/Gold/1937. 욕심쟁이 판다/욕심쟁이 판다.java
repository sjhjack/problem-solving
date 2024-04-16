import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static final int[] dr = {-1,1,0,0};		// 상하좌우
	static final int[] dc = {0,0,-1,1};

	static int N;
	static int[][] arr;
	static int[][] dist;
	static PriorityQueue<Pos> pq = new PriorityQueue<>();

	static class Pos implements Comparable<Pos> {
		int row;
		int col;
		int bamboo;

		public Pos(int row, int col){
			this(row, col, 0);
		}

		public Pos(int row, int col, int bamboo){
			this.row = row;
			this.col = col;
			this.bamboo = bamboo;
		}

		@Override
		public int compareTo(Pos o) {
			return this.bamboo - o.bamboo;
		}
	}

	public static void main(String[] args) throws IOException {
		input();
		solve();
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		dist = new int[N][N];

		for(int i = 0; i < N; i++){
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++){
				arr[i][j] = Integer.parseInt(st.nextToken());
				pq.add(new Pos(i, j, arr[i][j]));
			}
		}
	}
	
	static void solve(){
		int ans = 1;

		while(!pq.isEmpty()){
			Pos cur = pq.poll();
			int row = cur.row;
			int col = cur.col;

			if(dist[row][col] == 0){
				dist[row][col] = 1;
			}

			for(int d = 0; d < 4; d++){
				int nr = cur.row + dr[d];
				int nc = cur.col + dc[d];

				if(nr < 0 || nr >= N || nc < 0 || nc >= N || arr[cur.row][cur.col] >= arr[nr][nc] || dist[cur.row][cur.col] + 1 <= dist[nr][nc]) continue;

				dist[nr][nc] = dist[cur.row][cur.col] + 1;
				ans = Math.max(ans, dist[nr][nc]);
				pq.add(new Pos(nr, nc, arr[nr][nc]));
			}
		}

		System.out.print(ans);
	}
}
