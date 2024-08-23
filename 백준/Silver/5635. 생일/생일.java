import java.util.*;
import java.io.*;

class Main {
    
    static class Student implements Comparable<Student> {
        String name;
        String birthday;

        public Student(String name, String birthday) {
            this.name = name;
            this.birthday = birthday;
        }

        @Override
        public int compareTo(Student s) {
            return birthday.compareTo(s.birthday);
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        Student[] students = new Student[N];
        
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            String name = st.nextToken();
            int day = Integer.parseInt(st.nextToken());
            int month = Integer.parseInt(st.nextToken());
            int year = Integer.parseInt(st.nextToken());
            
            String birthday = "" + year + (month < 10 ? "0" + month : month) + (day < 10 ? "0" + day : day);

            students[i] = new Student(name, birthday);
        }

        Arrays.sort(students);

        System.out.print(students[N - 1].name + "\n" + students[0].name);
    }
}
