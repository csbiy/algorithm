import java.io.*;

public class Main_17182_dijastra {
    /***
     * 다익스트라 접근방법이나 왔던경로를 되돌아오지말라고함
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        int[][] graph = new int[n][n];
        boolean[] isVisited = new boolean[n];
        for(int i = 0; i< n; i++){
            String[] src = br.readLine().split(" ");
            for(int j =0 ; j < n ; j++){
                graph[i][j] = Integer.parseInt(src[j]);
            }
        }
        isVisited[k] = true;
        for(int i = 0; i < n-1 ; i++) {
            int minPlanet = findMinDistance(graph[k], isVisited);
            isVisited[minPlanet] = true;
            for (int j = 0; j < n; j++) {
                graph[k][j] = Math.min(graph[k][minPlanet] + graph[minPlanet][j], graph[k][j]);
            }
        }
        bw.write(getSumDistance(graph[k]) + "\n");

        bw.flush();
        bw.close();
        br.close();

    }

    private static int findMinDistance(int[] distanceVector , boolean[] isVisited ){
        int min = Integer.MAX_VALUE;
        int minIdx = -1;
        for(int i =0 ;i< distanceVector.length ; i++){
            if(min > distanceVector[i] && !isVisited[i]){
                min = distanceVector[i];
                minIdx = i;
            }
        }
        return minIdx;
    }

    private static int getSumDistance(int[] distanceVector){
        int sum = 0;
        for(int i= 0; i <distanceVector.length ; i++){
            sum+= distanceVector[i];
        }
        return sum;
    }

}
