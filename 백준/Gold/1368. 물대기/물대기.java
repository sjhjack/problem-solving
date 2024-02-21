import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] wellCost;
	static int[][] connectCost;

	static class Node implements Comparable<Node> {
		int num;
		int cost;

		public Node(int num, int cost){
			this.num = num;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node n){
			return cost - n.cost;
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
		wellCost = new int[N];
		connectCost = new int[N][N];

		for(int i = 0; i < N; i++){
			wellCost[i] = Integer.parseInt(br.readLine());
		}

		for(int i = 0; i < N; i++){
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++){
				connectCost[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	static void solve() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		int ans = Integer.MAX_VALUE;

		for(int i = 0; i < N; i++){
			pq.add(new Node(i, wellCost[i]));
		}

		for(int i = 0; i < N; i++){
			ans = Math.min(ans, prim(pq.poll().num));
		}

		System.out.print(ans);
	}

	static int prim(int startNode) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] isVisited = new boolean[N];
		int[] minCost = new int[N];
		int count = 0;
		int cost = wellCost[startNode];

		Arrays.fill(minCost, Integer.MAX_VALUE);
		minCost[startNode] = 0;
		pq.add(new Node(startNode, 0));

		while(!pq.isEmpty()){
			Node cur = pq.poll();

			if(isVisited[cur.num]) continue;
			isVisited[cur.num] = true;

			cost += cur.cost;
			if(++count == N) break;

			for(int i = 0; i < N; i++){
				if(!isVisited[i]){
					int curCost = Math.min(wellCost[i], connectCost[cur.num][i]);

					if(curCost < minCost[i]){
						pq.add(new Node(i, curCost));
						minCost[i] = curCost;
					}
				}
			}
		}

		return cost;
	}
}
