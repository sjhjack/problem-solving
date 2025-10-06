import java.io.*;
import java.util.*;

class Main {
    static Map<Character, Integer> map;
    static int N;
    static String arr;
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = Map.of(
            'A', Integer.parseInt("000000", 2),
            'B', Integer.parseInt("001111", 2),
            'C', Integer.parseInt("010011", 2),
            'D', Integer.parseInt("011100", 2),
            'E', Integer.parseInt("100110", 2),
            'F', Integer.parseInt("101001", 2),
            'G', Integer.parseInt("110101", 2),
            'H', Integer.parseInt("111010", 2)
        );

        N = Integer.parseInt(br.readLine());
        arr = br.readLine();
    }

    static void solve() {
        StringBuilder ans = new StringBuilder();

        for(int i = 0; i < N; i++) {
            String s = "";
            int number = 0;
            boolean dontKnow = true;

            for(int j = 0; j < 6; j++) {
                s += arr.charAt(i*6 + j);
            }

            number = Integer.parseInt(s, 2);

            for(char key : map.keySet()) {
                if(Integer.bitCount(number ^ map.get(key)) <= 1) {
                    ans.append(key);
                    dontKnow = false;
                    break;
                }
            }

            if(dontKnow) {
                System.out.print(i + 1);
                return;
            }
        }

        System.out.print(ans);
    }
}
