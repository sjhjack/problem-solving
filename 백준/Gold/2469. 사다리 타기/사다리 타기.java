import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Main {
	static int N, K;
	static char[] start;
	static char[] target;
	static Queue<char[]> startList = new ArrayDeque<>();
	static Stack<char[]> endList = new Stack<>();
	static StringBuilder ans = new StringBuilder();

	public static void main(String[] args) throws IOException {
		input();
		solve();
		System.out.print(ans);
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		K = Integer.parseInt(br.readLine());
		N = Integer.parseInt(br.readLine());

		start = new char[K];
		target = br.readLine().toCharArray();

		for(int i = 0; i < K; i++){
			start[i] = (char)('A' + i);
		}

		for(int i = 0; i < N; i++){
			char[] tmp = br.readLine().toCharArray();
			if(tmp[0] == '?') break;
			startList.add(tmp);
		}
		for(int i = startList.size() + 1; i < N; i++){
			endList.add(br.readLine().toCharArray());
		}
	}

	static void solve() {
		swapStartLine();
		swapEndLine();
		compareStartAndTarget();
	}

	static void swapStartLine() {
		for(int i = startList.size(); i > 0; i--){
			char[] cur = startList.poll();
			for(int j = 0; j < K-1; j++){
				if(cur[j] == '-'){
					swap(start, j, j + 1);
				}
			}
		}
	}

	static void swapEndLine() {
		for(int i = endList.size(); i > 0; i--){
			char[] cur = endList.pop();
			for(int j = 0; j < K-1; j++){
				if(cur[j] == '-'){
					swap(target, j, j + 1);
				}
			}
		}
	}

	static void compareStartAndTarget() {
		for(int i = 0; i < K-1; i++){
			if(start[i] == target[i]) {
				ans.append("*");
			}
			else {
				if(start[i] == target[i+1] && start[i+1] == target[i]) {
					ans.append("-");
					swap(start, i, i + 1);
				} else {
					makeXText();
					break;
				}
			}
		}
	}

	static void makeXText() {
		ans = new StringBuilder();
		for(int i = 0; i < K-1; i++){
			ans.append("x");
		}
	}

	static void swap(char[] arr, int left, int right) {
		char tmp = arr[left];
		arr[left] = arr[right];
		arr[right] = tmp;
	}
}
