package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_11047 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        int[] coins = new int[n];
        for(int i = 0; i < n ; i ++){
            coins[i] = Integer.parseInt(br.readLine());
        }
        int cnt = 0;
        int balance = k;
        for(int i = coins.length - 1 ; i >= 0 ; i--){
            cnt += balance / coins[i]; // 몫 추가
            balance =  balance % coins[i];
            if(balance == 0){
                System.out.println(cnt);
                return;
            }
        }
    }

}
