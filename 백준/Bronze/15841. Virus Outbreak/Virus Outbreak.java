import java.io.*;
import java.math.BigInteger;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();

        BigInteger[] arr = new BigInteger[491];

        arr[0] = BigInteger.ZERO;
        arr[1] = BigInteger.ONE;
        arr[2] = BigInteger.ONE;

        for(int i = 3; i <= 490; i++) {
            arr[i] = arr[i - 2].add(arr[i - 1]);
        }

        while(true) {
            int number = Integer.parseInt(br.readLine());

            if(number < 0) {
                break;
            }

            ans.append("Hour " + number + ": " + arr[number] + " cow(s) affected\n");
        }

        System.out.print(ans);
    }
}
