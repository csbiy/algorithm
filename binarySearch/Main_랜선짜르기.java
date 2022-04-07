package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 결정 알고리즘 특징 :  해당 범위내에 정답이 있음
 */
public class Main_랜선짜르기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        // 답의 범위는 가장 큰 랜선의 길이 ~ 1로 결정됨 --> 결정 알고리즘
        int k = Integer.parseInt(input[0]);
        int n = Integer.parseInt(input[1]);
        int[] lines = new int[k];
        int lt = 1;
        int rt = Integer.MIN_VALUE;
        for(int  i = 0 ; i < k ; i ++){
            lines[i] = Integer.parseInt(br.readLine());
            rt = Math.max(rt,lines[i]);
        }


        int mid = 0;
        int result = 0;
        while (lt<=rt){
            mid = (lt+rt)/2;
            int cnt = getCount(mid,lines); // 해당 값이 답이 될 수 있는 지 이분 탐색 수행
            if(cnt < n ){
                rt = mid - 1;
            }else{
                result = mid;
                lt = mid + 1;
            }
        }

        System.out.println(result);
    }

    public static int getCount(int size,int[] lines){
        int count = 0;
        for(int i = 0 ; i < lines.length ; i++){
            count+= lines[i]/size;
        }
        return count;
    }


}
