import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int[] dupArr = new int[N];
        Map<Integer, Integer> map = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            int number = Integer.parseInt(st.nextToken());
            arr[i] = number;
            dupArr[i] = number;
        }

        Arrays.sort(dupArr);
        int rank = 0;
        
        for(int i = 0; i < N; i++) {
            if(!map.containsKey(dupArr[i])) {
                map.put(dupArr[i], rank++);
            }
        }

        StringBuilder ans = new StringBuilder();

        for(int i = 0; i < N; i++) {
            ans.append(map.get(arr[i])).append(" ");
        }

        System.out.print(ans);
    }
}