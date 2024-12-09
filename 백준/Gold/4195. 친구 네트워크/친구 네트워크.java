import java.io.*;
import java.util.*;

class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder ans = new StringBuilder();

    static Map<String, Integer> groupOfName;
    static Map<Integer, List<String>> groupMembers;
    static int groupNumber;
    
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++) {
            init();
            solve();
        }
        
        System.out.print(ans);
    }

    static void init() {
        groupOfName = new HashMap<>();
        groupMembers = new HashMap<>();
        groupNumber = 0;
    }

    static void solve() throws IOException {
        int F = Integer.parseInt(br.readLine());

        for(int f = 0; f < F; f++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String person1 = st.nextToken();
            String person2 = st.nextToken();

            boolean hasGroup1 = groupOfName.containsKey(person1);
            boolean hasGroup2 = groupOfName.containsKey(person2);

            if(hasGroup1 && hasGroup2) {
                int group1 = groupOfName.get(person1);
                int group2 = groupOfName.get(person2);

                unionGroup(group1, group2);
                
                ans.append(groupMembers.get(group1).size()).append("\n");
            } else if(hasGroup1 && !hasGroup2) {
                int group = groupOfName.get(person1);
                
                groupMembers.get(group).add(person2);
                groupOfName.put(person2, group);
                
                ans.append(groupMembers.get(group).size()).append("\n");
            } else if(!hasGroup1 && hasGroup2) {
                int group = groupOfName.get(person2);
                
                groupMembers.get(group).add(person1);
                groupOfName.put(person1, group);
                
                ans.append(groupMembers.get(group).size()).append("\n");
            } else {
                groupNumber++;
                groupMembers.put(groupNumber, new ArrayList<>(List.of(person1, person2)));
                groupOfName.put(person1, groupNumber);
                groupOfName.put(person2, groupNumber);
                
                ans.append(2).append("\n");
            }
        }
    }

    static void unionGroup(int group1, int group2) {
        if(group1 == group2) {
            return;
        }
        
        List<String> members1 = groupMembers.get(group1);
        List<String> members2 = groupMembers.get(group2);

        for(String member : members2) {
            members1.add(member);
            groupOfName.put(member, group1);
        }

        groupMembers.put(group1, members1);
        groupMembers.remove(group2);
    }
}
