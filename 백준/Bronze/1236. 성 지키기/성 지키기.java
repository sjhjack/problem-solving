import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean[] isProtectedRow = new boolean[N];
        boolean[] isProtectedCol = new boolean[M];

        for(int i = 0; i < N; i++) {
            char[] arr = br.readLine().toCharArray();

            for(int j = 0; j < M; j++) {
                if(arr[j] == 'X') {
                    isProtectedRow[i] = true;
                    isProtectedCol[j] = true;
                }
            }
        }

        int rowCnt = 0;
        int colCnt = 0;
        
        for(int i = 0; i < N; i++) {
            if(!isProtectedRow[i]) rowCnt++;
        }
        
        for(int i = 0; i < M; i++) {
            if(!isProtectedCol[i]) colCnt++;
        }

        System.out.print(Math.max(rowCnt, colCnt));
    }
}