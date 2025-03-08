import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char name = br.readLine().charAt(0);

        if(name == 'M') {
            System.out.print("MatKor");
        } else if(name == 'W') {
            System.out.print("WiCys");
        } else if(name == 'C') {
            System.out.print("CyKor");
        } else if(name == 'A') {
            System.out.print("AlKor");
        } else {
            System.out.print("$clear");
        }
    }
}