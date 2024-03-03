import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M;
	static Map<Integer, Set<Integer>> groups = new HashMap<>();		// 그룹 번호 : 그룹에 속한 점들
	static int[] myGroup;		// 각 점이 속한 그룹의 번호
	static Edge[] query;
	
	static class Edge {
		int from;
		int to;
		
		public Edge(int from , int to) {
			this.from = from;
			this.to = to;
		}
	}

	public static void main(String[] args) throws IOException {
		input();
		solve();
	}
	
	static void input() throws IOException {
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		myGroup = new int[N];
		query = new Edge[M];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			query[i] = new Edge(from, to);
		}
	}
	
	static void solve() {
		int groupNumber = 1;
		int ans = 0;
		
		for(int i = 0; i < M; i++) {
			int from = query[i].from;
			int to = query[i].to;
			
			if(myGroup[from] != 0 && myGroup[to] != 0) {
				/* 둘 다 어떤 그룹에 속해있는 경우 */				
				if(myGroup[from] == myGroup[to]) {
					ans = i + 1;
					break;
				} else {
					int bigGroup, smallGroup;
					
					if(groups.get(myGroup[from]).size() >= groups.get(myGroup[to]).size()) {
						bigGroup = from;
						smallGroup = to;
					} else {
						bigGroup = to;
						smallGroup = from;
					}
					
					int bigGroupNumber = myGroup[bigGroup];
					Set<Integer> set = groups.get(myGroup[bigGroup]);
					
					for(int vertex : groups.get(myGroup[smallGroup])) {
						set.add(vertex);
						myGroup[vertex] = bigGroupNumber;
					}
					
					groups.put(myGroup[bigGroup], set);
				}
				
			} else if(myGroup[from] == 0 && myGroup[to] == 0) {
				/* 둘 다 그룹에 속해있지 않은 경우 */
				myGroup[from] = groupNumber;
				myGroup[to] = groupNumber;
				
				Set<Integer> set = new HashSet<>();
				set.add(from);
				set.add(to);
				
				groups.put(groupNumber, set);
				groupNumber++;
			} else {
				/* 하나만 그룹에 속해있는 경우 */
				int inGroup, outGroup;
				
				if(myGroup[from] == 0) {
					inGroup = to;
					outGroup = from;
				} else {
					inGroup = from;
					outGroup = to;
				}
				
				myGroup[outGroup] = myGroup[inGroup];
				groups.get(myGroup[inGroup]).add(outGroup);
			}
		}
		
		System.out.print(ans);
	}
}
