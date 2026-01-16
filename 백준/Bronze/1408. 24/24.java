import java.io.*;

class Main {
    static final int ONE_DAY = 60 * 60 * 24;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        
        String[] arr = br.readLine().split(":");
        int curHour = Integer.parseInt(arr[0]);
        int curMin = Integer.parseInt(arr[1]);
        int curSec = Integer.parseInt(arr[2]);
        int curTotal = curHour*3600 + curMin*60 + curSec;

        arr = br.readLine().split(":");
        int targetHour = Integer.parseInt(arr[0]);
        int targetMin = Integer.parseInt(arr[1]);
        int targetSec = Integer.parseInt(arr[2]);
        int targetTotal = targetHour*3600 + targetMin*60 + targetSec;

        int gap = 0;

        if(targetTotal >= curTotal) {
            gap = targetTotal - curTotal;
        } else {
            gap = targetTotal + ONE_DAY - curTotal;
        }
        
        int hour = gap / 3600;
        gap %= 3600;
        int minute = gap / 60;
        gap %= 60;
        int second = gap;

        ans.append(hour >= 10 ? hour : "0" + hour).append(":")
            .append(minute >= 10 ? minute : "0" + minute).append(":")
            .append(second >= 10 ? second : "0" + second);

        System.out.print(ans);
    }
}