import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        Map<String, Integer> alpha = new HashMap<>();
        Map<Integer, String> number = new HashMap<>();
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        for(int i = 1; i <= N; i++) {
            String monster = br.readLine();

            alpha.put(monster, i);
            number.put(i, monster);
        }

        for(int i = 0; i < M; i++) {
            String s = br.readLine();
            char c = s.charAt(0);

            if('0' <= c && c <= '9') {
                ans.append(number.get(Integer.parseInt(s))).append("\n");
            } else {
                ans.append(alpha.get(s)).append("\n");
            }
        }

        System.out.print(ans);
    }
}