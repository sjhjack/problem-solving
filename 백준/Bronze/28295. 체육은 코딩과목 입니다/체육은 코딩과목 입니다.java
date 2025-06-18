import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int dir = 0;
        
        for(int i = 0; i < 10; i++) {
            int N = Integer.parseInt(br.readLine());
            dir = (dir + N) % 4;
        }

        if(dir == 0) {
            System.out.print("N");
        } else if(dir == 1) {
            System.out.print("E");
        } else if(dir == 2) {
            System.out.print("S");
        } else if(dir == 3) {
            System.out.print("W");
        }
    }
}