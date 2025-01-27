import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Set<String> memoSet = new HashSet<>();

        for(int i = 0; i < N; i++) {
            memoSet.add(br.readLine());
        }

        for(int i = 0; i < M; i++) {
            String[] keywords = br.readLine().split(",");

            for(int j = 0; j < keywords.length; j++) {
                if(memoSet.contains(keywords[j])) {
                    memoSet.remove(keywords[j]);
                }
            }

            ans.append(memoSet.size()).append("\n");
        }

        System.out.print(ans);
    }
}