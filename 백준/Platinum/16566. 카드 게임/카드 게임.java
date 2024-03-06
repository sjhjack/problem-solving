import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	static int N, M, K;
	static int[] arr;
	static int[] nextNumberIndex;
	static int[] query;

	public static void main(String[] args) throws IOException {
		input();
		solve();
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		arr = new int[M];
		nextNumberIndex = new int[M + 1];	// 마지막 인덱스 하나 더 추가
		query = new int[K];

		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < K; i++){
			query[i] = Integer.parseInt(st.nextToken());
		}
	}

	static void solve(){
		StringBuilder ans = new StringBuilder();

		Arrays.sort(arr);
		for(int i = 0; i < nextNumberIndex.length; i++){
			nextNumberIndex[i] = i;
		}

		for(int target : query){
			Stack<Integer> stack = new Stack<>();
			int index = Arrays.binarySearch(arr, target);

			if(index < 0){
				index = -1 * index - 1;
			} else {
				index++;
			}

			while(nextNumberIndex[index] != index){
				stack.add(index);
				index = nextNumberIndex[index];
			}

			ans.append(arr[index]).append("\n");

			nextNumberIndex[index] = nextNumberIndex[index + 1];
			index = nextNumberIndex[index + 1];

			while(!stack.isEmpty()){
				int curIdx = stack.pop();
				nextNumberIndex[curIdx] = index;
			}
		}

		System.out.print(ans);
	}
}
