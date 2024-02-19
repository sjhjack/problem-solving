import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static List<Integer>[] joinParty;
	static List<Integer>[] partyMember;
	static Queue<Integer> memberQ = new ArrayDeque<>();
	static boolean[] memberVisited;

	public static void main(String[] args) throws IOException {
		input();
		solve();
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		joinParty = new List[N + 1];		// member가 참여하는 party
		partyMember = new List[M + 1];		// party에 참여하는 member
		memberVisited = new boolean[N + 1];

		for(int i = 1; i <= N; i++) joinParty[i] = new ArrayList<>();
		for(int i = 1; i <= M; i++) partyMember[i] = new ArrayList<>();

		st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());

		if(K > 0){
			for(int i = 0; i < K; i++){
				int person = Integer.parseInt(st.nextToken());
				memberQ.add(person);
				memberVisited[person] = true;
			}
		}

		for(int i = 1; i <= M; i++){
			st = new StringTokenizer(br.readLine());
			int partyMemberCnt = Integer.parseInt(st.nextToken());

			for(int j = 0; j < partyMemberCnt; j++){
				int member = Integer.parseInt(st.nextToken());
				partyMember[i].add(member);
				joinParty[member].add(i);
			}
		}
	}

	static void solve() {
		boolean[] partyVisited = new boolean[M + 1];
		int ans = M;

		while(!memberQ.isEmpty()){
			int person = memberQ.poll();

			for(int party : joinParty[person]){
				if(!partyVisited[party]){
					partyVisited[party] = true;
					ans--;

					for(int member : partyMember[party]){
						if(!memberVisited[member]){
							memberVisited[member] = true;
							memberQ.add(member);
						}
					}
				}
			}
		}

		System.out.print(ans);
	}
}
