import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int N;
	static int [][] arr;
	static StringBuilder ans = new StringBuilder();
	
	static void recursive(int startRow, int startCol, int len) {
		int x = arr[startRow][startCol];
		boolean isSame = true;
		
		for(int i = startRow; i < startRow + len; i++) {
			for(int j = startCol; j < startCol + len; j++) {
				if(arr[i][j] != x) {
					isSame = false;
					break;
				}
			}
			if(!isSame) break;
		}
		
		if(isSame) {
			ans.append(x);
		} else {
			if(len == 2) {
				ans.append("("+arr[startRow][startCol]+arr[startRow][startCol+1]+arr[startRow+1][startCol]+arr[startRow+1][startCol+1]+")");
			}
			else {
				ans.append("(");
				recursive(startRow, startCol, len/2);
				recursive(startRow, startCol+len/2, len/2);
				recursive(startRow+len/2, startCol, len/2);
				recursive(startRow+len/2, startCol+len/2, len/2);
				ans.append(")");
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		
		for(int i = 0; i < N; i++) {				// 영상 입력
			String s = br.readLine();
			for(int j = 0; j < N; j++) {
				arr[i][j] = s.charAt(j)-'0';
			}
		}
		
		recursive(0, 0, N);
		System.out.println(ans);
	}

}