import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_11720 {

    /***
     * https://www.acmicpc.net/problem/11720
     */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.parseInt(br.readLine());
        String input = br.readLine();
        int result = 0;
        for (int i = 0; i < n; i++) {
            result += Character.getNumericValue(input.charAt(i));
        }
        System.out.println(result);
    }

}


