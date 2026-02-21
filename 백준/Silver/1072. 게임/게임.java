import java.io.*;
import java.util.*;

/*
100*(Y+@)/(X+@) = Z+1
-> @ = {(Z+1)X - 100Y}/(99-Z);
*/

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long X = Long.parseLong(st.nextToken());
        long Y = Long.parseLong(st.nextToken());
        long Z = 100 * Y / X;

        // 99% -> 100%, 100% -> 101%는 불가능
        if(Z >= 99) {
            System.out.print(-1);
            return;
        }        

        long molecule = (Z + 1)*X - 100*Y;
        long denominator = 99 - Z;
        long alpha = molecule / denominator;

        if(molecule % denominator > 0) {
            alpha++;
        }

        System.out.print(alpha);
    }
}