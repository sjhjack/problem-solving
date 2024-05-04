import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

	static class Electric {
		long value;
		long multi;
		
		public Electric(long value, long multi) {
			this.value = value;
			this.multi = multi;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Map<String, Electric> map = new HashMap<>();
		
		map.put("black", new Electric(0, 1));
		map.put("brown", new Electric(1, 10));
		map.put("red", new Electric(2, 100));
		map.put("orange", new Electric(3, 1000));
		map.put("yellow", new Electric(4, 10000));
		map.put("green", new Electric(5, 100000));
		map.put("blue", new Electric(6, 1000000));
		map.put("violet", new Electric(7, 10000000));
		map.put("grey", new Electric(8, 100000000));
		map.put("white", new Electric(9, 1000000000));
		
		long sum = 0;
		
		for(int i = 0; i < 2; i++) {
			String color = br.readLine();
			sum = sum * 10 + map.get(color).value;
		}
		
		String color = br.readLine();
		sum = sum * map.get(color).multi;
		
		System.out.print(sum);
	}
}
