import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder ans = new StringBuilder();
	private static int startNumber;
	private static int targetNumber;

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());

		for(int t = 0; t < T; t++) {
			input();
			solve();
		}

		System.out.print(ans);
	}

	private static void input() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		startNumber = Integer.parseInt(st.nextToken());
		targetNumber = Integer.parseInt(st.nextToken());
	}

	private static void solve() {
		Queue<Integer> queue = new ArrayDeque<>();
		String[] cmd = new String[10000];

		Arrays.fill(cmd, "");

		queue.add(startNumber);

		while(!queue.isEmpty()) {
			int cur = queue.poll();

			// D
			int doubleNum = cur * 2 % 10000;
			if(doubleNum == targetNumber) {
				ans.append(cmd[cur]).append("D\n");
				return;
			}
			if(doubleNum != startNumber && cmd[doubleNum].isBlank()) {
				cmd[doubleNum] += cmd[cur] + "D";
				queue.add(doubleNum);
			}

			// S
			int minusNum = cur == 0 ? 9999 : cur - 1;
			if(minusNum == targetNumber) {
				ans.append(cmd[cur]).append("S\n");
				return;
			}
			if(minusNum != startNumber && cmd[minusNum].isBlank()) {
				cmd[minusNum] += cmd[cur] + "S";
				queue.add(minusNum);
			}

			// L
			int leftNum = (cur % 1000) * 10 + cur / 1000;
			if(leftNum == targetNumber) {
				ans.append(cmd[cur]).append("L\n");
				return;
			}
			if(leftNum != startNumber && cmd[leftNum].isBlank()) {
				cmd[leftNum] += cmd[cur] + "L";
				queue.add(leftNum);
			}

			// R
			int rightNum = (cur / 10) + (cur % 10) * 1000;
			if(rightNum == targetNumber) {
				ans.append(cmd[cur]).append("R\n");
				return;
			}
			if(rightNum != startNumber && cmd[rightNum].isBlank()) {
				cmd[rightNum] += cmd[cur] + "R";
				queue.add(rightNum);
			}
		}
	}

}
