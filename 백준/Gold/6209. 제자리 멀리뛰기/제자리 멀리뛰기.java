import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int D, N, M;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		input();
		solve();
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		D = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N + 2];

		arr[0] = 0;
		arr[N + 1] = D;

		for(int i = 1; i <= N; i++){
			arr[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(arr);
	}

	static void solve() {
		int ans = getMinDist();
		int start = 0;
		int end = D;

		while(start <= end){
			int mid = (start + end) / 2;

			if(jump(mid)){
				ans = mid;
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}

		System.out.print(ans);
	}

	static int getMinDist(){
		int len = D;

		for(int i = 1; i < arr.length; i++){
			len = Math.min(len, arr[i] - arr[i - 1]);
		}

		return len;
	}

	static boolean jump(int dist){
		int count = 0;
		int now = 0;
		boolean[] isVisited = new boolean[N + 2];

		for(int next = 1; next < arr.length; next++){
			if(arr[next] - arr[now] < dist){
				if(count < M){
					count++;
					isVisited[next] = true;
				} else {
					return false;
				}
			} else {
				now++;
				while(isVisited[now]){
					now++;
				}
			}
		}

		return true;
	}
}
