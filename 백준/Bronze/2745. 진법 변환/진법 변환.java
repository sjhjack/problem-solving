import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < 26; i++) {
            map.put((char)('A' + i), 10 + i);
        }

        char[] arr = st.nextToken().toCharArray();
        int B = Integer.parseInt(st.nextToken());
        int num = 1;
        int ans = 0;
        
        for(int i = arr.length - 1; i >= 0; i--) {
            int tmp = map.containsKey(arr[i]) ? map.get(arr[i]) : arr[i] - '0';
            
            ans += tmp * num;
            num *= B;
        }

        System.out.print(ans);
    }
}