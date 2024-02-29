/*
path[i][j] = cnt % 10; 에서 0이 저장될 수 있기 때문에
원본 배열을 바꾸면 안된다.
기존에 1인 위치에 0이 저장되는 순간, 그룹이 지정되어있지 않기 때문에 group[nr][nc] == 0 이고,
그룹이 1부터 시작하기 때문에 0번째 그룹에 포함된 칸의 개수가 CntOfEachGroup에 저장되어 있지 않다.
따라서 CntOfEachGroup.get(group[nr][nc]) == null 이라서 
cnt += CntOfEachGroup.get(group[nr][nc]); 는 cnt += null 로 인해 NullPointerError가 발생한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	static int R, C;
	static int groupCnt;
	
	static int[][] map;
	static int[][] group;
	static int[][] path;
	static int[] dr = {-1,1,0,0};	// 상하좌우
	static int[] dc = {0,0,-1,1};
	
	static Map<Integer, Integer> CntOfEachGroup = new HashMap<>();
	
	static class Pos {
		int row;
		int col;
		
		public Pos(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		group = new int[R][C];
		path = new int[R][C];
		
		for(int i = 0; i < R; i++) {
			char[] tmp = br.readLine().toCharArray();
			for(int j = 0; j < C; j++) {
				map[i][j] = tmp[j] - '0';
			}
		}
	}
	
	static void solve() {
		makeGroups();	// 인접한 0을 한 그룹으로 묶기
		findPath();		// 1을 0으로 바꿨을 때 이동범위 구하기
	}
	
	static void makeGroups() {
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(map[i][j] == 0 && group[i][j] == 0) {
					BFS(i, j);
				}
			}
		}
	}
	
	static void BFS(int r, int c) {
		Queue<Pos> q = new ArrayDeque<>();
		int cnt = 1;
		
		group[r][c] = ++groupCnt;
		q.add(new Pos(r, c));
		
		while(!q.isEmpty()) {
			Pos cur = q.poll();
			
			for(int d = 0; d < 4; d++) {
				int nr = cur.row + dr[d];
				int nc = cur.col + dc[d];
				
				if(isInvalid(nr, nc) || group[nr][nc]>0) continue;
				
				cnt++;
				group[nr][nc] = groupCnt;
				q.add(new Pos(nr, nc));
			}
		}
		
		CntOfEachGroup.put(groupCnt, cnt);
	}
	
	static boolean isInvalid(int nr, int nc) {
		return nr<0 || nr>=R || nc<0 || nc>=C || map[nr][nc]>0;
	}
	
	static void findPath() {
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(map[i][j] == 1) {
					int cnt = 1;
					Set<Integer> set = new HashSet<>();
					
					for(int d = 0; d < 4; d++) {
						int nr = i + dr[d];
						int nc = j + dc[d];
						
						if(isInvalid(nr, nc) || set.contains(group[nr][nc])) continue;
						
						cnt += CntOfEachGroup.get(group[nr][nc]);
						set.add(group[nr][nc]);
					}
					
					path[i][j] = cnt % 10;	// 0~9의 값이 저장됨 -> 0 저장에 유의 !!
				}
			}
		}
	}
	
	static void print() {
		StringBuilder ans = new StringBuilder();
		
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				ans.append(path[i][j]);
			}
			ans.append("\n");
		}
		
		System.out.print(ans);
	}
	
	public static void main(String[] args) throws IOException {
		input();
		solve();
		print();
	}	
}
