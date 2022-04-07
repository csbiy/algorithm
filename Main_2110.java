import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2110 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int c = Integer.parseInt(input[1]);
        int[] houses = new int[n];
        for(int i = 0 ; i < n ; i ++ ){
            houses[i] = Integer.parseInt(br.readLine());
        }

        int lt = houses[0];
        int rt = houses[n-1];
        while(c >= 0){
            c--;

            int mid = (houses[lt] + houses[rt])/ 2;
            if(mid >= rt){

            }
        }


        // decision by

    }
}
