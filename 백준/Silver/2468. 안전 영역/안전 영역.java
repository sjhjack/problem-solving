import java.io.*;
import java.util.*;

public class Main {

	static int N, Max = Integer.MIN_VALUE;
	static int [][] arr;
	static boolean [][] isVisited;
	
	static void clear() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				isVisited[i][j] = false;
			}
		}
	}
	
	static void findArea(int row, int col, int water) {
		isVisited[row][col] = true;		// 방문 표시
		
		if(row-1>=0 && isVisited[row-1][col] == false && arr[row-1][col] > water) findArea(row-1, col, water);	// 상
		if(row+1<N  && isVisited[row+1][col] == false && arr[row+1][col] > water) findArea(row+1, col, water);	// 하
		if(col-1>=0 && isVisited[row][col-1] == false && arr[row][col-1] > water) findArea(row, col-1, water);	// 좌
		if(col+1<N  && isVisited[row][col+1] == false && arr[row][col+1] > water) findArea(row, col+1, water);	// 우
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		arr = new int [N][N];
		isVisited = new boolean [N][N];
		
		for(int i = 0; i < N; i++) {		// 입력
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				Max = arr[i][j] > Max ? arr[i][j] : Max;		// 지역의 최대 높이 구하기
			}
		}
		
		int ans = 0, cnt;
		for(int h = 0; h < Max; h++) {		// 물 높이마다 전부 확인
			cnt = 0;
			clear();						// isVisited 초기화
			
			for(int i = 0; i < N; i++) {	// 전체 확인
				for(int j = 0; j < N; j++) {
					if(arr[i][j] <= h || isVisited[i][j]) continue;		// 물에 잠기거나 이미 방문한 경우 continue
					
					findArea(i, j, h);
					cnt++;					// 안전 영역 개수 카운트
				}
			}
			
			ans = cnt > ans ? cnt : ans;	// 최대 안전 영역 개수 저장
		}
		
		System.out.println(ans);
		
	}

}