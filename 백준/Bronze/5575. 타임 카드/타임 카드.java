import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();

        for(int i = 0; i < 3; i++) {
            String[] arr = br.readLine().split(" ");
            int startTotalSeconds = getTotalSeconds(arr[0], arr[1], arr[2]);
            int endTotalSeconds = getTotalSeconds(arr[3], arr[4], arr[5]);

            ans.append(getTimeFromSecond(endTotalSeconds - startTotalSeconds)).append("\n");
        }

        System.out.print(ans);
    }

    private static int getTotalSeconds(String h, String m, String s) {
        int hour = Integer.parseInt(h);
        int minute = Integer.parseInt(m);
        int second = Integer.parseInt(s);
        
        return hour * 3600 + minute * 60 + second;
    }

    private static String getTimeFromSecond(int second) {
        int hour = second / 3600;
        second %= 3600;

        int minute = second / 60;
        second %= 60;

        return hour + " " + minute + " " + second;
    }
}
