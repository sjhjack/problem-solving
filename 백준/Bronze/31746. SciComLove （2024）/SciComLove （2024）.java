import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final String string = "SciComLove";
        int N = Integer.parseInt(br.readLine());

        System.out.print(N % 2 == 0 ? string : new StringBuilder(string).reverse().toString());
    }
}