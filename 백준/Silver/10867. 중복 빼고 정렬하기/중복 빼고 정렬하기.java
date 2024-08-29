import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();

        Set<Integer> set = new HashSet<>();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        int[] list = new int[set.size()];
        int i = 0;
        for (int num : set) {
            list[i++] = num;
        }
        
        Arrays.sort(list);

        for(int num : list) {
            ans.append(num).append(" ");
        }

        System.out.print(ans);
    }
}