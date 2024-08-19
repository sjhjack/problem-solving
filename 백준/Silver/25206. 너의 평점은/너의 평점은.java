import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Double> map = new HashMap<>();
        double totSum = 0.0;
        double scoreSum = 0.0;

        map.put("A+", 4.5);
        map.put("A0", 4.0);
        map.put("B+", 3.5);
        map.put("B0", 3.0);
        map.put("C+", 2.5);
        map.put("C0", 2.0);
        map.put("D+", 1.5);
        map.put("D0", 1.0);
        map.put("F", 0.0);

        for(int i = 0; i < 20; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            Double score = Double.parseDouble(st.nextToken());
            String grade = st.nextToken();

            if(grade.equals("P")) {
                continue;
            } else {
                scoreSum += score;
                totSum += score * map.get(grade);
            }
        }

        System.out.print(totSum / scoreSum);
    }
}