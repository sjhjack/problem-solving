import java.io.*;
import java.util.*;

class Main {
    static int N;
    static List<Integer> list;
    static int ans;
    
    public static void main(String[] args) throws IOException {
        init();
        pick(list, 0);
        System.out.print(ans);
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        ans = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
    }

    static void pick(List<Integer> tmpList, int sum) {
        if(tmpList.size() == 2) {
            ans = Math.max(ans, sum);
            return;
        }

        for(int i = 1; i < tmpList.size()-1; i++) {
            int now = tmpList.get(i);
            int energy = tmpList.get(i - 1) * tmpList.get(i + 1);
            
            tmpList.remove(i);
            pick(tmpList, sum + energy);
            tmpList.add(i, now);
        }        
    }
}
