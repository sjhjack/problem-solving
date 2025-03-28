import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();

        if(arr.length == 1) {
            int number = arr[0] - '0';
            
            System.out.println(0);
            System.out.print(number % 3 == 0 ? "YES" : "NO");
            
            return;
        }
        
        int X = 0;
        int count = 1;

        for(int i = 0; i < arr.length; i++) {
            X += arr[i] - '0';
        }

        while(X >= 10) {
            int tmp = 0;
            
            while(X > 0) {
                tmp += X % 10;
                X /= 10;
            }

            X = tmp;
            count++;
        }

        System.out.println(count);
        System.out.print(X % 3 == 0 ? "YES" : "NO");
    }
}
