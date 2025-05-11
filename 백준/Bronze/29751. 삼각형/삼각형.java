import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        float W = Float.parseFloat(st.nextToken());
        float H = Float.parseFloat(st.nextToken());

        System.out.printf("%.1f", (W * H / 2));
    }
}