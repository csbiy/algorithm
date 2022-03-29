import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_1920 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] src = br.readLine().split(" ");
        int[] input = new int[n];
        for(int i = 0; i< n ; i++){
            input[i] = Integer.parseInt(src[i]);
        }
        Arrays.sort(input);
        int m = Integer.parseInt(br.readLine());
        String[] target = br.readLine().split(" ");

        for(int  i = 0 ; i < m ; i++){
            if(isContains(input,Integer.parseInt(target[i]))){
                System.out.println("1");
            }else{
                System.out.println("0");
            }
        }
    }
    // implement binary search
    private static boolean isContains(int[] sortedArray , int target) {
        return Arrays.binarySearch(sortedArray,target) >= 0;
    }
}
