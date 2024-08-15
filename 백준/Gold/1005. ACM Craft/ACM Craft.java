import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder ans = new StringBuilder();
	static int T, N, K, W;
	static Node[] tree;
	
	static class Node{
		int time;
		int maxTime;
		int parentCnt;
		int cnt;
		List<Integer> siblings = new ArrayList<>();
		
		private void setTime(int t) {
			maxTime = t > maxTime ? t : maxTime;
		}
	}
	
	static void input() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		tree = new Node[N+1];
		for(int i = 1; i <= N; i++) tree[i] = new Node();
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			tree[i].time = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int parent = Integer.parseInt(st.nextToken());
			int sibling = Integer.parseInt(st.nextToken());
			
			tree[parent].siblings.add(sibling);
			tree[sibling].parentCnt++;
		}
		
		W = Integer.parseInt(br.readLine());
	}
	
	static void BFS() {
		Queue<Integer> q = new ArrayDeque<>();
		
		for(int i = 1; i <= N; i++) {
			if(tree[i].parentCnt == 0) {
				tree[i].maxTime = tree[i].time;
				tree[i].time = 0;
				q.add(i);
			}
		}
		
		while(!q.isEmpty()) {
			Node cur = tree[q.poll()];
			
			for(int i = 0; i < cur.siblings.size(); i++) {
				int nodeNum = cur.siblings.get(i);
				Node next = tree[nodeNum];
				
				next.setTime(cur.maxTime + cur.time);
				if(++next.cnt == next.parentCnt) {
					q.add(nodeNum);
				}
			}
		}
		
		ans.append(tree[W].maxTime + tree[W].time).append("\n");
	}

	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			input();
			BFS();	
		}
		
		System.out.print(ans);
	}

}