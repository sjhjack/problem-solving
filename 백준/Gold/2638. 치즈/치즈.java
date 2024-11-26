/**
 * 메모리 : 15864 KB
 * 시간 : 180 ms
 * 
 * # 접근 1 : 외부 공기 찾기 + 치즈 녹이기 -> BFS로 한번에 처리
 *           
 *           1. 외부 공기 탐색, 치즈 녹이기를 BFS로 처리할 수 있었지만,
 *              걸리는 시간(time)을 체크하는 것에서 어려움을 겪음
 *           -> Failed
 *           
 * # 접근 2 : 외부 공기 찾기 / 치즈 녹이기 -> 분리해서 실행
 * 
 *           1. 시간 체크하는게 매우 쉬워짐.
 *           2. BFS로 외부 공기를 모두 탐색하며 1시간 뒤 녹을 치즈를 찾아 따로 큐에 넣어서 관리
 *           3. 치즈가 녹으면 공기가 되므로 BFS 실행할 큐에 추가
 *           4. 2~3번 과정을 치즈가 모두 녹을때까지 반복
 *           -> Solved !!
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int cheeseCnt, cnt;								// 총 치즈 격자 수, 녹인 치즈 격자 수
	static int[][] arr;										// 격자 상태 저장
	static boolean[][] isVisited;							// 탐색 여부
	static boolean[][] isAdded;								// qCheese에 중복해서 담지 않기 위해 만듬
	static int[] dr = {-1,1,0,0};							// 상하좌우
	static int[] dc = {0,0,-1,1};
	static Queue<Point> qZero = new ArrayDeque<>();			// 공기 다루는 큐
	static Queue<Point> qCheese = new ArrayDeque<>();		// 1시간뒤 녹을 치즈 담는 큐
	
	/* 좌표 담는 클래스 */
	static class Point{
		int row;
		int col;
		
		public Point(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
	
	/* 입력 */
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		isVisited = new boolean[N][M];
		isAdded = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				cheeseCnt += arr[i][j];								// 총 치즈 격자 수 저장
			}
		}
	}
	
	/**
	 * 외부 공기 탐색
	 * 
	 * 처음 호출 시 : 초기 상태의 외부 공기 모두 탐색하며 1시간 뒤 녹을 치즈를 qCheese에 추가한다.
	 * 이후 호출 시 : 치즈가 녹으며 생긴 외부 공기를 모두 탐색하며 1시간 뒤 녹을 치즈를 qCheese에 추가한다.
	 */
	static void findOutside() {
		while(!qZero.isEmpty()) {									// 모든 외부 공기 탐색
			Point cur = qZero.poll();
			
			if(!isVisited[cur.row][cur.col]) {
				isVisited[cur.row][cur.col] = true;
				
				for(int d = 0; d < 4; d++) {
					int nr = cur.row + dr[d];
					int nc = cur.col + dc[d];
					
					if(nr<0 || nr>=N || nc<0 || nc>=M) continue;
					
					if(arr[nr][nc] > 0) {							// 치즈인 경우
						arr[nr][nc]++;								// 치즈가 접촉한 외부 공기 수
						if(arr[nr][nc] >= 3 && !isAdded[nr][nc]) {	// 1시간 뒤 녹을 치즈인 경우
							qCheese.add(new Point(nr, nc));
							isAdded[nr][nc] = true;					// qCheese에 중복해서 들어가지 않게 처리
						}
					} else {										// 외부 공기 탐색
						qZero.add(new Point(nr, nc));
					}
				}
			}
		}
	}
	
	/* 치즈 녹이기 */
	static void melting() {
		while(!qCheese.isEmpty()) {
			Point cur = qCheese.poll();
			
			cnt++;													// 지금까지 녹은 치즈 격자 수 카운트
			arr[cur.row][cur.col] = 0;								// 치즈 녹은 자리는 외부 공기가 된다
			
			qZero.add(new Point(cur.row, cur.col));					// 다음에 탐색할 외부 공기로 추가하기
		}
	}
	
	public static void main(String[] args) throws IOException {
		input();
		
		qZero.add(new Point(0, 0));
		int time = 0;
		
		while(cnt != cheeseCnt) {
			time++;
			findOutside();
			melting();
		}
		
		System.out.print(time);
	}

}
