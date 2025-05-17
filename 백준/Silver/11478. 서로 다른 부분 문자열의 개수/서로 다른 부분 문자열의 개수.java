import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<String> set = new HashSet<>();
        
        char[] arr = br.readLine().toCharArray();
        int N = arr.length;

        for(int i = 0; i < N; i++) {
            String s = "";

            for(int j = i; j < N; j++) {
                s += arr[j];
                set.add(s);
            }
        }

        System.out.print(set.size());
    }
}
