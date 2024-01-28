import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static meeting[] list;
	
	static class meeting implements Comparable<meeting>{
		int start;
		int end;
		
		public meeting(int start, int end) {
			this.start = start;
			this.end = end;
		}
		
		@Override
		public int compareTo(meeting o) {
			if(end == o.end) {
				return start - o.start;
			}
			return end - o.end;
		}
	}
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		list = new meeting[N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			list[i] = new meeting(start, end);
		}
	}
	
	static void solve() {
		int cnt = 0;
		int end = 0;
		
		Arrays.sort(list);
		
		for(int i = 0; i < N; i++) {
			if(list[i].start >= end) {
				cnt++;
				end = list[i].end;
			}
		}
		
		System.out.print(cnt);
	}
	
	public static void main(String[] args) throws IOException {
		input();
		solve();
	}
}
