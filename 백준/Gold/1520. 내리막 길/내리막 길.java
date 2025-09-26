/**
 *  [문제] https://www.acmicpc.net/problem/1520
 *  
 *  메모리 : 36968 KB
 *  시간 : 428 ms
 *  
 *  # 접근1 : BFS
 *  		- 단순히 BFS만 사용하면 중복되는 길 때문에 visit 처리를 못한다
 *  		- visit처리가 없는 BFS는 지수개의 메모리가 필요하므로 불가능
 *  
 *  		-> Failed,, 메모리 초과
 *  
 *  # 접근2 : BFS + PQ
 *  		- 우선순위큐를 사용해서 높은 지점에 탐색 우선순위를 뒀다.
 *  		- 경로가 겹치는 이유는 해당 위치보다 높은 지점이 주변에 여러개 있다는 뜻이다.
 *  		- 따라서 높이가 높은 지점부터 탐색을 하도록 하면 각 좌표를 한번씩만 탐색할 수 있다.
 *  
 *  		-> Solved !!
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int R, C;
	
	static int[][] arr;				// 원본 배열
	static int[][] dp;				// 각 좌표에 도달하는 경우의 수 저장
	static int[] dr = {-1,1,0,0};	// 상하좌우
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
		
		// 높이 내림차순 정렬
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
	}
	
	static void solve() {
		boolean[][] isVisited = new boolean[R][C];
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
	}
}
