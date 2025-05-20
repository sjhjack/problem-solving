import java.io.*;
import java.util.*;

class Main {
    static class Student {
        String id;
        int count;

        public Student(String id, int count) {
            this.id = id;
            this.count = count;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        List<Student> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        int K = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        for(int i = 0; i < L; i++) {
            String id = br.readLine();
            int count = map.getOrDefault(id, 0) + 1;

            list.add(new Student(id, count));
            map.put(id, count);
        }

        int count = 0;
        for(Student student : list) {
            if(student.count == map.get(student.id)) {
                count++;
                ans.append(student.id).append("\n");
            }

            if(count == K) {
                break;
            }
        }

        System.out.print(ans);
    }
}
