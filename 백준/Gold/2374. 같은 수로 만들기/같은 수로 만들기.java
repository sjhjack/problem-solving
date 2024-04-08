import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Main {

	static Map<Integer, List<Integer>> map = new HashMap<>();
	static Map<Integer, Group> groupInfo = new HashMap<>();
	static PriorityQueue<Integer> pqKeys = new PriorityQueue<>();
	static int[] myGroup;
	static int[] arr;
	static int N;

	static class Group {
		int start;
		int end;

		public Group(int start, int end){
			this.start = start;
			this.end = end;
		}

		public void setStart(int start){
			this.start = Math.min(this.start, start);
		}

		public void setEnd(int end){
			this.end = Math.max(this.end, end);
		}
	}

	public static void main(String[] args) throws IOException {
		input();
		solve();
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		myGroup = new int[N];
		arr = new int[N];

		for(int i = 0; i < N; i++){
			int num = Integer.parseInt(br.readLine());
			arr[i] = num;
		}

		int start = 0;
		int groupNum = 0;

		for(int i = 1; i < N; i++){
			if(arr[i] != arr[start]){
				myGroup[start] = groupNum;
				myGroup[i - 1] = groupNum;
				groupInfo.put(groupNum, new Group(start, i - 1));

				if(map.containsKey(arr[start])){
					map.get(arr[start]).add(groupNum);
				} else {
					List<Integer> tmp = new ArrayList<>();
					tmp.add(groupNum);
					map.put(arr[start], tmp);
					pqKeys.add(arr[start]);
				}

				start = i;
				groupNum++;
			}
		}

		myGroup[start] = groupNum;
		myGroup[N - 1] = groupNum;
		groupInfo.put(groupNum, new Group(start, N - 1));

		if(map.containsKey(arr[start])){
			map.get(arr[start]).add(groupNum);
		} else {
			List<Integer> tmp = new ArrayList<>();
			tmp.add(groupNum);
			map.put(arr[start], tmp);
			pqKeys.add(arr[start]);
		}
	}

	static void solve() {
		BigInteger ans = new BigInteger("0");

		while(!pqKeys.isEmpty()){
			int cur = pqKeys.poll();

			for(int group : map.get(cur)){
				int start = groupInfo.get(group).start;		// index
				int end = groupInfo.get(group).end;			// index

				int left = start - 1  >= 0 ? arr[start - 1] : Integer.MAX_VALUE;	// key
				int right = end + 1 < N ? arr[end + 1] : Integer.MAX_VALUE;			// key

				if(left < right){
					ans = ans.add(BigInteger.valueOf(left - cur));
					groupInfo.get(myGroup[start - 1]).setEnd(end);
				} else if(left > right){
					ans = ans.add(BigInteger.valueOf(right - cur));
					groupInfo.get(myGroup[end + 1]).setStart(start);
				} else {
					if(left == Integer.MAX_VALUE) continue;

					ans = ans.add(BigInteger.valueOf(left - cur));
					groupInfo.get(myGroup[start - 1]).setEnd(end);
					groupInfo.get(myGroup[end + 1]).setStart(start);
				}
			}
		}

		System.out.print(ans);
	}
}
