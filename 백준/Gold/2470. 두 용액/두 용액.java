import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static List<Integer> plus = new ArrayList<>();
	static List<Integer> minus = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		input();
		solve();
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++){
			int num = Integer.parseInt(st.nextToken());

			if(num >= 0) {
				plus.add(num);
			} else {
				minus.add(num);
			}
		}
	}

	static void solve() {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int ans = Integer.MAX_VALUE;
		int left = minus.size() - 1;
		int right = plus.size() - 1;

		Collections.sort(plus);
		Collections.sort(minus, Collections.reverseOrder());

		if(left >= 0 && right >= 0){
			while (true) {
				int cur = Math.abs(minus.get(left) + plus.get(right));
				if (ans > cur) {
					ans = cur;
					pq.clear();
					pq.add(plus.get(right));
					pq.add(minus.get(left));
				}

				if (left == 0 && right == 0)
					break;
				else if (left == 0) {
					right--;
				} else if (right == 0) {
					left--;
				} else {
					int changeRight = Math.abs(minus.get(left) + plus.get(right - 1));
					int changeLeft = Math.abs(minus.get(left - 1) + plus.get(right));

					if (changeRight <= changeLeft) {
						right--;
					} else {
						left--;
					}
				}
			}
		}

		if(plus.size() > 1) {
			int cur = Math.abs(plus.get(0) + plus.get(1));
			if(ans > cur) {
				ans = cur;
				pq.clear();
				pq.add(plus.get(0));
				pq.add(plus.get(1));
			}
		}

		if(minus.size() > 1) {
			int cur = Math.abs(minus.get(0) + minus.get(1));
			if(ans > cur) {
				ans = cur;
				pq.clear();
				pq.add(minus.get(0));
				pq.add(minus.get(1));
			}
		}

		System.out.print(pq.poll() + " " + pq.poll());
	}
}
