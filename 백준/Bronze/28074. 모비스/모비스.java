import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] arr = new boolean['z'-'a'+1];

        char[] tmp = br.readLine().toCharArray();

        for(int i = 0; i < tmp.length; i++) {
            arr[tmp[i] - 'A'] = true;
        }

        if(arr['M'-'A'] && arr['O'-'A'] && arr['B'-'A'] && arr['I'-'A'] && arr['S'-'A']) {
            System.out.print("YES");
        } else {
            System.out.print("NO");
        }
    }
}