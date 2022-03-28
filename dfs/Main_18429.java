package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_18429 {
    /***
     *  https://www.acmicpc.net/problem/18429
     */

    private static int k;
    private static int n;
    private static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        k = Integer.parseInt(input[1]);
        String[] kits = br.readLine().split(" ");
        for ( int i = 0 ; i < n ; i++){
            boolean[] visited = new boolean[n];
            visited[i] = true;
            dfs(kits,i,500,0 ,visited);
        }
        System.out.println(cnt);
    }

    private static void dfs(String[] kits, int idx  , int weight , int day , boolean[] visited){

        int currWeight = weight - k + Integer.parseInt(kits[idx]);
        day++;
        if( currWeight < 500){
            return;
        }
        if(day == n){
            cnt++;
            return;
        }
        for(int i = 0 ; i < n ; i++){
            if(!visited[i]){
                visited[i] = true; // 방문처리
                dfs(kits,i,currWeight,day,visited);
                visited[i] = false; // backtracking (방문처리해제)
            }
        }
    }




}
