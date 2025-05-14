import java.io.*;
import java.util.*;

class Main {
    static int sizeA, sizeB;
    static Set<Integer> setA, setB;
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        sizeA = Integer.parseInt(st.nextToken());
        sizeB = Integer.parseInt(st.nextToken());
        setA = new HashSet<>();
        setB = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < sizeA; i++) {
            setA.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < sizeB; i++) {
            setB.add(Integer.parseInt(st.nextToken()));
        }
    }

    static void solve() {
        List<Integer> list = new ArrayList<>();

        for(int number : setA) {
            if(!setB.contains(number)) {
                list.add(number);
            }
        }

        Collections.sort(list);

        if(list.size() > 0) {
            StringBuilder ans = new StringBuilder();
            ans.append(list.size()).append("\n");

            for(int number : list) {
                ans.append(number).append(" ");
            }

            System.out.print(ans);
        } else {
            System.out.print(0);
        }
    }
}
