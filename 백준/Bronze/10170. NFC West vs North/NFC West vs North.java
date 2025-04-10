import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder ans = new StringBuilder();

        ans.append("NFC West       W   L  T").append("\n")
            .append("-----------------------").append("\n")
            .append("Seattle        13  3  0").append("\n")
            .append("San Francisco  12  4  0").append("\n")
            .append("Arizona        10  6  0").append("\n")
            .append("St. Louis      7   9  0").append("\n")
            .append("\n")
            .append("NFC North      W   L  T").append("\n")
            .append("-----------------------").append("\n")
            .append("Green Bay      8   7  1").append("\n")
            .append("Chicago        8   8  0").append("\n")
            .append("Detroit        7   9  0").append("\n")
            .append("Minnesota      5  10  1");

        System.out.print(ans);
    }
}