import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/status?from_mine=1&problem_id=11726&user_id=katd6
public class Main_11726 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] resultArray = new int[1001];
        resultArray[1] = 1;
        resultArray[2] = 2;
        for(int i = 3 ; i <= num ; i++){
            // int overflow 되어서 나머지값을 저장해야 정확한값이 나옴
            resultArray[i] = (resultArray[i-1] + resultArray[i-2]) % 10_007;
        }
        System.out.println(resultArray[num]);
    }
}
