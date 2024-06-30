import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println(factorial(N));
    }

    static long factorial(int n){
        if (n <= 1){
            return 1;
        }

        return n*factorial(n-1);
    }
}