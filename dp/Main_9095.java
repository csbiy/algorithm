package dp;

import java.util.Scanner;

public class Main_9095{

    private static int[] result = new int[12];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.next());
        result[1] = 1;
        result[2] = 2;
        result[3] = 4;
        for(int i = 0 ; i < t ; i++ ) {
            int input = Integer.parseInt(sc.next());
            System.out.println(getNumOfCases(input));
        }
    }
    private static int getNumOfCases(int input) {
        if(result[input] == 0){
            result[input] =  getNumOfCases(input-3) + getNumOfCases(input - 2) + getNumOfCases( input - 1);
            return result[input];
        }
        return result[input];
    }
}
