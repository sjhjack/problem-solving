import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder ans = new StringBuilder();
	static int K;
	static char[] arr;

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			input();
			solve();
		}
		
		System.out.print(ans);
	}
	
	static void input() throws IOException {
		arr = br.readLine().toCharArray();
		K = Integer.parseInt(br.readLine());
	}
	
	static void solve() {
		int[] counts = new int['z'-'a'+1];
		int shortLen = 10001;
		int longLen = 0;
		
		if(K == 1) {
			ans.append("1 1\n");
			return;
		}
		
		for(int i = 0; i < arr.length; i++) {
			counts[arr[i]-'a']++;
		}
		
		for(int i = 0; i < arr.length - 1; i++) {
			char cur = arr[i];
			int cnt = 1;
			
			// 애초에 K개 미만인 알파벳은 탐색할 필요가 없다.
			if(counts[cur - 'a'] < K) continue;
			
			for(int j = i + 1; j < arr.length; j++) {
				char tmp = arr[j];
				
				if(cur == tmp) {
					if(++cnt == K) {
						int len = j - i + 1;
						shortLen = Math.min(shortLen, len);
						longLen = Math.max(longLen, len);
					}
				}
			}
		}
		
		if(shortLen < 10001 && longLen > 0) ans.append(shortLen).append(" ").append(longLen).append("\n");
		else ans.append("-1\n");
	}
}