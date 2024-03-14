import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int ans;
	static int[][] arr;
	static boolean[] isSelected;
	static int inSum, outSum;

	public static void main(String[] args) throws IOException {
		input();
		solve();
		System.out.print(ans);
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		isSelected = new boolean[N];

		for(int i = 0; i < N; i++){
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++){
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	static void solve(){
		ans = Integer.MAX_VALUE;
		makeGroup(0, 0);
	}

	static void makeGroup(int idx, int count){
		if(ans == 0 || count > N / 2) return;

		if(count == N / 2){
			getSum();
			ans = Math.min(ans, Math.abs(inSum - outSum));

			return;
		}

		if(idx < N){
			isSelected[idx] = true;
			makeGroup(idx + 1, count + 1);

			isSelected[idx] = false;
			makeGroup(idx + 1, count);
		}
	}

	static void getSum(){
		inSum = 0;
		outSum = 0;

		for(int i = 0; i < N; i++){
			for(int j = 0; j < N; j++){
				if(isSelected[i] && isSelected[j]){
					inSum += arr[i][j];
				} else if(!isSelected[i] && !isSelected[j]){
					outSum += arr[i][j];
				}
			}
		}
	}
}
