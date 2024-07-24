import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();

        while(true) {
            String s = br.readLine();
            
            if(s.equals("#")) {
                break;
            }

            char[] arr = s.toLowerCase().toCharArray();
            int cnt = 0;

            for(char c : arr) {
                if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    cnt++;
                }
            }

            ans.append(cnt).append("\n");
        }

        System.out.print(ans);
    }
}