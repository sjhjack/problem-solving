import java.io.*;
import java.util.*;

class Main {
    static int N;
    static List<Integer>[] adjList;
    static List<Integer> team1, team2;

    static class Student {
        int number;
        int team;

        public Student(int number, int team) {
            this.number = number;
            this.team = team;
        }
    }
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        adjList = new List[N + 1];
        team1 = new ArrayList<>();
        team2 = new ArrayList<>();

        for(int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());

            for(int j = 0; j < count; j++) {
                adjList[i].add(Integer.parseInt(st.nextToken()));
            }
        }
    }

    static void solve() {
        Queue<Student> queue = new ArrayDeque<>();
        boolean[] isVisited = new boolean[N + 1];

        for(int i = 1; i <= N; i++) {
            if(isVisited[i]) {
                continue;
            }

            isVisited[i] = true;
            queue.add(new Student(i, 1));
            team1.add(i);

            while(!queue.isEmpty()) {
                Student cur = queue.poll();

                for(int hater : adjList[cur.number]) {
                    if(!isVisited[hater]) {
                        isVisited[hater] = true;
                        
                        if(cur.team == 1) {
                            team2.add(hater);
                            queue.add(new Student(hater, 2));
                        } else {
                            team1.add(hater);
                            queue.add(new Student(hater, 1));
                        }                        
                    }
                }
            }
        }
    }

    static void print() {
        StringBuilder ans = new StringBuilder();

        Collections.sort(team1);
        Collections.sort(team2);

        ans.append(team1.size()).append("\n");
        for(int teammate : team1) {
            ans.append(teammate).append(" ");
        }
        ans.append("\n");
        
        ans.append(team2.size()).append("\n");
        for(int teammate : team2) {
            ans.append(teammate).append(" ");
        }

        System.out.print(ans);
    }
}
