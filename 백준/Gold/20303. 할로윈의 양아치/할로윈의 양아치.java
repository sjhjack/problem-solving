import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static int N, M, K;
    private static int[] candy;
    private static List<Integer>[] relation;
    private static final List<Group> groups = new ArrayList<>();

    private static class Group implements Comparable<Group> {
        int member;
        int candy;

        public Group(int member, int candy) {
            this.member = member;
            this.candy = candy;
        }

        @Override
        public int compareTo(Group g) {
            if(member == g.member){
                return candy - g.candy;
            }
            return member - g.member;
        }

        @Override
        public String toString() {
            return "Group{" +
                    "member=" + member +
                    ", candy=" + candy +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        candy = new int[N + 1];
        relation = new ArrayList[N + 1];

        for(int i = 1; i <= N; i++) relation[i] = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            candy[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            relation[a].add(b);
            relation[b].add(a);
        }
    }

    private static void solve() {
        makeGroups();
        getCandy();
    }

    private static void makeGroups(){
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] isVisited = new boolean[N + 1];

        for(int i = 1; i <= N; i++){
            if(isVisited[i]) continue;

            int memberCnt = 0;
            int candyCnt = 0;

            q.add(i);
            isVisited[i] = true;

            while(!q.isEmpty()){
                int cur = q.poll();

                memberCnt++;
                candyCnt += candy[cur];

                for(int next : relation[cur]){
                    if(isVisited[next]) continue;
                    isVisited[next] = true;
                    q.add(next);
                }
            }

            groups.add(new Group(memberCnt, candyCnt));
        }
    }

    private static void getCandy(){
        int[] dp = new int[K];

        Collections.sort(groups);

        for(Group group : groups){
            if(group.member >= K) break;

            for(int i = K-1; i >= group.member; i--){
                dp[i] = Math.max(dp[i], dp[i - group.member] + group.candy);
            }
        }

        System.out.print(dp[K - 1]);
    }
}
