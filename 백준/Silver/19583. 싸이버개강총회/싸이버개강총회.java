import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String S = st.nextToken();
        String E = st.nextToken();
        String Q = st.nextToken();

        Set<String> startSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();

        String s = "";
        while((s = br.readLine()) != null) {
            st = new StringTokenizer(s);
            String time = st.nextToken();
            String name = st.nextToken();
            
            if(time.compareTo(S) <= 0) {
                startSet.add(name);
            } else if(time.compareTo(E) >= 0 && time.compareTo(Q) <= 0) {
                if(startSet.contains(name)) {
                    endSet.add(name);
                }
            }
        }

        System.out.print(endSet.size());
    }
}
