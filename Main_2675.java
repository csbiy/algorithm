// https://www.acmicpc.net/problem/2675

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2675 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer inputNum = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < inputNum ; i++){
            String[] param = br.readLine().split(" ");
            Integer replicationNum = Integer.parseInt(param[0]);
            String target = param[1];
            for(int j = 0; j < target.length() ; j++){
                for(int k = 0; k < replicationNum ; k++) {
                    sb.append(target.charAt(j));
                }
            }
            System.out.println(sb.toString());
            sb.setLength(0);
        }
    }
}
