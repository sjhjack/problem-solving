import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int num = 1;
        int d = 6;
        int time = 1;

        while(N > num){
            num += d * time;
            time++;
        }

        System.out.print(time);
    }
}
