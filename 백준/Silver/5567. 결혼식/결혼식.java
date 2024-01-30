import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static List<Integer>[] list;

	public static void main(String[] args) throws IOException {
		input();
		solve();
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		list = new ArrayList[N + 1];

		for(int i = 1; i <= N; i++) list[i] = new ArrayList<>();

		for(int i = 0; i < M; i++){
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			list[a].add(b);
			list[b].add(a);
		}
	}

	static void solve() {
		boolean[] isVisited = new boolean[N + 1];
		Queue<Integer> q = new ArrayDeque<>();
		int cnt = 0;

		isVisited[1] = true;

		// 1의 친구 넣기
		for(int myFriend : list[1]){
			q.add(myFriend);
			isVisited[myFriend] = true;
			cnt++;
		}

		for(int n = q.size(); n > 0; n--){
			int cur = q.poll();

			for(int next : list[cur]){
				if(!isVisited[next]){
					isVisited[next] = true;
					cnt++;
				}
			}
		}

		System.out.print(cnt);
	}
}
