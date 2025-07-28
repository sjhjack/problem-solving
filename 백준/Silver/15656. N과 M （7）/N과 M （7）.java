import java.io.*;
import java.util.*;

class Main {
    static final StringBuilder ans = new StringBuilder();
    
    static int N, M;
    static int[] arr;
    static List<Integer> list;
    
    public static void main(String[] args) throws IOException {
        init();
        solve(0);
        System.out.print(ans);
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
    }

    static void solve(int depth) {
        if(depth == M) {
            for(int i : list) {
                ans.append(i).append(" ");
            }

            ans.append("\n");
            return;
        }

        for(int i = 0; i < N; i++) {            
            list.add(arr[i]);
            solve(depth + 1);
            list.remove(list.size() - 1);
        }
    }
}
