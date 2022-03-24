import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main_2812 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        Integer n = Integer.parseInt(input[0]); // n 자리 수
        Integer k = Integer.parseInt(input[1]); // k 개의 수
        String nums = br.readLine();
        Deque<Integer> result = new ArrayDeque<>();

        for(int i = 0; i < nums.length() ; i++ ){

            while ( k > 0 && !result.isEmpty() && result.peekLast() < Character.getNumericValue(nums.charAt(i))){
                result.pollLast();
                k--;
            }
            result.add(Character.getNumericValue(nums.charAt(i)));
        }

        printResult(result,k);
    }

    private static void printResult(Deque<Integer> result,int k ) {
        if (result.isEmpty()) {
            System.out.print("");
        }
        int idx =  0;
        int size = result.size();
        while (idx <  size - k ){
            System.out.print(result.pollFirst());
            idx++;
        }
    }
}
