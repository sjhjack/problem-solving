import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static PriorityQueue<Pos> pq = new PriorityQueue<>();
	
	static class Pos implements Comparable<Pos> {
		int x;
		int y;
		
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		@Override
		public int compareTo(Pos o) {
			if(this.x == o.x) {
				return this.y - o.y;
			}
			
			return this.x - o.x;
		}
	}
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			pq.add(new Pos(x, y));
		}
	}
	
	static void print() {
		StringBuilder ans = new StringBuilder();
		
		for(int i = 0; i < N; i++) {
			Pos cur = pq.poll();
			ans.append(cur.x).append(" ").append(cur.y).append("\n");
		}
		
		System.out.print(ans);
	}
	
	public static void main(String[] args) throws IOException {
		input();
		print();
	}
}
