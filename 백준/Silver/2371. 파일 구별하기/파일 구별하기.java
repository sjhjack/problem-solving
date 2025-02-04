import java.io.*;
import java.util.*;

class Main {
    static List<Integer>[] files;
    static int N;
    static int maxLength;
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        files = new List[N];

        for(int i = 0; i < N; i++) {
            files[i] = new ArrayList<>();
        }

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int length = 0;

            while(st.hasMoreTokens()) {
                int number = Integer.parseInt(st.nextToken());

                if(number < 0) {
                    break;
                }

                files[i].add(number);
                length++;
            }

            maxLength = Math.max(maxLength, length);
        }
    }

    static void solve() {
        Set<Integer> duplicateFiles = new HashSet<>();

        for(int i = 0; i < N; i++) {
            duplicateFiles.add(i);
        }
        
        for(int i = 0; i < maxLength; i++) {
            Map<Integer, List<Integer>> numberMap = new HashMap<>();
            
            for(int duplicateFile : duplicateFiles) {
                int number = files[duplicateFile].size() - 1 >= i ? files[duplicateFile].get(i) : 0;
                List<Integer> list = numberMap.getOrDefault(number, new ArrayList<>());
                list.add(duplicateFile);
                numberMap.put(number, list);
            }

            for(List<Integer> list : numberMap.values()) {
                if(list.size() == 1) {
                    duplicateFiles.remove(list.get(0));
                }
            }

            if(duplicateFiles.isEmpty()) {
                System.out.print(i + 1);
                break;
            }
        }
    }
}
