import java.io.*;
import java.math.BigInteger;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        BigInteger a = new BigInteger(br.readLine());
        char operator = br.readLine().charAt(0);
        BigInteger b = new BigInteger(br.readLine());

        System.out.print(operator == '+' ? a.add(b) : a.multiply(b));
    }
}