import java.io.*;
import java.util.*;

class Main {
    static Map<Long, Long> map;
    static long N, P, Q;
    
    public static void main(String[] args) throws IOException {
        init();
        System.out.print(solve(N));
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Long.parseLong(st.nextToken());
        P = Long.parseLong(st.nextToken());
        Q = Long.parseLong(st.nextToken());

        map = new HashMap<>();
    }

    static long solve(long num) {
        if(num == 0) {
            return 1;
        }

        if(map.containsKey(num)) {
            return map.get(num);
        }

        long a = (long)Math.floor(num / P);
        long b = (long)Math.floor(num / Q);
        long result = solve(a) + solve(b);
        
        map.put(num, result);
        return result;
    }
}