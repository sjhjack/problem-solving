import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[] arr;

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
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
	}
	
	static void solve() {
		int left = 0;
		int right = arr.length - 1;
		int dist = Integer.MAX_VALUE;
		int num1 = 0, num2 = 0;
		
		while(left < right) {
			int tmp = arr[left] + arr[right];
			
			if(tmp < 0) {
				if(Math.abs(tmp) < dist) {
					dist = Math.abs(tmp);
					num1 = arr[left];
					num2 = arr[right];
				}
				left++;
			} else {
				if(Math.abs(tmp) < dist) {
					dist = Math.abs(tmp);
					num1 = arr[left];
					num2 = arr[right];
				}
				right--;
			}
		}
		
		System.out.print(num1 + " " + num2);
	}
}
