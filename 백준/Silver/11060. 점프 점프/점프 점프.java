import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] arr;

	static class Pos {
		int index;
		int length;

		public Pos(int index, int length){
			this.index = index;
			this.length = length;
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
		arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}
	}

	static void solve() {
		Queue<Pos> q = new ArrayDeque<>();
		int[] dist = new int[N];
		Arrays.fill(dist, Integer.MAX_VALUE);

		q.add(new Pos(0, 0));
		dist[0] = 0;

		while(!q.isEmpty()){
			Pos cur = q.poll();
			int idx = cur.index;
			int len = cur.length;

			for(int i = 1; i <= arr[idx]; i++){
				if(idx + i < N && dist[idx + i] > len + 1){
					q.add(new Pos(idx + i, len + 1));
					dist[idx + i] = len + 1;
				}
			}
		}

		if(dist[N - 1] == Integer.MAX_VALUE) System.out.print(-1);
		else System.out.print(dist[N - 1]);
	}
}
