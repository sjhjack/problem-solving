import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int reverseX = Integer.parseInt(reverse(st.nextToken()));
        int reverseY = Integer.parseInt(reverse(st.nextToken()));
        int result = Integer.parseInt(reverse(reverseX + reverseY + ""));
        
        System.out.print(result);
    }

    private static String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }
}