import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];

		Stack<Integer> stack = new Stack<>();
		long ans = 0;

		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		stack.add(0);

		for(int i = 1; i < N; i++) {
			while(!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
				ans += i - stack.pop() - 1;
			}

			stack.add(i);
		}

		while(!stack.isEmpty()) {
			ans += N-1 - stack.pop();
		}

		System.out.print(ans);
	}
}
