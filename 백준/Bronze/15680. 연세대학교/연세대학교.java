import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        if(N == 0) System.out.print("YONSEI");
        else System.out.print("Leading the Way to the Future");
    }
}