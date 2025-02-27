import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<String> set = new HashSet<>();

        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i < N; i++) {
            String s = st.nextToken();
            
            if(s.endsWith("Cheese")) {
                set.add(s);
            }
        }

        System.out.print(set.size() >= 4 ? "yummy" : "sad");
    }
}