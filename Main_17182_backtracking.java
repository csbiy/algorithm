import java.io.*;

public class Main_17182_backtracking {

    private static int n;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        int[][] graph = new int[n][n];
        boolean[] visited = new boolean[n];
        for(int i = 0; i< n; i++){
            String[] src = br.readLine().split(" ");
            for(int j =0 ; j < n ; j++){
                graph[i][j] = Integer.parseInt(src[j]);
            }
        }
        visited[k] = true;
        dfs(graph , k , visited , 0 );
        bw.flush();
        bw.close();
        br.close();

    }

    private static void dfs(int[][] graph , int planet , boolean[] visited , int dis) {

        if(allVisited(visited)){
            return;
        }


        for(int i = 0; i < n ; i++){
            if(i!=planet){
                visited[i] = true;
                dfs(graph , i , visited , dis + graph[planet][i]);
            }
        }


    }

    private static boolean allVisited(boolean[] visited){
        for(int i = 0; i <visited.length ; i++){
            if (!visited[i]){
                return false;
            }
        }
        return true;
    }
}
