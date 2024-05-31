import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static class Pos {
		int row;
		int col;

		public Pos(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int max = -1;
		Pos maxPos = null;

		for(int i = 1; i <= 9; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= 9; j++) {
				int num = Integer.parseInt(st.nextToken());

				if(num > max) {
					max = num;
					maxPos = new Pos(i, j);
				}
			}
		}

		System.out.print(max + "\n" + maxPos.row + " " + maxPos.col);
	}
}
