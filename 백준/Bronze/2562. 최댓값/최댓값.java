import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static class Number implements Comparable<Number> {
		int num;
		int idx;
		
		public Number(int num, int idx) {
			this.num = num;
			this.idx = idx;
		}
		
		@Override
		public int compareTo(Number o) {
			return o.num - this.num;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Number[] arr = new Number[9];
		
		for(int i = 0; i < 9; i++) {
			int num = Integer.parseInt(br.readLine());
			arr[i] = new Number(num, i + 1);
		}
		
		Arrays.sort(arr);
		
		System.out.print(arr[0].num + "\n" + arr[0].idx);
	}

}
