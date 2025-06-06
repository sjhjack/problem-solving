import java.io.*;
import java.math.BigInteger;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        long ans = 0L;

        for (int i = 0; i < arr.length; i++) {
        	ans = (ans * 10 + (arr[i] - '0')) % 20000303;
        }

        System.out.print(ans);
    }
}