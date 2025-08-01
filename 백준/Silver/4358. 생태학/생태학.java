import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> map = new HashMap<>();
        List<String> treeList = new ArrayList<>();
        StringBuilder ans = new StringBuilder();

        String inputTree = "";
        int totalCount = 0;
        
        while((inputTree = br.readLine()) != null) {
            totalCount++;
            
            if(map.containsKey(inputTree)) {
                map.put(inputTree, map.get(inputTree) + 1);
            } else {
                treeList.add(inputTree);
                map.put(inputTree, 1);
            }
        }

        Collections.sort(treeList);

        for(String tree : treeList) {
            float percentage = 100.0F * map.get(tree) / totalCount;
            ans.append(tree).append(" ").append(String.format("%.4f\n", percentage));
        }

        System.out.print(ans);
    }
}
