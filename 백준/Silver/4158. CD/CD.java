import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        

        while(true) {
            String s = br.readLine();

            if(s.equals("0 0")) {
                break;
            }

            StringTokenizer st = new StringTokenizer(s);
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            
            Set<Integer> set = new HashSet<>();
            int count = 0;
            
            for(int i = 0; i < N; i++) {
                set.add(Integer.parseInt(br.readLine()));
            }
            
            for(int i = 0; i < M; i++) {
                if(set.contains(Integer.parseInt(br.readLine()))) {
                    count++;
                }
            }

            ans.append(count).append("\n");
        }
        
        System.out.print(ans);
    }
}
