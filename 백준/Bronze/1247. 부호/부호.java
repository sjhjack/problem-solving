import java.io.*;
import java.math.BigInteger;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();

        for(int i = 0; i < 3; i++) {
            int N = Integer.parseInt(br.readLine());
            BigInteger sum = BigInteger.ZERO;

            for(int j = 0; j < N; j++) {
                sum = sum.add(new BigInteger(br.readLine()));
            }

            if(sum.compareTo(BigInteger.ZERO) == 0) {
                ans.append("0\n");
            } else if(sum.compareTo(BigInteger.ZERO) > 0) {
                ans.append("+\n");
            } else {
                ans.append("-\n");
            }
        }

        System.out.print(ans);
    }
}