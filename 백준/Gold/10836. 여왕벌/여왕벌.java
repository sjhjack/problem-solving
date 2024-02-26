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
			solve();
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

	static void solve() throws IOException {
		st = new StringTokenizer(br.readLine());

		int zero = Integer.parseInt(st.nextToken());
		int one = Integer.parseInt(st.nextToken());
		int two = Integer.parseInt(st.nextToken());

		for (int j = 0; j < M; j++) {
			if(zero != 0) {
				zero--;
			} else if(one != 0) {
				vertical[j] += 1;
				one--;
			} else if(two != 0) {
				vertical[j] += 2;
				two--;
			}
		}
		for (int j = 0; j < M - 1; j++) {
			if(zero != 0) {
				zero--;
			} else if(one != 0) {
				horizon[j] += 1;
				one--;
			} else if(two != 0) {
				horizon[j] += 2;
				two--;
			}
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
