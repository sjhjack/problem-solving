import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static char[][] arr;
	static int[][][] path;
	static int[] dr = {-1,1,0,0};	// 상하좌우
	static int[] dc = {0,0,-1,1};
	
	static class Pos {
		int row;
		int col;
		int len;
		boolean isBreak;
		
		public Pos(int row, int col, int len, boolean isBreak) {
			this.row = row;
			this.col = col;
			this.len = len;
			this.isBreak = isBreak;
		}
	}
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new char[N][M];
		path = new int[N][M][2];	// [][][0] : 벽 안부숨 , [][][1] : 벽 부숨
		
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			for(int j = 0; j < M; j++) {
				arr[i][j] = s.charAt(j);
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				Arrays.fill(path[i][j], Integer.MAX_VALUE);
			}
		}
	}
	
	static void BFS() {
		Queue<Pos> q = new ArrayDeque<>();
		
		q.add(new Pos(0, 0, 1, false));
		path[0][0][0] = 1;
		
		while(!q.isEmpty()) {
			Pos cur = q.poll();
			
			for(int d = 0; d < 4; d++) {
				int nr = cur.row + dr[d];
				int nc = cur.col + dc[d];
				
				if(nr<0 || nr>=N || nc<0 || nc>=M) continue;
				if(arr[nr][nc]=='1' && cur.isBreak) continue;
				
				if(cur.isBreak) {
					if(path[nr][nc][0] > cur.len + 1 && path[nr][nc][1] > cur.len + 1) {
						path[nr][nc][1] = cur.len + 1;
					} else {
						continue;
					}
				} else {
					if(path[nr][nc][0] > cur.len + 1) {
						path[nr][nc][0] = cur.len + 1;
					}else {
						continue;
					}
				}
				
				if(arr[nr][nc] == '1') {
					q.add(new Pos(nr, nc, cur.len+1, true));	
				} else {
					q.add(new Pos(nr, nc, cur.len+1, cur.isBreak));
				}
			}
		}
		
		int min = Math.min(path[N-1][M-1][0], path[N-1][M-1][1]);
		if(min != Integer.MAX_VALUE) {
			System.out.print(min);
		}
		else {
			System.out.print(-1);
		}
	}

	public static void main(String[] args) throws IOException {
		input();
		BFS();		
	}
}
