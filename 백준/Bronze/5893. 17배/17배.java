import java.io.*;
import java.util.*;
import java.math.BigInteger;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger N = new BigInteger(br.readLine(), 2);
        N = N.multiply(new BigInteger("17"));

        StringBuilder ans = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        BigInteger two = new BigInteger("2");
        BigInteger zero = new BigInteger("0");

        while(N.compareTo(zero) > 0) {
            stack.add(N.remainder(two).intValue());
            N = N.divide(two);
        }

        while(!stack.isEmpty()) {
            ans.append(stack.pop());
        }
        
        System.out.println(ans);
    }
}