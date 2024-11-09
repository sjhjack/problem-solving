import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static final int UP = 0;
	static final int DOWN = 1;
	static final int LEFT = 2;
	static final int RIGHT = 3;
	
	static int N, M;
	static int islandCnt;
	static int ans;
	
	static int[][] arr;
	static int[][] dist;
	static boolean[] islandVisited;
	static int[] dr = {-1,1,0,0};	// 상하좌우
	static int[] dc = {0,0,-1,1};
	
	static class Pos{
		int row;
		int col;
		
		public Pos(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
	
	static class Edge implements Comparable<Edge> {
		int vertex;
		int cost;
		
		public Edge(int vertex, int cost) {
			this.vertex = vertex;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return this.cost - o.cost;
		}
	}
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
	
	static void findIsland() {
		boolean[][] isVisited = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(isVisited[i][j]) continue;
				
				if(arr[i][j] > 0) {
					islandCnt++;
					Queue<Pos> q = new ArrayDeque<>();
					
					q.add(new Pos(i, j));
					isVisited[i][j] = true;
					arr[i][j] = islandCnt;
					
					while(!q.isEmpty()) {
						Pos cur = q.poll();
						
						for(int d = 0; d < 4; d++) {
							int nr = cur.row + dr[d];
							int nc = cur.col + dc[d];
							
							if(nr<0 || nr>=N || nc<0 || nc>=M || isVisited[nr][nc] || arr[nr][nc]==0) continue;
							
							q.add(new Pos(nr, nc));
							isVisited[nr][nc] = true;
							arr[nr][nc] = islandCnt;
						}
					}
				}
			}
		}
		
		dist = new int[islandCnt + 1][islandCnt + 1];
		islandVisited = new boolean[islandCnt + 1];
	}
	
	static void findBridge() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(arr[i][j] == 0) {
					if(j-1 >= 0 && arr[i][j-1] != 0) makeBridge(i, j, RIGHT, arr[i][j-1]);
					if(j+1 < M && arr[i][j+1] != 0) makeBridge(i, j, LEFT, arr[i][j+1]);
					if(i-1 >= 0 && arr[i-1][j] != 0) makeBridge(i, j, DOWN, arr[i-1][j]);
					if(i+1 < N && arr[i+1][j] != 0) makeBridge(i, j, UP, arr[i+1][j]);
				}
			}
		}
	}
	
	static void makeBridge(int r, int c, int dir, int from) {
		int nr = r;
		int nc = c;
		int to, len;
		
		while(arr[nr][nc] == 0) {
			nr += dr[dir];
			nc += dc[dir];
			
			if(nr<0 || nr>=N || nc<0 || nc>=M) return;
		}
		
		to = arr[nr][nc];
		len = Math.abs(nr - r) + Math.abs(nc - c);
		
		if(len == 1) return;
		if(dist[from][to] == 0 || dist[from][to] > len) {
			dist[from][to] = len;
			dist[to][from] = len;
		}
		
		return;
	}
	
	static boolean prim() {
		boolean[] pqVisited = new boolean[islandCnt + 1];
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		int cnt = 0;
		
		pq.add(new Edge(1, 0));
		
		while(!pq.isEmpty()) {
			Edge cur = pq.poll();
			
			if(pqVisited[cur.vertex]) continue;
			
			pqVisited[cur.vertex] = true;
			ans += cur.cost;
			cnt++;
			
			for(int i = 1; i <= islandCnt; i++) {
				if(dist[cur.vertex][i] != 0) {
					pq.add(new Edge(i, dist[cur.vertex][i]));
				}
			}
		}
		
		if(cnt == islandCnt) return true;
		else return false;
	}
	
	public static void main(String[] args) throws IOException {
		input();
		findIsland();
		findBridge();
		if(prim()) System.out.print(ans);
		else System.out.print(-1);
	}

}
