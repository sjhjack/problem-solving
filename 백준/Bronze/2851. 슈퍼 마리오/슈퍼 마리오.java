import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;

        for(int i = 0; i < 10; i++) {
            int number = Integer.parseInt(br.readLine());
            
            if(sum + number <= 100) {
                sum += number;
            } else {
                if(100 - sum >= sum + number - 100) {
                    sum += number;
                }
                break;
            }
        }

        System.out.print(sum);
    }
}