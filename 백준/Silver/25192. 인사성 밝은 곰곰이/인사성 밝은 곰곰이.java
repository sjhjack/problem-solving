import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Set<String> set = null;
        int ans = 0;

        for(int i = 0; i < N; i++) {
            String s = br.readLine();

            if(s.equals("ENTER")) {
                set = new HashSet<>();
            } else if(!set.contains(s)) {
                ans++;
                set.add(s);
            }
        }

        System.out.print(ans);
    }
}