import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int M, N;
	static int[] vertical;
	static int[] horizon;
	static Queue<Integer> queue = new ArrayDeque<>();

	public static void main(String[] args) throws IOException {
		init();

		for(int i = 0; i < N; i++){
			input();
			makeSum();
		}

		print();
	}

	static void init() throws IOException {
		st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		vertical = new int[M];
		horizon = new int[M - 1];

		Arrays.fill(vertical, 1);
		Arrays.fill(horizon, 1);
	}

	static void input() throws IOException {
		st = new StringTokenizer(br.readLine());

		int zero = Integer.parseInt(st.nextToken());
		int one = Integer.parseInt(st.nextToken());
		int two = Integer.parseInt(st.nextToken());

		while(zero > 0) {
			queue.add(0);
			zero--;
		}

		while(one > 0) {
			queue.add(1);
			one--;
		}

		while(two > 0) {
			queue.add(2);
			two--;
		}
	}

	static void makeSum() {
		for(int j = 0; j < M; j++){
			vertical[j] += queue.poll();
		}

		for(int j = 0; j < M - 1; j++){
			horizon[j] += queue.poll();
		}
	}

	static void print(){
		StringBuilder ans = new StringBuilder();

		for(int i = M - 1; i >= 0; i--){
			ans.append(vertical[i]).append(" ");
			for(int j = 0; j < M - 1; j++){
				ans.append(horizon[j]).append(" ");
			}
			ans.append("\n");
		}

		System.out.print(ans);
	}
}
