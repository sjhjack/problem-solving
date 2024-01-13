/**
 * [문제] https://www.acmicpc.net/problem/28354
 * 
 * 메모리 : 203396 KB
 * 시간 : 1572 ms
 * 
 * # 시간 초과 10% : link를 ArrayList -> HashSet으로 변경 (중복 체크 O(1))
 * # 시간 초과 63% : 링크 변경으로 인해 다음날 익게되는 토마토를 다룰 때,
 *                 1. 오늘 익어있는 토마토를 통해서 익게 만듬 -> 시간 초과
 *                 2. 내일 익게되는 토마토를 다음날 수행 -> 통과
 *                 
 *                 1번은 오늘 익어있는 토마토 -> 내일 익을 토마토 : 2번의 수행 필요
 *                 2번은 내일 익을 토마토 : 1번의 수행 필요
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

class Main {

	static int N, M, K, Q;
	static int ripeCnt;
	
	static int[] ans;
	static HashSet<Integer>[] link;
	static boolean[] isRipe;
	
	static Queue<Integer> q = new ArrayDeque<>();
	static Queue<Pair> qTime = new ArrayDeque<>();
	
	static class Pair{
		int t;
		int a;
		int b;
		
		public Pair(int t, int a, int b) {
			this.t = t;
			this.a = a;
			this.b = b;
		}
	}
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		
		ans = new int[N + 1];
		link = new HashSet[N + 1];
		isRipe = new boolean[N + 1];
		
		for(int i = 1; i <= N; i++) link[i] = new HashSet<>();
		
		// 0일에 연결되어 있는 토마토 쌍
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			link[a].add(b);
			link[b].add(a);
		}
		
		// 0일에 익어있는 토마토
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < K; i++) {
			int ripe = Integer.parseInt(st.nextToken());
			
			if(!link[ripe].isEmpty()) q.add(ripe);
			isRipe[ripe] = true;
			ans[ripe] = 0;
			ripeCnt++;
		}
		
		// 쿼리
		for(int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			qTime.add(new Pair(t, a, b));
		}
	}
	
	static void solve() {
		int time = 0;
		boolean[] isAdded = new boolean[N + 1];
		Queue<Integer> nextRipe = new ArrayDeque<>();
		
		while(!q.isEmpty() || !qTime.isEmpty()) {
			if(ripeCnt == N) break;

			int size = q.size();
			// 오늘 링크 바뀌어서 다음 날 익게 될 토마토 추가
			while(!qTime.isEmpty() && time == qTime.peek().t) {
				Pair tmp = qTime.poll();
				
				int a = tmp.a;
				int b = tmp.b;
				
				// 익어있는 토마토는 더 이상 탐색할 필요가 없다.
				if(isRipe[a] && isRipe[b]) continue;
				
				boolean linkFlag = changeLink(a, b);
				
				// 안 익은 토마토를 내일 익을 토마토 목록에 추가
				if(linkFlag) {
					if(isRipe[a] && !isRipe[b] && !isAdded[b]) {
						q.add(b);
						isAdded[b] = true;
						nextRipe.add(b);
					} else if(isRipe[b] && !isRipe[a] && !isAdded[a]) {
						q.add(a);
						isAdded[a] = true;
						nextRipe.add(a);
					}
				}
			}
			
			// 오늘 익어있는 토마토와 연결 되어 있어서 내일 익게 될 토마토 추가
			for(int i = 0; i < size; i++) {
				int cur = q.poll();
				
				for(int num : link[cur]) {
					if(!isRipe[num] && !isAdded[num]) {
						isRipe[num] = true;
						ripeCnt++;
						ans[num] = time + 1;
						
						q.add(num);
						isAdded[num] = true;
					}
				}
			}
			
			for(int i = nextRipe.size(); i > 0; i--) {
				int next = nextRipe.poll();
				
				if(!isRipe[next]) {
					isRipe[next] = true;
					ans[next] = time + 1;
					ripeCnt++;
				}
			}
		
			
			if(q.isEmpty() && !qTime.isEmpty()) {
				time = qTime.peek().t;
			} else {
				time++;	
			}
		}
	}
	
	static boolean changeLink(int a, int b) {
		if(link[a].contains(b)) {
			link[a].remove(b);
			link[b].remove(a);
			
			return false;
		} else {
			link[a].add(b);
			link[b].add(a);
			
			return true;
		}
	}
	
	static void print() {
		StringBuilder sb = new StringBuilder();
		
		for(int i = 1; i <= N; i++) {
			if(isRipe[i]) sb.append(ans[i]).append(" ");
			else sb.append(-1).append(" ");
		}
		
		System.out.print(sb);
	}
	
	public static void main(String[] args) throws IOException {
		input();
		solve();
		print();
	}

}
