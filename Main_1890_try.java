import java.io.*;

public class Main_1890_try {

    private static int n;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        int[][] graph = new int[n][n];
        long[][] dp = new long[n][n]; // x , y 점은 n,n 점까지의 경로 개수
        for(int i = 0; i < n ; i++ ) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(line[j]);
                dp[i][j] = -1;
            }
        }
        bw.write(  dfs(graph, dp ,0, 0)+"\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static long dfs(int[][] graph , long[][] dp ,  int x, int y ){

        if(dp[x][y] != -1){ // 이미 경로의 최댓값이 있다면 그대로 반환
            return dp[x][y];
        }
        if(x >= n-1 && y>=n-1){
            return 1;
        }

        dp[x][y] = 0;
        int dx = x + graph[x][y];
        int dy = y + graph[x][y];
        if(dx < n ){
            dp[x][y] =  Math.max( dp[x][y] ,  dp[x][y] + dfs(graph,dp, dx, y)); // 아래로 이동
        }
        if(dy < n){
            dp[x][y] = Math.max(dp[x][y] , dp[x][y] +  dfs(graph,dp,x , dy)); // 오른쪽으로 이동
        }

        return dp[x][y];
    }
}
