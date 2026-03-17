import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String A = st.nextToken();
        String B = st.nextToken();

        int min = convert(A, '6', '5') + convert(B, '6', '5');
        int max = convert(A, '5', '6') + convert(B, '5', '6');

        System.out.print(min + " " + max);
    }

    static int convert(String s, char from, char to) {
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == from) {
                arr[i] = to;
            }
        }
        return Integer.parseInt(new String(arr));
    }
}