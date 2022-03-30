import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1182_try {


    private static int count = 0;
    private static int s;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        s = Integer.parseInt(input[1]);
        String[] nums = br.readLine().split(" ");
        dfs(nums,0,0);
        System.out.println(count);
    }

    private static void dfs(String[] nums,int result,int idx){
        if(idx == nums.length){
            if(result == s  ){
                count++;
            }
            return;
        }

        dfs(nums,s + Integer.parseInt(nums[idx]),idx+1);
        dfs(nums,s ,idx+1);
    }
}
