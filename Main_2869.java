import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2869 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);
        int v = Integer.parseInt(input[2]);
        int div = v /(a-b) ;

        System.out.println(div- b);
    }
}
