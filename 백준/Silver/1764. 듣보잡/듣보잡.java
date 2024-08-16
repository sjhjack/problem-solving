import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder ans = new StringBuilder();
        Set<String> set = new HashSet<>();
        ArrayList<String> list = new ArrayList<>();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        for(int i = 0; i < M; i++) {
            String s = br.readLine();
            
            if(set.contains(s)) {
                list.add(s);
            }
        }

        Collections.sort(list);

        ans.append(list.size()).append("\n");
        for(String s : list) {
            ans.append(s).append("\n");
        }
        
        System.out.print(ans);
    }
}