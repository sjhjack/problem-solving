import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        Map<String, Integer> map = new HashMap<>();
        boolean isOver = false;
        
        map.put("A", 0);
        map.put("B", 0);

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());

            switch(cmd) {
                case 1 -> {
                    String X = st.nextToken();
                    int N = Integer.parseInt(st.nextToken());
                    map.put(X, N);
                }
                case 2 -> {
                    String X = st.nextToken();
                    ans.append(map.get(X)).append("\n");
                }
                case 3 -> {
                    String X = st.nextToken();
                    String Y = st.nextToken();
                    map.put(X, map.get(X) + map.get(Y));
                }
                case 4 -> {
                    String X = st.nextToken();
                    String Y = st.nextToken();
                    map.put(X, map.get(X) * map.get(Y));
                }
                case 5 -> {
                    String X = st.nextToken();
                    String Y = st.nextToken();
                    map.put(X, map.get(X) - map.get(Y));
                }
                case 6 -> {
                    String X = st.nextToken();
                    String Y = st.nextToken();
                    map.put(X, map.get(X) / map.get(Y));
                }
                case 7 -> {
                    isOver = true;
                }
            }

            if(isOver) {
                break;
            }
        }

        System.out.print(ans);
    }
}
