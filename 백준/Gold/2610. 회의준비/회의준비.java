import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int M, N;
    private static List<Integer>[] adjList;
    private static List<Integer>[] groupMember;
    private static int[] groupLeader;

    private static class Node {
        int num;
        int len;

        public Node(int num, int len) {
            this.num = num;
            this.len = len;
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
        print();
    }

    private static void input() throws IOException {
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        adjList = new List[N + 1];
        groupMember = new List[N + 1];

        for(int i = 0; i <= N; i++) {
            adjList[i] = new ArrayList<>();
            groupMember[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            adjList[from].add(to);
            adjList[to].add(from);
        }
    }

    private static void solve() {
        makeGroup();
        setLeader();
    }

    private static void makeGroup() {
        boolean[] isVisited = new boolean[N + 1];
        int groupNumber = -1;


        for(int i = 1; i <= N; i++) {
            if(!isVisited[i]) {
                Queue<Integer> queue = new ArrayDeque<>();

                queue.add(i);
                isVisited[i] = true;
                groupMember[++groupNumber].add(i);

                while(!queue.isEmpty()) {
                    int cur = queue.poll();

                    for(int next : adjList[cur]) {
                        if(!isVisited[next]) {
                            isVisited[next] = true;
                            queue.add(next);
                            groupMember[groupNumber].add(next);
                        }
                    }
                }
            }
        }

        groupLeader = new int[groupNumber + 1];
    }

    private static void setLeader() {
        for(int i = 0; i < groupLeader.length; i++) {
            int max = Integer.MAX_VALUE;

            for(int leader : groupMember[i]) {
                Queue<Node> queue = new ArrayDeque<>();
                boolean[] isVisited = new boolean[N + 1];
                int leaderMax = 0;

                queue.add(new Node(leader, 0));
                isVisited[leader] = true;

                while(!queue.isEmpty()) {
                    Node cur = queue.poll();

                    for(int next : adjList[cur.num]) {
                        if(!isVisited[next]) {
                            isVisited[next] = true;
                            queue.add(new Node(next, cur.len + 1));
                            leaderMax = Math.max(leaderMax, cur.len + 1);
                        }
                    }
                }

                if(max > leaderMax) {
                    max = leaderMax;
                    groupLeader[i] = leader;
                }
            }
        }
    }

    private static void print() {
        StringBuilder ans = new StringBuilder();

        Arrays.sort(groupLeader);
        ans.append(groupLeader.length).append("\n");

        for(int i = 0; i <= groupLeader.length - 1; i++) {
            ans.append(groupLeader[i]).append("\n");
        }

        System.out.print(ans);
    }
}
