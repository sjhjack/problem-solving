import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++) {
            Set<String> set = new HashSet<>();
            String[] arr = br.readLine().split(" ");

            String s = "";
            while(!((s = br.readLine()).equals("what does the fox say?"))) {
                String[] sound = s.split(" ");

                set.add(sound[2]);
            }

            for(String sound : arr) {
                if(!set.contains(sound)) {
                    ans.append(sound).append(" ");
                }
            }
            ans.append("\n");
        }

        System.out.print(ans);
    }
}