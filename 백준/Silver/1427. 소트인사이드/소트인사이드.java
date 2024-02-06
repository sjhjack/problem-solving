import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] num = br.readLine().toCharArray();
		Arrays.sort(num);
		StringBuilder ans = new StringBuilder(new String(num)).reverse(); 
		
		System.out.print(ans);
	}
}
