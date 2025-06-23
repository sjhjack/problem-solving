import java.io.*;
import java.util.*;

class Main {
    static class Student implements Comparable<Student> {
        String name;
        int count;

        public Student(String name, int count) {
            this.name = name;
            this.count = count;
        }

        @Override
        public int compareTo(Student o) {
            if(count == o.count) {
                return name.compareTo(o.name);
            }
            return o.count - count;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        String[] names = new String[N];
        Map<String, Integer> map = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            String name = st.nextToken();
            map.put(name, i);
            names[i] = name;
        }

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()) {
                int index = map.get(st.nextToken());
                arr[index]++;
            }
        }

        PriorityQueue<Student> pq = new PriorityQueue<>();
        for(int i = 0; i < N; i++) {
            pq.add(new Student(names[i], arr[i]));
        }

        for(int i = 0; i < N; i++) {
            Student cur = pq.poll();
            ans.append(cur.name).append(" ").append(cur.count).append("\n");
        }

        System.out.print(ans);
    }
}
