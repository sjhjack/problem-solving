import java.io.*;
import java.util.*;

class Main {
    static final String[] day = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
    static final Set<Integer> set31 = Set.of(1, 3, 5, 7, 8, 10, 12);
    static final Set<Integer> set30 = Set.of(4, 6, 9, 11);
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int month = Integer.parseInt(st.nextToken());
        int date = Integer.parseInt(st.nextToken());
        int sum = date;

        for(int i = 1; i < month; i++) {
            if(set31.contains(i)) {
                sum += 31;
            } else if(set30.contains(i)) {
                sum += 30;
            } else {
                sum += 28;
            }
        }

        System.out.print(day[sum % 7]);
    }
}