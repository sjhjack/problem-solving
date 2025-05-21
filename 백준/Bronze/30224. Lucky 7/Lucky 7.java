import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean isDivisible = N % 7 == 0;
        boolean isContain7 = false;

        while(N > 0) {
            if(N % 10 == 7) {
                isContain7 = true;
                break;
            }
            N /= 10;
        }

        if(isContain7) {
            System.out.print(isDivisible ? 3 : 2);
        } else {
            System.out.print(isDivisible ? 1 : 0);
        }
    }
}