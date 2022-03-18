import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_10809 {

    /***
     * https://www.acmicpc.net/problem/10809 --?
     */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int[] result = new int[26];
        Arrays.fill(result,-1);
        for (int  i = 0 ; i < input.length() ; i ++ ){
            int idx = input.charAt(i) - 97;
            if(result[idx] != -1){
                continue;
            }
            result[idx] = i;
        }
        printArray(result);
    }

    private static void printArray(int[] result){
        for(int i = 0 ; i <result.length ; i++){
            if(i == result.length-1){
                System.out.println(result[i]);
                return;
            }
            System.out.print(result[i] +" ");
        }
    }

}
