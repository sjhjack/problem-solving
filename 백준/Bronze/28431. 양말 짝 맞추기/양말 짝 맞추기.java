import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < 5; i++) {
            int number = Integer.parseInt(br.readLine());

            if(set.contains(number)) {
                set.remove(number);
            } else {
                set.add(number);
            }
        }

        System.out.print(set.iterator().next());
    }
}