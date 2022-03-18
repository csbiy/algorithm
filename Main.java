import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    /**
     * https://www.acmicpc.net/problem/1065
     *
     */
    private static int result = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.parseInt(br.readLine());
        // n 보다 작은 등차 수열의 개수를 구하는 문제임
        for ( int  i = 1 ; i < n ; i ++ ){
            isSeq(i);
        }
        System.out.println(result);
    }

    private static void isSeq(int input) {
        String strInput = String.valueOf(input);
        int interval = 0;
        boolean flag = true;
        for (int i = 0; i < strInput.length() ;i ++){
            if(i % 2 == 0 && interval != 0){
                return;
            }
            int curr = Character.getNumericValue(strInput.charAt(i));
                interval += curr;
                flag = false;
                continue;
            interval -= curr;

        }
        System.out.println("input = " + input);
        result++;
    }
}
