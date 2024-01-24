import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        
        String id = br.readLine();
        
        ans.append(":fan::fan::fan:\n:fan::").append(id).append("::fan:\n:fan::fan::fan:");
        
        System.out.print(ans);
    }
}