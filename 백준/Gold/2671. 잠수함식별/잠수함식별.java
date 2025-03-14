import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String regex = "(100+1+|01)+";
        String sound = br.readLine();

        System.out.print(sound.matches(regex) ? "SUBMARINE" : "NOISE");
    }
}