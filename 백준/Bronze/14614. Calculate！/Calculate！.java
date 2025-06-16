import java.io.*;
import java.util.*;
import java.math.BigInteger;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        BigInteger C = new BigInteger(st.nextToken());

        BigInteger remainder = C.remainder(BigInteger.valueOf(2));

        System.out.print(remainder.compareTo(BigInteger.valueOf(0)) == 0 ? A : A ^ B);
    }
}