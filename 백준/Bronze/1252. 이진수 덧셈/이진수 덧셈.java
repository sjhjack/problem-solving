import java.io.*;
import java.util.*;
import java.math.BigInteger;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        BigInteger num1 = new BigInteger(st.nextToken(), 2);
        BigInteger num2 = new BigInteger(st.nextToken(), 2);

        System.out.print(num1.add(num2).toString(2));
    }
}