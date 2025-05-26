import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();

        Map<Character, Character> map = new HashMap<>();
        map.put('b', 'd');
        map.put('d', 'b');
        map.put('p', 'q');
        map.put('q', 'p');
        map.put('i', 'i');
        map.put('o', 'o');
        map.put('v', 'v');
        map.put('w', 'w');
        map.put('x', 'x');

        while(true) {
            String s = br.readLine();

            if(s.equals("#")) {
                break;
            }

            char[] arr = s.toCharArray();
            String mirror = "";

            for(int i = arr.length - 1; i >= 0 ; i--) {
                if(map.containsKey(arr[i])) {
                    mirror += map.get(arr[i]);
                } else {
                    mirror = "INVALID";
                    break;
                }
            }

            ans.append(mirror).append("\n");
        }

        System.out.print(ans);
    }
}