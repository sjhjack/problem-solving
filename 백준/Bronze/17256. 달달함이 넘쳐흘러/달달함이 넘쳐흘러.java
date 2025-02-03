import java.io.*;
import java.util.*;

class Main {
    static class Cake {
        int x;
        int y;
        int z;

        public Cake(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int z = Integer.parseInt(st.nextToken());
        
        Cake a = new Cake(x, y, z);

        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        z = Integer.parseInt(st.nextToken());
        
        Cake c = new Cake(x, y, z);

        System.out.print((c.x - a.z) + " " + (c.y / a.y) + " " + (c.z - a.x));
    }
}
