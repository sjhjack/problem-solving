import java.io.*;
import java.util.*;

class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    static int N, M;
    static TreeSet<Problem> treeSet;
    static Map<Integer, Integer> map;
    
    static class Problem implements Comparable<Problem> {
        int num;
        int difficulty;

        public Problem(int num, int difficulty) {
            this.num = num;
            this.difficulty = difficulty;
        }

        @Override
        public int compareTo(Problem o) {
            if(difficulty == o.difficulty) {
                return o.num - num;
            }

            return o.difficulty - difficulty;
        }
    }
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        treeSet = new TreeSet<>();
        map = new HashMap<>();
        
        N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int difficulty = Integer.parseInt(st.nextToken());

            treeSet.add(new Problem(num, difficulty));
            map.put(num, difficulty);
        }

        M = Integer.parseInt(br.readLine());
    }

    static void solve() throws IOException {
        StringBuilder ans = new StringBuilder();

        for(int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if(command.equals("recommend")) {
                int x = Integer.parseInt(st.nextToken());

                if(x == 1) {
                    ans.append(treeSet.first().num).append("\n");
                } else if(x == -1) {
                    ans.append(treeSet.last().num).append("\n");
                }
            } else if(command.equals("add")) {
                int num = Integer.parseInt(st.nextToken());
                int difficulty = Integer.parseInt(st.nextToken());

                treeSet.add(new Problem(num, difficulty));
                map.put(num, difficulty);
            } else if(command.equals("solved")) {
                int num = Integer.parseInt(st.nextToken());
                int difficulty = map.get(num);

                treeSet.remove(new Problem(num, difficulty));
                map.remove(num);
            }
        }

        System.out.print(ans);
    }
}
