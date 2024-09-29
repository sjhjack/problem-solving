import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder ans = new StringBuilder();

        Set<Integer> set = new HashSet<>();
        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            if(set.contains(Integer.parseInt(st.nextToken()))) {
                ans.append("1 ");
            } else {
                ans.append("0 ");
            }
        }

        System.out.print(ans);
    }
}