import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();

        while(true) {
            String s = br.readLine();
            if(s.equals("0")) break;

            char[] arr = s.toCharArray();

            int sum = arr.length + 1;   // 1cm

            for(char c : arr) {
                if(c == '1') {
                    sum += 2;
                } else if(c == '0') {
                    sum += 4;
                } else {
                    sum += 3;
                }
            }

            ans.append(sum).append("\n");
        }

        System.out.print(ans);
    }
}