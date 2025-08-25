import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<Character> happySet = Set.of('H', 'A', 'P', 'Y');
        Set<Character> sadSet = Set.of('S', 'A', 'D');
        int pH = 0;
        int pG = 0;
        
        char[] arr = br.readLine().toCharArray();

        for(int i = 0; i < arr.length; i++) {
            if(happySet.contains(arr[i])) {
                pH++;
            }

            if(sadSet.contains(arr[i])) {
                pG++;
            }
        }

        if(pH + pG == 0) {
            System.out.print("50.00");
        } else {
            System.out.printf("%.2f", (100.0F * pH / (pH + pG)) );
        }
    }
}
