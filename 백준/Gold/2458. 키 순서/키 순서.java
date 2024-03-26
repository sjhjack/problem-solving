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
	static Node[] nodes;

	static class Node {
		int num;
		List<Integer> big = new ArrayList<>();
		List<Integer> small = new ArrayList<>();

		public Node(int num){
			this.num = num;
		}
	}

	public static void main(String[] args) throws IOException {
		input();
		solve();
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		nodes = new Node[N + 1];
		for(int i = 1; i <= N; i++) nodes[i] = new Node(i);

		for(int i = 0; i < M; i++){
			st = new StringTokenizer(br.readLine());
			int small = Integer.parseInt(st.nextToken());
			int big = Integer.parseInt(st.nextToken());

			nodes[small].big.add(big);
			nodes[big].small.add(small);
		}
	}

	static void solve(){
		int ans = 0;

		for(int i = 1; i <= N; i++){
			Queue<Integer> queue = new ArrayDeque<>();
			boolean[] isVisited = new boolean[N + 1];
			int cnt = nodes[i].small.size() + nodes[i].big.size();

			for(int small : nodes[i].small){
				queue.add(small);
				isVisited[small] = true;
			}

			while(!queue.isEmpty()){
				int cur = queue.poll();

				for(int small : nodes[cur].small){
					if(!isVisited[small]){
						isVisited[small] = true;
						queue.add(small);
						cnt++;
					}
				}
			}

			for(int big : nodes[i].big){
				queue.add(big);
				isVisited[big] = true;
			}

			while(!queue.isEmpty()){
				int cur = queue.poll();

				for(int big : nodes[cur].big){
					if(!isVisited[big]){
						isVisited[big] = true;
						queue.add(big);
						cnt++;
					}
				}
			}

			if(cnt == N - 1) ans++;
		}

		System.out.print(ans);
	}
}
