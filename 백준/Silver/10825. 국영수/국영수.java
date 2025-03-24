import java.io.*;
import java.util.*;

class Main {
    static class Student implements Comparable<Student> {
        String name;
        int kor;
        int eng;
        int math;

        public Student(String name, int kor, int eng, int math) {
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.math = math;
        }

        @Override
        public int compareTo(Student o) {
            if(kor == o.kor) {
                if(eng == o.eng) {
                    if(math == o.math) {
                        return name.compareTo(o.name);
                    }
                    return o.math - math;
                }
                return eng - o.eng;
            }
            return o.kor - kor;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        Student[] arr = new Student[N];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int kor = Integer.parseInt(st.nextToken());
            int eng = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());

            arr[i] = new Student(name, kor, eng, math);
        }

        Arrays.sort(arr);

        for(int i = 0; i < N; i++) {
            ans.append(arr[i].name).append("\n");
        }

        System.out.print(ans);
    }
}
