import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        
        char[] arr = br.readLine().toCharArray();
        int N = arr.length;
        int indexU = -1;
        int indexF = -1;

        for(int i = 0; i < N; i++) {
            if(arr[i] == 'U') {
                indexU = i;
                break;
            }
        }

        for(int i = N-1; i >= 0; i--) {
            if(arr[i] == 'F') {
                indexF = i;
                break;
            }
        }

        for(int i = 0; i < N; i++) {
            if(i < indexU) {
                ans.append("-");
            } else if(i == indexU) {
                ans.append("U");
            } else if(indexU < i && i < indexF) {
                ans.append("C");
            } else if(i == indexF) {
                ans.append("F");
            } else if(indexF < i) {
                ans.append("-");
            }
        }

        System.out.print(ans);
    }
}