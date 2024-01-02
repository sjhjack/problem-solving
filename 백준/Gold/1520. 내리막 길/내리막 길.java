import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int R, C, ans;
	
	static int[][] arr;
	static int[][] dp;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	static class Pos implements Comparable<Pos>{
		int row;
		int col;
		int height;
		
		public Pos(int row, int col, int height) {
			this.row = row;
			this.col = col;
			this.height = height;
		}
		
		@Override
		public int compareTo(Pos o) {
			return o.height - height;
		}
	}
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		arr = new int[R][C];
		dp = new int[R][C];
		
		for(int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < C; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		if(R == 1 && C == 1) ans = 1;
	}
	
	static void solve() {
		boolean[][] isVisited = new boolean[R][C];
//		Queue<Pos> q = new ArrayDeque<>();
		PriorityQueue<Pos> pq = new PriorityQueue<>();
		
		dp[0][0] = 1;
		pq.add(new Pos(0, 0, arr[0][0]));
		isVisited[0][0] = true;
		
		while(!pq.isEmpty()) {
			Pos cur = pq.poll();
			
			for(int d = 0; d < 4; d++) {
				int nr = cur.row + dr[d];
				int nc = cur.col + dc[d];
				
				if(nr<0 || nr>=R || nc<0 || nc>=C) continue;
				if(arr[cur.row][cur.col] <= arr[nr][nc]) continue;
//				if(nr == R-1 && nc == C-1) {
//					ans++;
//					continue;
//				}
				
				if(!isVisited[nr][nc]) {
					pq.add(new Pos(nr, nc, arr[nr][nc]));
					isVisited[nr][nc] = true;
				}
				
				dp[nr][nc] += dp[cur.row][cur.col];
				
				
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		input();
		solve();
		System.out.print(dp[R-1][C-1]);
//		System.out.print(ans);
	}

}
