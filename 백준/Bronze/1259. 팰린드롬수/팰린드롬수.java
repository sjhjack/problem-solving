import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();

        while(true) {
            String s = br.readLine();
            if(s.equals("0")) {
                break;
            }

            char[] tmp = s.toCharArray();
            boolean isPal = true;

            for(int i = 0; i < tmp.length / 2; i++) {
                if(tmp[i] != tmp[tmp.length- 1 - i]) {
                    isPal = false;
                    break;
                }
            }

            if(isPal) {
                ans.append("yes\n");
            } else {
                ans.append("no\n");
            }
        }

        System.out.print(ans);
    }
}