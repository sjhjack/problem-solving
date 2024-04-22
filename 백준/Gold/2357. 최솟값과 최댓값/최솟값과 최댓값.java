import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[] maxTree, minTree;
	static int depth, startIdx;
	static Queue<Query> queue = new ArrayDeque<>();

	static class Query {
		int from;
		int to;

		public Query(int from, int to){
			this.from = from;
			this.to = to;
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

		initTree();

		for(int i = 0; i < N; i++){
			int num = Integer.parseInt(br.readLine());

			maxTree[startIdx + i] = num;
			minTree[startIdx + i] = num;
		}

		fillTree();

		for(int i = 0; i < M; i++){
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			queue.add(new Query(from, to));
		}
	}

	static void initTree() {
		depth = (int)Math.ceil(Math.log(N) / Math.log(2));
		startIdx = 1 << depth;

		maxTree = new int[1 << (depth + 1)];
		minTree = new int[1 << (depth + 1)];
	}

	static void fillTree() {
		if(N < startIdx){
			for(int i = 0; i < startIdx - N; i++){
				maxTree[startIdx + N] = 0;
			}

			for(int i = 0; i < startIdx - N; i++){
				minTree[startIdx + N] = Integer.MAX_VALUE;
			}
		}

		for(int i = startIdx - 1; i > 0; i--){
			maxTree[i] = Math.max(maxTree[2 * i], maxTree[2 * i + 1]);
		}

		for(int i = startIdx - 1; i > 0; i--){
			minTree[i] = Math.min(minTree[2 * i], minTree[2 * i + 1]);
		}
	}

	static void solve() {
		StringBuilder ans = new StringBuilder();

		while(!queue.isEmpty()){
			Query cur = queue.poll();

			int min = findMin(1, 1, 1 << depth, cur.from, cur.to);
			int max = findMax(1, 1, 1 << depth, cur.from, cur.to);

			ans.append(min).append(" ").append(max).append("\n");
		}

		System.out.print(ans);
	}

	static int findMin(int index, int left, int right, int start, int end){
		if(end < left || right < start) return Integer.MAX_VALUE;
		else if(start <= left && right <= end) return minTree[index];

		int mid = (left + right) / 2;

		return Math.min(findMin(2*index, left, mid, start, end),
			findMin(2*index + 1, mid + 1, right, start, end));
	}

	static int findMax(int index, int left, int right, int start, int end){
		if(end < left || right < start) return Integer.MIN_VALUE;
		else if(start <= left && right <= end) return maxTree[index];

		int mid = (left + right) / 2;

		return Math.max(findMax(2*index, left, mid, start, end),
			findMax(2*index + 1, mid + 1, right, start, end));
	}
}
