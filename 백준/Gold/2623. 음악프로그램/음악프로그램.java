import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static List<Integer>[] arr;
	static int[] indegree;
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new ArrayList[N + 1];
		indegree = new int[N + 1];
		
		for(int i = 1; i <= N; i++) arr[i] = new ArrayList<>();
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int len = Integer.parseInt(st.nextToken());
			int tmp = Integer.parseInt(st.nextToken());
			
			for(int j = 0; j < len-1; j++) {
				int next = Integer.parseInt(st.nextToken());
				
				arr[tmp].add(next);
				indegree[next]++;
				tmp = next;
			}
		}
	}
	
	static void solve() {
		StringBuilder ans = new StringBuilder();
		Queue<Integer> q = new ArrayDeque<>();
		int cnt = 0;
		
		for(int i = 1; i <= N; i++) {
			if(indegree[i] == 0) {
				q.add(i);
				cnt++;
				
				ans.append(i).append("\n");
			}
		}
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for(int next : arr[cur]) {
				if(--indegree[next] == 0) {
					q.add(next);
					cnt++;
					
					ans.append(next).append("\n");
				}
			}
		}
		
		if(cnt < N) System.out.print(0);
		else System.out.print(ans);
	}
	
	public static void main(String[] args) throws IOException {
		input();
		solve();
	}
}
