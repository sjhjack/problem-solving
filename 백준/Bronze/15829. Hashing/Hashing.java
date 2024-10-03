import java.io.*;
import java.util.*;
import java.math.BigInteger;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());

        char[] arr = br.readLine().toCharArray();
        BigInteger ans = new BigInteger("0");

        for(int i = 0; i < length; i++) {
            ans = ans.add(BigInteger.valueOf((arr[i] - 'a') + 1).multiply(BigInteger.valueOf(31).pow(i)));
        }

        System.out.print(ans.remainder(BigInteger.valueOf(1234567891)));
    }
}