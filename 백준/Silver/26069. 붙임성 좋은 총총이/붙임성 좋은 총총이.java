import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<String> dance = new HashSet<>(Set.of("ChongChong"));
        int N = Integer.parseInt(br.readLine());
        int ans = 1;

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String first = st.nextToken();
            String second = st.nextToken();

            if(dance.contains(first) && !dance.contains(second)) {
                ans++;
                dance.add(second);
            } else if(!dance.contains(first) && dance.contains(second)) {
                ans++;
                dance.add(first);
            }
        }

        System.out.print(ans);
    }
}