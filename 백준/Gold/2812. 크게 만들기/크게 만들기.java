import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	static int N, K;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		input();
		solve();
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		arr = new int[N];

		char[] tmp = br.readLine().toCharArray();
		for(int i = 0; i < N; i++){
			arr[i] = tmp[i] - '0';
		}
	}

	static void solve(){
		StringBuilder ans = new StringBuilder();
		Deque<Integer> deque = new ArrayDeque<>();
		int count = 0;
		int breakIndex = -1;

		deque.addLast(0);		// 0번 index 추가

		for(int i = 1; i < N; i++){
			if(arr[deque.peekLast()] >= arr[i]){
				deque.addLast(i);
			} else {
				if(count >= K){
					breakIndex = i;
					break;
				} else {
					while(!deque.isEmpty() && count < K && arr[deque.peekLast()] < arr[i]){
						deque.pollLast();
						count++;
					}
					deque.addLast(i);
				}
			}
		}

		while(count < K){
			deque.pollLast();
			count++;
		}

		while(!deque.isEmpty()){
			ans.append(arr[deque.pollFirst()]);
		}

		if(breakIndex >= 0){
			for(int i = breakIndex; i < N; i++){
				ans.append(arr[i]);
			}
		}

		System.out.print(ans);
	}
}
