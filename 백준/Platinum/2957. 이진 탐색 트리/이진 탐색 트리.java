import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.TreeSet;

public class Main {

	static Queue<Integer> queue = new ArrayDeque<>();
	static StringBuilder ans = new StringBuilder();
	static long[] numCnt;

	public static void main(String[] args) throws IOException {
		input();
		solve();
		System.out.print(ans);
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		numCnt = new long[N + 1];

		for(int i = 0; i < N; i++){
			int num = Integer.parseInt(br.readLine());
			queue.add(num);
		}
	}

	static void solve(){
		TreeSet<Integer> treeSet = new TreeSet<>();
		long count = 0;

		ans.append(0).append("\n");		// 처음은 무조건 0
		treeSet.add(queue.poll());

		while(!queue.isEmpty()){
			int cur = queue.poll();
			int lower_bound;
			int upper_bound;

			Integer result = treeSet.lower(cur);
			lower_bound = result == null ? 0 : result;

			result = treeSet.higher(cur);
			upper_bound = result == null ? 0 : result;

			long cnt = Math.max(numCnt[lower_bound], numCnt[upper_bound]) + 1;
			numCnt[cur] = cnt;
			treeSet.add(cur);

			count += cnt;
			ans.append(count).append("\n");
		}
	}
}
