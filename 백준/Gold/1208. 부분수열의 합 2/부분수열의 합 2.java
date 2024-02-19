/*
N <= 40 이므로, 재귀로 부분 수열 구하면 최대 경우의 수가 2^40이다.
절반씩 나눠서 재귀로 구하면 최대 2^20 * 2 이다.
(2^40 = 1,099,511,627,776 = 약 1조)
(2^20 = 1,048,576 = 약 1백만)

leftList : 최대 2^20
rightList : 최대 2^20
에 대해 투 포인터를 돌렸을 때의 수행시간을 알아보면, 2^20 + 2^20 = 약 2백만이므로
제한 시간 내에 충분히 가능하다.

ans의 경우, 최대 2^20 * 2^20 이므로 long 이어야 한다.
예시)
40 0
0 0 0 0 ... 0 0 0
	-> 2^40 - 1 = 1,099,511,627,775 = 약 1조
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N, S;
	static long ans;
	
	static int[] arr;
	static List<Integer> leftList = new ArrayList<>();
	static List<Integer> rightList = new ArrayList<>();
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}		
	}
	
	static void solve() {		
		// 절반씩 나눠서 부분 수열 탐색
		findSum(0, N/2, 0, leftList);
		findSum(N/2+1, N-1, 0, rightList);
		
		Collections.sort(leftList);
		Collections.sort(rightList);
		
		int left = 0;
		int right = rightList.size() - 1;
		
		// 투포인터
		while(left < leftList.size() && right >= 0) {
			int leftVal = leftList.get(left);
			int rightVal = rightList.get(right);
			int sum = leftVal + rightVal;
			
			if(sum < S) {
				left++;
			} else if(sum > S) {
				right--;
			} else {
				long leftLen = 1;
				long rightLen = 1;
				
				left++;
				
				while(left < leftList.size() && leftList.get(left) == leftVal) {
					leftLen++;
					left++;
				}
				
				right--;
				
				while(right >= 0 && rightList.get(right) == rightVal) {
					rightLen++;
					right--;
				}
				
				ans += leftLen * rightLen;
			}
		}
		
		// S==0인 경우, 전체 수열에서 아무것도 고르지 않은 1가지 경우의 수를 빼야함
		if(S == 0) {
			ans--;
		}
	}
	
	static void findSum(int idx, int end, int sum, List<Integer> list) {
		// 아무것도 고르지 않은 부분 수열 {} : sum == 0이다.
		if(idx > end) {
			list.add(sum);
			return;
		}
		
		findSum(idx+1, end, sum+arr[idx], list);
		findSum(idx+1, end, sum, list);
	}
	
	public static void main(String[] args) throws IOException {
		input();
		solve();
		
		System.out.print(ans);
	}
}
