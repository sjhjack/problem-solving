import java.io.*;
import java.util.*;

class Main {
    static class Student implements Comparable<Student> {
        int number;
        String name;

        public Student(int number, String name) {
            this.number = number;
            this.name = name;
        }

        @Override
        public int compareTo(Student o) {
            if(number == o.number) {
                if(name.length() == o.name.length()) {
                    return name.compareTo(o.name);
                }
                
                return name.length() - o.name.length();
            }

            return number - o.number;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] count = new int[N + 1];
        PriorityQueue<Student> odd = new PriorityQueue<>();
        PriorityQueue<Student> even = new PriorityQueue<>();

        while(true) {
            String s = br.readLine();

            if(s.equals("0 0")) {
                break;
            }

            st = new StringTokenizer(s);
            int number = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            if(count[number] >= M) {
                continue;
            }

            count[number]++;

            if(number % 2 == 0) {
                even.add(new Student(number, name));
            } else {
                odd.add(new Student(number, name));
            }
        }

        while(!odd.isEmpty()) {
            Student cur = odd.poll();
            ans.append(cur.number).append(" ").append(cur.name).append("\n");
        }

        while(!even.isEmpty()) {
            Student cur = even.poll();
            ans.append(cur.number).append(" ").append(cur.name).append("\n");
        }

        System.out.print(ans);
    }
}
