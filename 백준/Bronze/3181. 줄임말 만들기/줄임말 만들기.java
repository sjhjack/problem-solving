import java.io.*;
import java.util.*; 

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        Set<String> set = Set.of("I", "PA", "TE", "NI", "NITI", "A", "ALI", "NEGO", "NO", "ILI");
        String[] arr = br.readLine().toUpperCase().split(" ");

        ans.append(arr[0].charAt(0));

        for(int i = 1; i < arr.length; i++) {
            if(set.contains(arr[i])) {
                continue;
            }

            ans.append(arr[i].charAt(0));
        }

        System.out.print(ans);
    }
}