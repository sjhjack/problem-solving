import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int num = 0;
		for(int i = 0; i < 8; i++){
			num = num * 10 + Integer.parseInt(st.nextToken());
		}

		if(num == 12345678){
			System.out.print("ascending");
		} else if(num == 87654321){
			System.out.print("descending");
		} else {
			System.out.print("mixed");
		}
	}
}
