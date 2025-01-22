import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int attackA = Integer.parseInt(st.nextToken());
        int lifeA = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int attackB = Integer.parseInt(st.nextToken());
        int lifeB = Integer.parseInt(st.nextToken());

        while(lifeA > 0 && lifeB > 0) {
            lifeA -= attackB;
            lifeB -= attackA;
        }

        if(lifeA <= 0 && lifeB <= 0) {
            System.out.print("DRAW");
        } else if(lifeA <= 0) {
            System.out.print("PLAYER B");
        } else {
            System.out.print("PLAYER A");
        }
    }
}