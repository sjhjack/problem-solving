import java.io.*;
import java.util.*;

class Main {
    static final StringBuilder ans = new StringBuilder();
    
    static int N;
    static boolean[] isVisited;
    
    public static void main(String[] args) throws IOException {
        init();
        solve(0, new ArrayList<>());
        System.out.print(ans);
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        isVisited = new boolean[N];
    }

    static void solve(int count, List<Integer> list) {
        if(count == N) {
            for(int number : list) {
                ans.append(number).append(" ");
            }
            ans.append("\n");

            return;
        }

        for(int i = 0; i < N; i++) {
            if(!isVisited[i]) {
                isVisited[i] = true;
                list.add(i + 1);
                solve(count + 1, list);

                isVisited[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }
}